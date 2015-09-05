package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.standard.commands.Kill;
import org.usfirst.frc4904.standard.commands.chassis.ChassisIdle;
import org.usfirst.frc4904.standard.humaninterface.Driver;

public class Nathan extends Driver {
	public Nathan() {
		super("Nathan"); // Supernathan!
	}
	
	public void bindCommands() {
		DriverStationMap.xbox.back.toggleWhenPressed(new Kill(new ChassisIdle(RobotMap.chassis)));
	}
}
