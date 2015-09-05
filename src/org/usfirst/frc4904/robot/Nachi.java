package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.logkitten.LogKitten;
import org.usfirst.frc4904.robot.commands.OverrideWinch;
import org.usfirst.frc4904.robot.commands.SetWinch;
import org.usfirst.frc4904.robot.commands.grabber.GrabberStop;
import org.usfirst.frc4904.robot.commands.grabber.GrabberToggle;
import org.usfirst.frc4904.standard.commands.motor.MotorInPipe;
import org.usfirst.frc4904.standard.custom.controllers.Controller;
import org.usfirst.frc4904.standard.humaninterface.Operator;

public class Nachi extends Operator {
	private final LogKitten kitten;
	
	public Nachi() {
		super("Nachi"); // Supernachi!
		kitten = new LogKitten(LogKitten.LEVEL_DEBUG, LogKitten.LEVEL_DEBUG);
		LogKitten.setPrintMute(true);
	}
	
	public void bindCommands() {
		kitten.d("Binding nachi");
		// Set Joystick to output y axis via pipe (for manual adjustments)
		DriverStationMap.stick.setPipe(Controller.PipeModes.Y);
		DriverStationMap.stick.button11.toggleWhenPressed(new OverrideWinch(RobotMap.winch, DriverStationMap.stick));
		DriverStationMap.stick.button10.toggleWhenPressed(new MotorInPipe(RobotMap.grabber, DriverStationMap.stick));
		// Winch PID commands
		// DriverStationMap.stick.button3.whenPressed(new SetWinch(RobotMap.winch, RobotMap.winch.getPosition() - RobotMap.TICK_PER_HALFTOTE));
		// DriverStationMap.stick.button4.whenPressed(new SetWinch(RobotMap.winch, RobotMap.winch.getPosition() + RobotMap.TICK_PER_HALFTOTE));
		DriverStationMap.stick.button5.whenPressed(new SetWinch(RobotMap.winch, RobotMap.WINCH_MIN_HEIGHT * RobotMap.TICK_PER_HALFTOTE));
		DriverStationMap.stick.button6.whenPressed(new SetWinch(RobotMap.winch, RobotMap.WINCH_MAX_HEIGHT * RobotMap.TICK_PER_HALFTOTE));
		// Grabber commands
		DriverStationMap.stick.button1.whenPressed(new GrabberToggle(RobotMap.grabber, RobotMap.pdp));
		RobotMap.grabber.getSwitches().whenPressed(new GrabberStop(RobotMap.grabber));
	}
}
