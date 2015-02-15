package org.usfirst.frc4904.cmdbased.subsystems;


import org.usfirst.frc4904.cmdbased.custom.SuperEncoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class EncodedMotor extends PIDSubsystem {
	protected final SpeedController motor;
	protected final SuperEncoder encoder;
	
	public EncodedMotor(String name, double P, double I, double D, SpeedController motor, SuperEncoder encoder) {
		super(name, P, I, D);
		this.motor = motor;
		this.encoder = encoder;
		getPIDController().setOutputRange(-1, 1);
	}

	protected void initDefaultCommand() {}

	protected double returnPIDInput() {
		return encoder.currentEncoderSpeed();
	}

	protected void usePIDOutput(double speed) {
		motor.set(speed);
	}
}