package org.usfirst.frc4904.robot.commands.grabber;


import org.usfirst.frc4904.cmdbased.custom.sensors.PDP;
import org.usfirst.frc4904.logkitten.LogKitten;
import org.usfirst.frc4904.robot.subsystems.Grabber;
import org.usfirst.frc4904.robot.subsystems.LimitSwitchSystem;
import edu.wpi.first.wpilibj.command.Command;

public class GrabberToggle extends Command {
	public static boolean open = true;
	private final LogKitten logger;
	private final Grabber grabber;
	private final PDP pdp;
	private final LimitSwitchSystem limitSwitches;
	private Command currentGrabberCommand;
	
	public GrabberToggle(Grabber grabber, PDP pdp, LimitSwitchSystem limitSwitches) {
		super("GrabberToggle");
		logger = new LogKitten(LogKitten.LEVEL_DEBUG, LogKitten.LEVEL_DEBUG);
		this.grabber = grabber;
		this.pdp = pdp;
		this.limitSwitches = limitSwitches;
		currentGrabberCommand = null;
	}
	
	protected void initialize() {
		if (open) {
			logger.v("Closing grabber", true);
			currentGrabberCommand = new GrabberClose(grabber, pdp, limitSwitches);
			open = false;
		} else {
			logger.v("Opening grabber", true);
			currentGrabberCommand = new GrabberOpen(grabber, pdp, limitSwitches);
			open = true;
		}
		currentGrabberCommand.start();
	}
	
	protected void execute() {}
	
	protected void interrupted() {
		if (currentGrabberCommand != null) {
			currentGrabberCommand.cancel();
		}
	}
	
	protected void end() {
		if (currentGrabberCommand != null) {
			currentGrabberCommand.cancel();
		}
	}
	
	protected boolean isFinished() {
		return !currentGrabberCommand.isRunning();
	}
}
