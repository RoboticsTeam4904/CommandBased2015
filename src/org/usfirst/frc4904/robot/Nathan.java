package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.cmdbased.commands.Kill;
import org.usfirst.frc4904.cmdbased.commands.chassis.ChassisIdle;
import org.usfirst.frc4904.cmdbased.humaninterface.Driver;

public class Nathan extends Driver {
	public Nathan() {
		super("Nathan"); // Supernathan!
	}
	
	public void bindCommands() {
		DriverStationMap.xbox.back.toggleWhenPressed(new Kill(new ChassisIdle(RobotMap.chassis)));
	}
}
