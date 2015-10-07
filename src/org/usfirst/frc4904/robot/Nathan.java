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
	
	@Override
	public double getX() {
		return DriverStationMap.xbox.leftStick.getX();
	}
	
	@Override
	public double getY() {
		return DriverStationMap.xbox.leftStick.getY();
	}
	
	@Override
	public double getTurnSpeed() {
		return DriverStationMap.xbox.rightStick.getX();
	}
}
