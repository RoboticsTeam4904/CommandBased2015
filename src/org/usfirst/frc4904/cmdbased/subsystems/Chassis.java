package org.usfirst.frc4904.cmdbased.subsystems;


import org.usfirst.frc4904.cmdbased.commands.ChassisIdle;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {
	public final EncodedMotor frontLeftWheel;
	public final EncodedMotor frontRightWheel;
	public final EncodedMotor backLeftWheel;
	public final EncodedMotor backRightWheel;
	
	public Chassis(EncodedMotor frontLeftWheel, EncodedMotor frontRightWheel, EncodedMotor backLeftWheel, EncodedMotor backRightWheel) {
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
