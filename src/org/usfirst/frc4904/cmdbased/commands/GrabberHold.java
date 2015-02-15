package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.RobotMap;

public class GrabberHold extends CommandBase {
	public GrabberHold() {
		super("GrabberHold");
		requires(grabber);
	}

	protected void initialize() {
		grabber.set(RobotMap.GRABBER_HOLD_SPEED);
	}
	
	protected void execute() {}
	
	protected void end() {}

	protected void interrupted() {}

	protected boolean isFinished() {
		return false;
	}
	
	public boolean isInterruptible() {
		return true;
	}
}
