package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.standard.commands.chassis.ChassisIdle;
import org.usfirst.frc4904.standard.subsystems.chassis.MecanumChassis;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class Chassis2015 extends MecanumChassis {
	public Chassis2015(Motor frontLeftWheel, Motor frontRightWheel, Motor backLeftWheel, Motor backRightWheel) {
		super("MecanumChassis", frontLeftWheel, frontRightWheel, backLeftWheel, backRightWheel);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ChassisIdle(this));
	}
}
