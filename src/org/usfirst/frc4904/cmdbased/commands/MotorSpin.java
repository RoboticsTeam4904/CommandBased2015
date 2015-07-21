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
	
	/**
	 * The motor pipe is set to control the speed of the motor
	 */
	public void writePipe(double[] data) {
		speed = data[0];
	}
	
	/**
	 * Motors can only spin, so there are no modes
	 */
	public void setPipe(int mode) {}
	
	/**
	 * Spins the motor at the speed set by writePipe
	 */
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
