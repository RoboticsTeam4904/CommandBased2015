package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class GrabberIdle extends Command {
	public GrabberIdle() {
		super("GrabberIdle");
		requires(RobotMap.grabber);
		setInterruptible(true);
	}
	
	protected void initialize() {
		RobotMap.grabber.set(RobotMap.GRABBER_IDLE_SPEED);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false;
	}
}
