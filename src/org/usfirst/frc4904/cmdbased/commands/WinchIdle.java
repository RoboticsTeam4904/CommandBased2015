package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.Winch;
import edu.wpi.first.wpilibj.command.Command;

public class WinchIdle extends Command {
	private final Winch winch;
	
	public WinchIdle(Winch winch) {
		super("WinchIdle");
		this.winch = winch;
		requires(winch);
	}
	
	protected void initialize() {
		setInterruptible(true); // default command
		winch.getPIDController().reset(); // resets accumulated PID values and disables
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false; // default command
	}
}
