package org.usfirst.frc4904.cmdbased.commands.motor;


import org.usfirst.frc4904.cmdbased.OutPipable;
import org.usfirst.frc4904.logkitten.LogKitten;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MotorOutPipe extends Command implements OutPipable {
	private final SpeedController motor;
	private final LogKitten logger;
	private double speed;
	
	/**
	 * This command drives the motor at a variable speed via a pipe
	 * 
	 * @param motor
	 */
	public <A extends Subsystem & SpeedController> MotorOutPipe(A motor) {
		super("MotorOutPipe");
		this.motor = motor;
		speed = 0;
		logger = new LogKitten(LogKitten.LEVEL_VERBOSE, LogKitten.LEVEL_VERBOSE);
		logger.v("MotorOutPipe created");
		requires(motor);
		setInterruptible(true);
	}
	
	protected void initialize() {
		logger.v("MotorOutPipe initialized");
	}
	
	public void writePipe(double[] data) {
		speed = data[0];
	}
	
	public void setPipe(int mode) {}
	
	/**
	 * Spins the motor at the speed set by writePipe
	 */
	protected void execute() {
		motor.set(speed);
		logger.d("MotorOutPipe executing with speed " + Double.toString(speed));
	}
	
	protected void end() {
		motor.set(0);
		logger.v("MotorOutPipe ended (motor speed set to 0)");
	}
	
	protected void interrupted() {
		logger.w("MotorOutPipe interupted (motor speed undefined)");
	}
	
	protected boolean isFinished() {
		return false;
	}
}
