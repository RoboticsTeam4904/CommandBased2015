package org.usfirst.frc4904.robot.commands.grabber;


import org.usfirst.frc4904.logkitten.LogKitten;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Grabber;
import org.usfirst.frc4904.robot.subsystems.LimitSwitchSystem;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import edu.wpi.first.wpilibj.command.Command;

public abstract class GrabberCommand extends Command {
	protected final Grabber grabber;
	protected final PDP pdp;
	protected final LimitSwitchSystem limitSwitches;
	
	public GrabberCommand(String name, Grabber grabber, PDP pdp) {
		super(name);
		requires(grabber);
		setInterruptible(true);
		this.grabber = grabber;
		this.pdp = pdp;
		this.limitSwitches = grabber.getSwitches();
	}
	
	protected void execute() {
		if (pdp.getCurrent(RobotMap.GRABBER_PDP_PORT) > RobotMap.GRABBER_EMERGENCY_AMPS) {
			grabber.set(RobotMap.GRABBER_IDLE_SPEED);
			LogKitten.v("Idling now");
		}
	}
}
