package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Winch;
import edu.wpi.first.wpilibj.command.Command;

public class SetWinchPID extends Command {
	private final Winch winch;
	private final boolean enable;
	
	public SetWinchPID(Winch winch, boolean enable) {
		super("DisableWinchPID");
		this.winch = winch;
		this.enable = enable;
	}
	
	protected void initialize() {
		if (!enable) {
			winch.disable();
		} else {
			winch.enable();
		}
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return true;
	}
}
