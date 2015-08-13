package org.usfirst.frc4904.cmdbased.commands.motor;


import org.usfirst.frc4904.cmdbased.InPipable;
import org.usfirst.frc4904.logkitten.LogKitten;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MotorInPipe extends Command {
	private final SpeedController motor;
	private final LogKitten logger;
	private final InPipable source;
	
	public <A extends Subsystem & SpeedController> MotorInPipe(A motor, InPipable source) {
		super("MotorInPipe");
		this.motor = motor;
		this.source = source;
		logger = new LogKitten(LogKitten.LEVEL_VERBOSE, LogKitten.LEVEL_VERBOSE);
		logger.v("MotorInPipe created");
	}
	
	protected void initialize() {
		logger.v("MotorInPipe initialized");
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
