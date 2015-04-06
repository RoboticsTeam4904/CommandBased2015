package org.usfirst.frc4904.cmdbased.subsystems;


import org.usfirst.frc4904.cmdbased.RobotMap;
import org.usfirst.frc4904.cmdbased.commands.WinchIdle;
import org.usfirst.frc4904.cmdbased.custom.SuperEncoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Winch extends EncodedMotor {
	public Winch(Talon motor, SuperEncoder encoder) {
		super("Winch", RobotMap.WINCH_P, RobotMap.WINCH_I, RobotMap.WINCH_D, motor, encoder);
		LiveWindow.addActuator("Winch", "PIDSubsystem Controller", getPIDController());
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new WinchIdle(this));
		setAbsoluteTolerance(RobotMap.WINCH_ERROR_MARGIN);
	}
	
	protected double returnPIDInput() {
		return encoder.getTicks();
	}
	
	protected void usePIDOutput(double speed) {
		motor.set(speed);
	}
}
