package org.usfirst.frc4904.cmdbased;


import org.usfirst.frc4904.cmdbased.commands.Kill;

public class Nathan extends Driver {
	public Nathan() {
		super("Nathan");
		// Bind driver buttons to commands
		DriverStationMap.xbox.back.whenPressed(new Kill());
	}
}
