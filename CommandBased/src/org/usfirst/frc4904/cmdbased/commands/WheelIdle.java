package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.EncodedMotor;

public class WheelIdle extends CommandBase {
	private final EncodedMotor wheel;
	
	public WheelIdle(EncodedMotor wheel) {
		super("WheelIdle");
		requires(wheel);
		this.wheel = wheel;
	}
	
	protected void initialize() {
		wheel.getPIDController().reset(); // resets accumulated PID values and disables
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
