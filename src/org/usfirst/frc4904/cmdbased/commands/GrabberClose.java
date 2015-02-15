package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.RobotMap;

public class GrabberClose extends CommandBase {
	public GrabberClose() {
		super("GrabberClose");
		requires(grabber);
	}
	
	protected void initialize() {
		grabber.set(RobotMap.GRABBER_CLOSE_SPEED);
	}

	protected void execute() {}

	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return grabber.isInnerSwitchPressed();
	}
}
