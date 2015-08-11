package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class WinchIdle extends Command {
	public WinchIdle() {
		super("WinchIdle");
		requires(RobotMap.winch);
	}
	
	protected void initialize() {
		RobotMap.winch.disable();
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false;
	}
}
