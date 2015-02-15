package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.RobotMap;

public class GrabberOpen extends CommandBase {
	public GrabberOpen() {
		super("GrabberOpen");
		requires(grabber);
	}
	
	protected void initialize() {
		grabber.set(RobotMap.GRABBER_OPEN_SPEED);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return grabber.isOuterSwitchPressed();
	}
}
