package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.EncodedMotor;

public class WheelSpin extends CommandBase {
	private final EncodedMotor wheel;
	private final double speed;

	public WheelSpin(EncodedMotor wheel, double speed) {
		super("WheelSpin");
		requires(wheel);
		this.wheel = wheel;
		this.speed = speed;
	}

	protected void initialize() {
		wheel.setSetpoint(speed);
	}

	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return wheel.onTarget();
	}
}
