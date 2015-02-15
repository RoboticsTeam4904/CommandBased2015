package org.usfirst.frc4904.cmdbased.commands;


public class WinchSetHeight extends CommandBase {
	private final double desiredPosition;
	
	public WinchSetHeight(double desiredPosition) {
		super("WinchSetHeight");
		requires(winch);
		this.desiredPosition = desiredPosition;
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
