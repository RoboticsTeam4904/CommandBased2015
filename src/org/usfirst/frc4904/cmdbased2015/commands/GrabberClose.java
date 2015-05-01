package org.usfirst.frc4904.cmdbased2015.commands;


import org.usfirst.frc4904.cmdbased2015.RobotMap;
import org.usfirst.frc4904.cmdbased2015.subsystems.Grabber;
import edu.wpi.first.wpilibj.command.Command;

public class GrabberClose extends Command {
	private final Grabber grabber;
	
	public GrabberClose(Grabber grabber) {
		super("GrabberClose");
		this.grabber = grabber;
	}
	
	protected void initialize() {
		requires(grabber);
		setInterruptible(true);
		grabber.set(RobotMap.GRABBER_CLOSE_SPEED);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return grabber.isInnerSwitchPressed();
	}
}
