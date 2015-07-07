package org.usfirst.frc4904.cmdbased.subsystems.chassis;


import org.usfirst.frc4904.cmdbased.subsystems.Motor;

public class SwerveChassis extends FourWheelChassis {
	public final Motor frontLeftWheelSwerve;
	public final Motor frontRightWheelSwerve;
	public final Motor backLeftWheelSwerve;
	public final Motor backRightWheelSwerve;
	
	public SwerveChassis(String name, Motor frontLeftWheel, Motor frontRightWheel, Motor backLeftWheel, Motor backRightWheel, Motor frontLeftWheelSwerve, Motor frontRightWheelSwerve, Motor backLeftWheelSwerve, Motor backRightWheelSwerve) {
		super(name, frontLeftWheel, frontRightWheel, backLeftWheel, backRightWheel);
		this.frontLeftWheelSwerve = frontLeftWheelSwerve;
		this.frontRightWheelSwerve = frontRightWheelSwerve;
		this.backLeftWheelSwerve = backLeftWheelSwerve;
		this.backRightWheelSwerve = backRightWheelSwerve;
	}
}
