package org.usfirst.frc4904.cmdbased.commands;


public class GrabberIdle extends CommandBase {
	public GrabberIdle() {
		super("GrabberIdle");
		requires(grabber);
	}

	protected void initialize() {
		grabber.set(0);
	}

	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false; // default command
	}
	
	public boolean isInterruptible() {
		return true; // default command
	}
}
