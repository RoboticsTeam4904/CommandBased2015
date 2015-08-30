package org.usfirst.frc4904.robot.commands.grabber;


import org.usfirst.frc4904.cmdbased.custom.sensors.PDP;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Grabber;

public class GrabberClose extends GrabberCommand {
	public GrabberClose(Grabber grabber, PDP pdp) {
		super("GrabberClose", grabber, pdp);
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
	
	protected boolean isFinished() {
		if (pdp.getCurrent(RobotMap.GRABBER_PDP_PORT) > RobotMap.GRABBER_MAX_AMPS) {
			logger.v("Grabber Closed", true);
		}
		return pdp.getCurrent(RobotMap.GRABBER_PDP_PORT) > RobotMap.GRABBER_MAX_AMPS;
	}
}
