package org.usfirst.frc4904.cmdbased.commands;


import edu.wpi.first.wpilibj.command.Scheduler;

public class AutonomousChargeUntilBarrier extends CommandBase {
	protected void initialize() {}
	
	protected void execute() {
		Scheduler.getInstance().add(new ChassisDrive(1, 0));
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return lidar.getDists()[90] < 100;
	}
}
