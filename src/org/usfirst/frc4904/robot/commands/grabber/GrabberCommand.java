package org.usfirst.frc4904.robot.commands.grabber;


import org.usfirst.frc4904.cmdbased.custom.sensors.PDP;
import org.usfirst.frc4904.logkitten.LogKitten;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Grabber;
import org.usfirst.frc4904.robot.subsystems.LimitSwitchSystem;
import edu.wpi.first.wpilibj.command.Command;

public abstract class GrabberCommand extends Command {
	protected final Grabber grabber;
	protected final PDP pdp;
	protected final LimitSwitchSystem limitSwitches;
	protected final LogKitten logger;
	
	public GrabberCommand(String name, Grabber grabber, PDP pdp, LimitSwitchSystem limitSwitches) {
		super(name);
		requires(grabber);
		setInterruptible(true);
		logger = new LogKitten(LogKitten.LEVEL_DEBUG, LogKitten.LEVEL_DEBUG);
		this.grabber = grabber;
		this.pdp = pdp;
		this.limitSwitches = limitSwitches;
	}
	
	protected void execute() {
		if (pdp.getCurrent(RobotMap.GRABBER_PDP_PORT) > RobotMap.GRABBER_EMERGENCY_AMPS) {
			grabber.set(RobotMap.GRABBER_IDLE_SPEED);
			logger.v("Idling now", true);
		}
	}
}
