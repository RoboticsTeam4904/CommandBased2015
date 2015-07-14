package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.OutPipable;
import org.usfirst.frc4904.cmdbased.subsystems.Motor;
import edu.wpi.first.wpilibj.command.Command;

public class MotorSpin extends Command implements OutPipable {
	private final Motor motor;
	private double speed;
	
	public MotorSpin(Motor motor) {
		super("WheelSpin");
		this.motor = motor;
		speed = 0;
	}
	
	protected void initialize() {
		requires(motor);
	}
	
	public void writePipe(double[] data) {
		speed = data[0];
	}
	
	protected void execute() {
		motor.set(speed);
	}
	
	protected void end() {
		motor.set(0);
	}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return true;
	}
}
