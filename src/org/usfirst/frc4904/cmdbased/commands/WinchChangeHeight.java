package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.Winch;
import edu.wpi.first.wpilibj.command.Command;

public class WinchChangeHeight extends Command {
	private final Winch winch;
	private final double desiredChange;
	
	public WinchChangeHeight(Winch winch, double desiredChange) {
		super("WinchChangeHeight");
		this.winch = winch;
		this.desiredChange = desiredChange;
		requires(winch);
	}
	
	protected void initialize() {
		winch.enable();
		winch.setSetpointRelative(desiredChange);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return winch.onTarget();
	}
}
