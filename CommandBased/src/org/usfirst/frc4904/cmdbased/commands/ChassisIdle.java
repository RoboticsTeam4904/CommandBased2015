package org.usfirst.frc4904.cmdbased.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisIdle extends CommandGroup {
	public ChassisIdle() {
		super("ChassisIdle");
		requires(CommandBase.chassis);
		addParallel(new WheelIdle(CommandBase.chassis.frontLeftWheel));
		addParallel(new WheelIdle(CommandBase.chassis.frontRightWheel));
		addParallel(new WheelIdle(CommandBase.chassis.backLeftWheel));
		addParallel(new WheelIdle(CommandBase.chassis.backRightWheel));
	}
	
	public boolean isInterruptible() {
		return true; // default command
	}
}
