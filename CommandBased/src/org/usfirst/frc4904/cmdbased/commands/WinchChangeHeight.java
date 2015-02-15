package org.usfirst.frc4904.cmdbased.commands;


public class WinchChangeHeight extends CommandBase {
	private final double desiredChange;

	public WinchChangeHeight(double desiredChange) {
		super("WinchChangeHeight");
		requires(winch);
		this.desiredChange = desiredChange;
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
