package org.usfirst.frc4904.cmdbased.commands;


import edu.wpi.first.wpilibj.command.Scheduler;

public class AutonomousApproachYellowTote extends CommandBase {
	public AutonomousApproachYellowTote() {
		super("AutonomousApproachYellowTote");
	}
	
	protected void initialize() {}
	
	protected void execute() {
		Scheduler.getInstance().add(new ChassisDriveCartesian(-1 * camera.getYellowTote()[0], 1));
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return !(lidar.getXY(0)[0] < 100 && lidar.getXY(1)[0] < 100 && lidar.getXY(359)[0] < 100); // There is probably a better way to do this
	}
}
