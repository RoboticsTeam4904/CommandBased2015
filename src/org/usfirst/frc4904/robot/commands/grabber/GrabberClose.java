package org.usfirst.frc4904.robot.commands.grabber;


import org.usfirst.frc4904.cmdbased.custom.sensors.PDP;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Grabber;
import org.usfirst.frc4904.robot.subsystems.LimitSwitchSystem;

public class GrabberClose extends GrabberCommand {
	public GrabberClose(Grabber grabber, PDP pdp, LimitSwitchSystem limitSwitches) {
		super("GrabberClose", grabber, pdp, limitSwitches);
	}
	
	protected void initialize() {
		grabber.set(RobotMap.GRABBER_CLOSE_SPEED);
	}
	
	protected void interrupted() {
		end();
	}
	
	protected void end() {
		grabber.set(RobotMap.GRABBER_HOLD_SPEED);
	}
}
