package org.usfirst.frc4904.cmdbased.commands;


import java.util.Vector;
import org.usfirst.frc4904.cmdbased.RobotMap;
import org.usfirst.frc4904.cmdbased.custom.ParticleReport;
import org.usfirst.frc4904.cmdbased.subsystems.Camera;
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ImageType;
import edu.wpi.first.wpilibj.command.Command;

public class CameraUpdate extends Command {
	private final Camera camera;
	
	public CameraUpdate(Camera camera) {
		super("CameraUpdate");
		this.camera = camera;
		requires(camera);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		NIVision.IMAQdxGrab(camera.cameraSession, camera.frame, 1);
		camera.server.setImage(camera.frame);
		// Create simple image
		Image binaryFrame = NIVision.imaqCreateImage(ImageType.IMAGE_U8, 0);
		// Threshold image
		NIVision.imaqColorThreshold(binaryFrame, camera.frame, 255, NIVision.ColorMode.HSV, RobotMap.CAMERA_TOTE_HUE_RANGE, RobotMap.CAMERA_TOTE_SAT_RANGE, RobotMap.CAMERA_TOTE_VAL_RANGE);
		// Get yellow (thresholed) particle count
		int imaqError = NIVision.imaqParticleFilter4(binaryFrame, binaryFrame, camera.criteria, camera.filterOptions, null);
		int numParticles = NIVision.imaqCountParticles(binaryFrame, 1);
		// If there is no yellow, there is no tote
		if (numParticles <= 0) {
			return;
		}
		// Find the biggest tote!
		Vector<ParticleReport> particles = new Vector<ParticleReport>();
		for (int pI = 0; pI < numParticles; pI++) {
			ParticleReport par = new ParticleReport();
			par.PercentAreaToImageArea = NIVision.imaqMeasureParticle(binaryFrame, pI, 0, NIVision.MeasurementType.MT_AREA_BY_IMAGE_AREA);
			par.Area = NIVision.imaqMeasureParticle(binaryFrame, pI, 0, NIVision.MeasurementType.MT_AREA);
			par.BoundingRectTop = NIVision.imaqMeasureParticle(binaryFrame, pI, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_TOP);
			par.BoundingRectLeft = NIVision.imaqMeasureParticle(binaryFrame, pI, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_LEFT);
			par.BoundingRectBottom = NIVision.imaqMeasureParticle(binaryFrame, pI, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_BOTTOM);
			par.BoundingRectRight = NIVision.imaqMeasureParticle(binaryFrame, pI, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_RIGHT);
			particles.add(par);
		}
		particles.sort(null);// I find it easy to believe that this will work in any way
		ParticleReport tote = particles.get(0);
		// Actually get center
		RobotMap.camera.toteCoord[0] = (tote.BoundingRectRight + tote.BoundingRectLeft) / 2;
		RobotMap.camera.toteCoord[1] = (tote.BoundingRectTop + tote.BoundingRectBottom) / 2;
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false; // default command
	}
	
	public boolean isInterruptible() {
		return false; // should always run
	}
}
