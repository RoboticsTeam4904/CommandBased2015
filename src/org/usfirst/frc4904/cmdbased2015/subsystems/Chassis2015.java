package org.usfirst.frc4904.cmdbased2015.subsystems;


import org.usfirst.frc4904.cmdbased.commands.ChassisIdle;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import org.usfirst.frc4904.cmdbased.subsystems.Motor;

public class Chassis2015 extends Chassis {
	public Chassis2015(Motor frontLeftWheel, Motor frontRightWheel, Motor backLeftWheel, Motor backRightWheel) {
		super("MecanumChassis", frontLeftWheel, frontRightWheel, backLeftWheel, backRightWheel);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ChassisIdle(this));
	}
}
