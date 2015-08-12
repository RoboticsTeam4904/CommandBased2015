package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.cmdbased.subsystems.EncodedMotor;
import org.usfirst.frc4904.cmdbased.subsystems.MotorSubsystem;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.WinchIdle;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Winch extends EncodedMotor implements MotorSubsystem {
	public Winch(Talon motor, Encoder encoder) {
		super("Winch", RobotMap.WINCH_P, RobotMap.WINCH_I, RobotMap.WINCH_D, motor, encoder);
		LiveWindow.addActuator("Winch", "PIDSubsystem Controller", getPIDController());
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new WinchIdle(this));
		setAbsoluteTolerance(RobotMap.WINCH_ERROR_MARGIN);
	}
	
	protected double returnPIDInput() {
		return encoder.getDistance();
	}
	
	protected void usePIDOutput(double speed) {
		motor.set(speed);
	}
	
	public void disable() {
		if (!getPIDController().isEnable()) {
			getPIDController().disable();
		}
	}
	
	public void enable() {
		if (getPIDController().isEnable()) {
			getPIDController().enable();
		}
	}
}
