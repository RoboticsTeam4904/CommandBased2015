package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.cmdbased.Driver;
import org.usfirst.frc4904.cmdbased.commands.Kill;
import org.usfirst.frc4904.cmdbased.commands.chassis.ChassisIdle;

public class Nathan extends Driver {
	public Nathan() {
		super("Nathan");
		DriverStationMap.xbox.back.toggleWhenPressed(new Kill(new ChassisIdle(RobotMap.chassis)));
	}
}
