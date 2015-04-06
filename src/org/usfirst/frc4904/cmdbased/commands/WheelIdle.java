package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.EncodedMotor;
import edu.wpi.first.wpilibj.command.Command;

public class WheelIdle extends Command {
	private final EncodedMotor wheel;
	
	public WheelIdle(EncodedMotor wheel) {
		super("WheelIdle");
		this.wheel = wheel;
		requires(wheel);
	}
	
	protected void initialize() {
		setInterruptible(true); // default command
		wheel.getPIDController().reset(); // resets accumulated PID values and disables
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false; // default command
	}
}
