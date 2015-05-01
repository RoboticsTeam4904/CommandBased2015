package org.usfirst.frc4904.cmdbased2015.subsystems;


import org.usfirst.frc4904.cmdbased.commands.ChassisIdle;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import org.usfirst.frc4904.cmdbased.subsystems.EncodedMotor;

public class Chassis2015 extends Chassis {
	public final EncodedMotor frontLeftWheel;
	public final EncodedMotor frontRightWheel;
	public final EncodedMotor backLeftWheel;
	public final EncodedMotor backRightWheel;
	
	public Chassis2015(EncodedMotor frontLeftWheel, EncodedMotor frontRightWheel, EncodedMotor backLeftWheel, EncodedMotor backRightWheel) {
		super("MecanumChassis");
		this.frontLeftWheel = frontLeftWheel;
		this.frontRightWheel = frontRightWheel;
		this.backLeftWheel = backLeftWheel;
		this.backRightWheel = backRightWheel;
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ChassisIdle(this));
	}
}
