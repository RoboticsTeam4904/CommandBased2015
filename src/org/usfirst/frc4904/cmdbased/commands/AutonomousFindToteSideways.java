package org.usfirst.frc4904.cmdbased.commands;


import edu.wpi.first.wpilibj.command.Scheduler;

public class AutonomousFindToteSideways extends CommandBase {
	public AutonomousFindToteSideways() {
		super("AutonomousFindToteSideways");
	}
	
	protected void initialize() {}
	
	protected void execute() {
		Scheduler.getInstance().add(new ChassisDriveCartesian(1, 0));
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return lidar.getDists()[0] < 100;
	}
}
