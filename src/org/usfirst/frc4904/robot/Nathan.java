package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.cmdbased.Driver;
import org.usfirst.frc4904.robot.commands.Kill;

public class Nathan extends Driver {
	public Nathan() {
		super("Nathan");
		// Bind driver buttons to commands
		DriverStationMap.xbox.back.whenPressed(new Kill());
	}
}
