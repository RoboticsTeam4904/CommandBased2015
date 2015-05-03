package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.Motor;
import edu.wpi.first.wpilibj.command.Command;

public class MotorIdle extends Command {
	private final Motor motor;
	
	public MotorIdle(Motor motor) {
		super("MotorIdle");
		this.motor = motor;
	}
	
	protected void initialize() {
		requires(motor);
		setInterruptible(true); // default command
		motor.set(0);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false; // default command
	}
}
