package org.usfirst.frc4904.cmdbased.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousIdle extends CommandGroup {
	public AutonomousIdle() {
		addParallel(new GrabberIdle());
		addParallel(new WinchIdle());
	}
}