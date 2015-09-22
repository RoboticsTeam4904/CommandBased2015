package org.usfirst.frc4904.robot.commands.grabber;


import org.usfirst.frc4904.logkitten.LogKitten;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj.command.Command;

public class GrabberStop extends Command {
	private final LogKitten logger;
	private final Grabber grabber;
	
	public GrabberStop(Grabber grabber) {
		super("Grabber Stop");
		requires(grabber);
		setInterruptible(false); // Command exits immediately
		this.grabber = grabber;
		logger = new LogKitten(LogKitten.LEVEL_WARN, LogKitten.LEVEL_WARN);
		logger.v("GrabberStop initialized");
	}
	
	protected void initialize() {
		logger.v("Grabber stopping");
		grabber.set(RobotMap.GRABBER_IDLE_SPEED);
	}
	
	protected void execute() {}
	
	protected void interrupted() {}
	
	protected void end() {}
	
	protected boolean isFinished() {
		return true;
	}
}
