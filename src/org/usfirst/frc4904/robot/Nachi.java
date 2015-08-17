package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.cmdbased.commands.motor.MotorInPipe;
import org.usfirst.frc4904.cmdbased.custom.controllers.Controller;
import org.usfirst.frc4904.cmdbased.humaninterface.Operator;
import org.usfirst.frc4904.robot.commands.SetWinch;
import org.usfirst.frc4904.robot.commands.grabber.GrabberToggle;

public class Nachi extends Operator {
	public Nachi() {
		super("Nachi"); // Supernachi!
	}
	
	public void bindCommands() {
		// Set Joystick to output y axis via pipe (for manual adjustments)
		DriverStationMap.stick.setPipe(Controller.PipeModes.Y);
		DriverStationMap.stick.button7.toggleWhenPressed(new MotorInPipe(RobotMap.winch, DriverStationMap.stick));
		// Winch PID commands
		DriverStationMap.stick.button3.whenPressed(new SetWinch(RobotMap.winch, RobotMap.winch.getPosition() - RobotMap.TICK_PER_HALFTOTE));
		DriverStationMap.stick.button4.whenPressed(new SetWinch(RobotMap.winch, RobotMap.winch.getPosition() + RobotMap.TICK_PER_HALFTOTE));
		DriverStationMap.stick.button5.whenPressed(new SetWinch(RobotMap.winch, RobotMap.WINCH_MIN_HEIGHT * RobotMap.TICK_PER_HALFTOTE));
		DriverStationMap.stick.button6.whenPressed(new SetWinch(RobotMap.winch, RobotMap.WINCH_MAX_HEIGHT * RobotMap.TICK_PER_HALFTOTE));
		// Grabber commands
		DriverStationMap.stick.button1.whenPressed(new GrabberToggle(RobotMap.grabber, RobotMap.pdp, RobotMap.limitSwitches));
	}
}
