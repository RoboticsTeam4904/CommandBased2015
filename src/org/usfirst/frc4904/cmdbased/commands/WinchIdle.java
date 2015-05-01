package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class WinchIdle extends Command {
	public WinchIdle() {
		super("WinchIdle");
	}
	
	protected void initialize() {
		requires(RobotMap.winch);
		RobotMap.winch.disable();
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false;
	}
}
