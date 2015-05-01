package org.usfirst.frc4904.cmdbased2015.commands;


import org.usfirst.frc4904.cmdbased.commands.ChassisIdle;
import org.usfirst.frc4904.cmdbased2015.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Kill extends CommandGroup {
	public Kill() {
		super("Kill");
		setInterruptible(false); // should kill robot forever
		addParallel(new ChassisIdle(RobotMap.chassis));
		addParallel(new WinchIdle());
		addParallel(new GrabberIdle());
	}
}
