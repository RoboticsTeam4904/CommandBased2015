package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.Grabber;
import org.usfirst.frc4904.cmdbased.subsystems.Winch;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousIdle extends CommandGroup {
	public AutonomousIdle(Grabber grabber, Winch winch) {
		super("AutonomousIdle");
		addParallel(new GrabberIdle(grabber));
		addParallel(new WinchIdle(winch));
	}
}