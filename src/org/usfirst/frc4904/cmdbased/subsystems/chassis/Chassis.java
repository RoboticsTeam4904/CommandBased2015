package org.usfirst.frc4904.cmdbased.subsystems.chassis;


import org.usfirst.frc4904.cmdbased.commands.chassis.ChassisIdle;
import org.usfirst.frc4904.cmdbased.subsystems.Motor;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class Chassis extends Subsystem {
	protected int numberWheels;
	
	public Chassis(String name) {
		super(name);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ChassisIdle(this));
	}
	
	public int getNumberWheels() {
		return numberWheels;
	}
	
	public abstract Motor[] getMotors();
}