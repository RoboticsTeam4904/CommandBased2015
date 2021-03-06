package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.logkitten.LogKitten;
import org.usfirst.frc4904.robot.subsystems.Winch;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SetWinch extends CommandGroup {
	private final Winch winch;
	private final double height;
	private final LogKitten kitten;
	
	public SetWinch(Winch winch, double height) {
		super("SetWinch");
		this.winch = winch;
		this.height = height;
		addSequential(new SetWinchPID(winch, true));
		requires(winch);
		requires(winch.getMotor());
		setInterruptible(true);
		kitten = new LogKitten(LogKitten.LEVEL_WARN, LogKitten.LEVEL_WARN);
		kitten.v("created set winch");
	}
	
	protected void initialize() {
		winch.setHeight(height);
		kitten.v("Initialized set winch with height " + Double.toString(height));
	}
	
	protected void execute() {}
	
	protected void interrupted() {
		kitten.w("set winch was interrupted");
	}
	
	protected void end() {}
	
	protected boolean isFinished() {
		if (winch.onTarget()) {
			kitten.d("set winch is finished", true);
		}
		return winch.onTarget();
	}
}
