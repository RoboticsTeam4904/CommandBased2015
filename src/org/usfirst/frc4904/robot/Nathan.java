package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.cmdbased.Driver;
import org.usfirst.frc4904.cmdbased.commands.chassis.ChassisIdle;
import org.usfirst.frc4904.robot.commands.Kill;

public class Nathan extends Driver {
	public Nathan() {
		super("Nathan");
		DriverStationMap.xbox.back.toggleWhenPressed(new Kill(new ChassisIdle(RobotMap.chassis)));
	}
}
