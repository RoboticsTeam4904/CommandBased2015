package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.subsystems.Winch;
import edu.wpi.first.wpilibj.command.Command;

public class WinchSetHeight extends Command {
	private final Winch winch;
	private final double desiredPosition;
	
	public WinchSetHeight(Winch winch, double desiredPosition) {
		super("WinchSetHeight");
		this.winch = winch;
		this.desiredPosition = desiredPosition;
		requires(winch);
	}
	
	protected void initialize() {
		winch.enable();
		winch.setSetpoint(desiredPosition);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return winch.onTarget();
	}
}
