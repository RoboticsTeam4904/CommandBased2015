package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.custom.LIDAR;
import org.usfirst.frc4904.cmdbased.subsystems.Camera;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousApproachYellowTote extends Command {
	private final Chassis chassis;
	private final Camera camera;
	private final LIDAR lidar;
	
	public AutonomousApproachYellowTote(Chassis chassis, Camera camera, LIDAR lidar) {
		super("AutonomousApproachYellowTote");
		this.chassis = chassis;
		this.camera = camera;
		this.lidar = lidar;
	}
	
	protected void initialize() {}
	
	protected void execute() {
		(new ChassisDriveCartesian(chassis, -1 * camera.getYellowTote()[0], 1)).start();
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return lidar.getCorrectedAngleDist(0) < 100;
	}
}
