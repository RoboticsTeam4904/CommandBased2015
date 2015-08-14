package org.usfirst.frc4904.robot.commands.grabber;


import org.usfirst.frc4904.cmdbased.custom.sensors.PDP;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Grabber;
import org.usfirst.frc4904.robot.subsystems.LimitSwitchSystem;
import edu.wpi.first.wpilibj.command.Command;

public abstract class GrabberCommand extends Command {
	protected final Grabber grabber;
	protected final PDP pdp;
	protected final LimitSwitchSystem limitSwitches;
	
	public GrabberCommand(String name, Grabber grabber, PDP pdp, LimitSwitchSystem limitSwitches) {
		super(name);
		requires(grabber);
		setInterruptible(true);
		this.grabber = grabber;
		this.pdp = pdp;
		this.limitSwitches = limitSwitches;
	}
	
	protected void execute() {
		if (pdp.getCurrent(RobotMap.GRABBER_PDP_PORT) > RobotMap.GRABBER_EMERGENCY_AMPS) {
			grabber.set(RobotMap.GRABBER_IDLE_SPEED);
		}
	}
	
	protected boolean isFinished() {
		return (pdp.getCurrent(RobotMap.GRABBER_PDP_PORT) > RobotMap.GRABBER_MAX_AMPS) || limitSwitches.isInnerSwitchPressed() || limitSwitches.isOuterSwitchPressed(); // Regardless of what limit switch is pressed, stop the grabber
	}
}
