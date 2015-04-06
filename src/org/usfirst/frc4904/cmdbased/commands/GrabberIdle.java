package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.Grabber;
import edu.wpi.first.wpilibj.command.Command;

public class GrabberIdle extends Command {
	private final Grabber grabber;
	
	public GrabberIdle(Grabber grabber) {
		super("GrabberIdle");
		this.grabber = grabber;
		requires(grabber);
	}
	
	protected void initialize() {
		setInterruptible(true); // default command
		grabber.set(0);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false; // default command
	}
}
