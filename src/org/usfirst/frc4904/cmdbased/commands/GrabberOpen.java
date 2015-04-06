package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.RobotMap;
import org.usfirst.frc4904.cmdbased.subsystems.Grabber;
import edu.wpi.first.wpilibj.command.Command;

public class GrabberOpen extends Command {
	private final Grabber grabber;
	
	public GrabberOpen(Grabber grabber) {
		super("GrabberOpen");
		this.grabber = grabber;
		requires(grabber);
	}
	
	protected void initialize() {
		grabber.set(RobotMap.GRABBER_OPEN_SPEED);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return grabber.isOuterSwitchPressed();
	}
}
