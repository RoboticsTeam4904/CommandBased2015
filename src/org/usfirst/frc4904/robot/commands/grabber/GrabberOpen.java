package org.usfirst.frc4904.robot.commands.grabber;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Grabber;
import org.usfirst.frc4904.standard.custom.sensors.PDP;

public class GrabberOpen extends GrabberCommand {
	public GrabberOpen(Grabber grabber, PDP pdp) {
		super("GrabberOpen", grabber, pdp);
	}
	
	protected void initialize() {
		grabber.set(RobotMap.GRABBER_OPEN_SPEED);
	}
	
	protected void interrupted() {
		end();
	}
	
	protected void end() {
		grabber.set(RobotMap.GRABBER_IDLE_SPEED);
	}
	
	protected boolean isFinished() {
		if (pdp.getCurrent(RobotMap.GRABBER_PDP_PORT) > RobotMap.GRABBER_MAX_AMPS) {
			logger.v("Grabber Open");
		}
		return pdp.getCurrent(RobotMap.GRABBER_PDP_PORT) > RobotMap.GRABBER_MAX_AMPS;
	}
}
