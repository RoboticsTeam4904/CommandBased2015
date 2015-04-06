package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.EncodedMotor;
import edu.wpi.first.wpilibj.command.Command;

public class WheelSpin extends Command {
	private final EncodedMotor wheel;
	private final double speed;
	
	public WheelSpin(EncodedMotor wheel, double speed) {
		super("WheelSpin");
		this.wheel = wheel;
		this.speed = speed;
		requires(wheel);
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
