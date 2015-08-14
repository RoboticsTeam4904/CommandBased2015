package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj.command.Command;

public class GrabberClose extends Command {
	private final Grabber grabber;
	
	public GrabberClose(Grabber grabber) {
		super("GrabberClose");
		this.grabber = grabber;
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub
	}
	
	protected void execute() {
		// TODO Auto-generated method stub
	}
	
	protected void interrupted() {
		// TODO Auto-generated method stub
	}
	
	protected void end() {
		// TODO Auto-generated method stub
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
