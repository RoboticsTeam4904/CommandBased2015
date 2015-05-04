package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class GrabberHold extends Command {
	public GrabberHold() {
		super("GrabberHold");
	}
	
	protected void initialize() {
		requires(RobotMap.grabber);
		setInterruptible(true);
		RobotMap.grabber.set(RobotMap.GRABBER_HOLD_SPEED);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false;
	}
}
