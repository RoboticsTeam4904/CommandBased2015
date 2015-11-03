package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.logkitten.LogKitten;
import org.usfirst.frc4904.robot.subsystems.Winch;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class DeltaWinch extends CommandGroup {
	private final Winch winch;
	private final double encoderDistance;
	
	public DeltaWinch(Winch winch, double encoderDistance) {
		super("DeltaWinch");
		this.winch = winch;
		this.encoderDistance = encoderDistance;
		addSequential(new SetWinchPID(winch, true));
		requires(winch);
		requires(winch.getMotor());
		setInterruptible(true);
		LogKitten.v("created delta winch");
	}
	
	protected void initialize() {
		winch.setHeight(winch.getPosition() + encoderDistance);
		LogKitten.v("Initialized delta winch with delta " + Double.toString(encoderDistance));
	}
	
	protected void execute() {}
	
	protected void interrupted() {
		LogKitten.w("delta winch was interrupted");
	}
	
	protected void end() {}
	
	protected boolean isFinished() {
		if (winch.onTarget()) {
			LogKitten.d("delta winch is finished", true);
		}
		return winch.onTarget();
	}
}
