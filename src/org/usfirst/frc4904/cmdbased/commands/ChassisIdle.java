package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisIdle extends CommandGroup {
	public ChassisIdle(Chassis chassis) {
		super("ChassisIdle");
		requires(chassis);
		setInterruptible(true); // default command
		addParallel(new WheelIdle(chassis.frontLeftWheel));
		addParallel(new WheelIdle(chassis.frontRightWheel));
		addParallel(new WheelIdle(chassis.backLeftWheel));
		addParallel(new WheelIdle(chassis.backRightWheel));
	}
}
