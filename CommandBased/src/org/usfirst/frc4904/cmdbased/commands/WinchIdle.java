package org.usfirst.frc4904.cmdbased.commands;


public class WinchIdle extends CommandBase {
	public WinchIdle() {
		super("WinchIdle");
		requires(winch);
	}
	
	protected void initialize() {
		winch.getPIDController().reset(); // resets accumulated PID values and disables
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
