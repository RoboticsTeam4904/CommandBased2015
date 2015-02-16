package org.usfirst.frc4904.cmdbased.subsystems;


import org.usfirst.frc4904.cmdbased.RobotMap;
import org.usfirst.frc4904.cmdbased.commands.CameraUpdate;
import org.usfirst.frc4904.cmdbased.custom.ParticleReport;
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem {
	public CameraServer server;
	public int cameraSession;
	public Image frame;
	public double[] toteCoord = new double[2];
	public NIVision.ParticleFilterCriteria2 criteria[] = new NIVision.ParticleFilterCriteria2[1];
	public NIVision.ParticleFilterOptions2 filterOptions = new NIVision.ParticleFilterOptions2(0, 0, 1, 1);
	
	public Camera() {
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		cameraSession = NIVision.IMAQdxOpenCamera(RobotMap.CAMERA_NAME, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		NIVision.IMAQdxConfigureGrab(cameraSession);
		server = CameraServer.getInstance();
		server.setQuality(20);
		criteria[0] = new NIVision.ParticleFilterCriteria2(NIVision.MeasurementType.MT_AREA_BY_IMAGE_AREA, RobotMap.CAMERA_AREA_MINIMUM, 100.0, 0, 0);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new CameraUpdate());
	}
	
	public double[] getYellowTote() { // This function will return the x, y coordinates of the center of the yellow tote.
		return toteCoord; // It uses logic.
	}
	
	// Comparator function for sorting particles. Returns true if particle 1 is larger
	private boolean CompareParticleSizes(ParticleReport particle1, ParticleReport particle2) {
		// we want descending sort order
		return particle1.PercentAreaToImageArea > particle2.PercentAreaToImageArea;
	}
	
	// Method to score if the aspect ratio of the particle appears to match the retro-reflective target. Target is 7"x7" so aspect should be 1
	private double AspectScore(ParticleReport report) {
		return ratioToScore(((report.BoundingRectRight - report.BoundingRectLeft) / (report.BoundingRectBottom - report.BoundingRectTop)));
	}
	
	private double ratioToScore(double ratio) {
		return (Math.max(0, Math.min(100 * (1 - Math.abs(1 - ratio)), 100)));
	}
}
