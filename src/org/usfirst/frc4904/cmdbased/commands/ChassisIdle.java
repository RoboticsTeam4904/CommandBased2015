package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.chassis.Chassis;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisIdle extends CommandGroup {
	private final Chassis chassis;
	
	public ChassisIdle(Chassis chassis) {
		super("ChassisIdle");
		this.chassis = chassis;
		setInterruptible(true); // default command
	}
	
	public void initialize() {
		requires(chassis);
	}
}
