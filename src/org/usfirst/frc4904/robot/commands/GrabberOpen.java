package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class GrabberOpen extends Command {
	public GrabberOpen() {
		super("GrabberOpen");
	}
	
	protected void initialize() {
		requires(RobotMap.grabber);
		RobotMap.grabber.set(RobotMap.GRABBER_OPEN_SPEED);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return RobotMap.grabber.isOuterSwitchPressed();
	}
}
