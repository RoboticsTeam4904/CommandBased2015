package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class GrabberIdle extends Command {
	public GrabberIdle() {
		super("GrabberIdle");
	}
	
	protected void initialize() {
		requires(RobotMap.grabber);
		setInterruptible(true);
		RobotMap.grabber.set(RobotMap.GRABBER_IDLE_SPEED);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false;
	}
}
