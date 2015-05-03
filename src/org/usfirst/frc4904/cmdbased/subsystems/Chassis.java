package org.usfirst.frc4904.cmdbased.subsystems;


import org.usfirst.frc4904.cmdbased.commands.ChassisIdle;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class Chassis extends Subsystem {
	public final Motor frontLeftWheel;
	public final Motor frontRightWheel;
	public final Motor backLeftWheel;
	public final Motor backRightWheel;
	
	public Chassis(String name, Motor frontLeftWheel, Motor frontRightWheel, Motor backLeftWheel, Motor backRightWheel) {
		super(name);
		this.frontLeftWheel = frontLeftWheel;
		this.frontRightWheel = frontRightWheel;
		this.backLeftWheel = backLeftWheel;
		this.backRightWheel = backRightWheel;
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ChassisIdle(this));
	}
	
	public void move(double xSpeed, double ySpeed, double turnSpeed) {}
	
	public void move(double speed, double angle) {}
}
