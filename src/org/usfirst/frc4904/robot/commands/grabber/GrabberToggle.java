package org.usfirst.frc4904.robot.commands.grabber;


import org.usfirst.frc4904.cmdbased.custom.sensors.PDP;
import org.usfirst.frc4904.robot.subsystems.Grabber;
import org.usfirst.frc4904.robot.subsystems.LimitSwitchSystem;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GrabberToggle extends CommandGroup {
	public static boolean open = true;
	
	public GrabberToggle(Grabber grabber, PDP pdp, LimitSwitchSystem limitSwitches) {
		super("GrabberToggle");
		if (open) {
			addSequential(new GrabberClose(grabber, pdp, limitSwitches));
			open = false;
		} else {
			addSequential(new GrabberOpen(grabber, pdp, limitSwitches));
			open = true;
		}
	}
}
