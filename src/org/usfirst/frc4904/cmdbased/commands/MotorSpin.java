package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.Motor;
import edu.wpi.first.wpilibj.command.Command;

public class MotorSpin extends Command {
	private final Motor motor;
	private final double speed;
	
	public MotorSpin(Motor motor, double speed) {
		super("WheelSpin");
		this.motor = motor;
		this.speed = speed;
	}
	
	protected void initialize() {
		requires(motor);
		motor.set(speed);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return true;
	}
}
