package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Winch;
import edu.wpi.first.wpilibj.command.Command;

public class SetWinch extends Command {
	private final Winch winch;
	private final double height;
	
	public SetWinch(Winch winch, double height) {
		super("SetWinch");
		this.winch = winch;
		this.height = height;
		requires(winch);
		setInterruptible(true);
	}
	
	protected void initialize() {
		winch.setHeight(height);
	}
	
	protected void execute() {}
	
	protected void interrupted() {}
	
	protected void end() {}
	
	protected boolean isFinished() {
		return winch.onTarget();
	}
}
