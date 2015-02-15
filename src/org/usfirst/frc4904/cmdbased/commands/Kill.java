package org.usfirst.frc4904.cmdbased.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class Kill extends CommandGroup {
	public Kill() {
		super("Kill");
		requires(CommandBase.chassis);
		requires(CommandBase.winch);
		requires(CommandBase.grabber);
		addParallel(new ChassisIdle());
		addParallel(new WinchIdle());
		addParallel(new GrabberIdle());
	}
	
	public boolean isInterruptible() {
		return false; // should kill robot forever
	}
}
