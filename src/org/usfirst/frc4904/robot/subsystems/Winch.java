package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.cmdbased.commands.motor.MotorIdle;
import org.usfirst.frc4904.cmdbased.subsystems.motor.EncodedMotor;
import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Winch extends EncodedMotor {
	public Winch(Talon motor, Encoder encoder) {
		super("Winch", RobotMap.WINCH_P, RobotMap.WINCH_I, RobotMap.WINCH_D, motor, encoder);
		LiveWindow.addActuator("Winch", "PIDSubsystem Controller", getPIDController());
		setInputRange(RobotMap.WINCH_MIN_HEIGHT * RobotMap.TICK_PER_HALFTOTE, RobotMap.WINCH_MAX_HEIGHT * RobotMap.TICK_PER_HALFTOTE);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new MotorIdle(this));
		setAbsoluteTolerance(RobotMap.WINCH_ERROR_MARGIN);
	}
	
	protected double returnPIDInput() {
		return encoder.getDistance();
	}
	
	public void setHeight(double height) {
		setSetpoint(height);
	}
}
