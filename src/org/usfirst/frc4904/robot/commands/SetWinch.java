package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.logkitten.LogKitten;
import org.usfirst.frc4904.robot.subsystems.Winch;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SetWinch extends CommandGroup {
	private final Winch winch;
	private final double height;
	
	public SetWinch(Winch winch, double height) {
		super("SetWinch");
		this.winch = winch;
		this.height = height;
		addSequential(new SetWinchPID(winch, true));
		requires(winch);
		requires(winch.getMotor());
		setInterruptible(true);
		LogKitten.v("created set winch");
	}
	
	protected void initialize() {
		winch.setHeight(height);
		LogKitten.v("Initialized set winch with height " + Double.toString(height));
	}
	
	protected void execute() {}
	
	protected void interrupted() {
		LogKitten.w("set winch was interrupted");
	}
	
	protected void end() {}
	
	protected boolean isFinished() {
		if (winch.onTarget()) {
			LogKitten.d("set winch is finished", true);
		}
		return winch.onTarget();
	}
}
