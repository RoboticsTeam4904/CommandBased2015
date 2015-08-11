package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj.command.Command;

public class GrabberClose extends Command {
	private final Grabber grabber;
	
	public GrabberClose(Grabber grabber) {
		super("GrabberClose");
		this.grabber = grabber;
		requires(grabber);
		setInterruptible(true);
	}
	
	protected void initialize() {
		grabber.set(RobotMap.GRABBER_CLOSE_SPEED);
	}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return grabber.isInnerSwitchPressed();
	}
}
