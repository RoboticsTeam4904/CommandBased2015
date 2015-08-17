package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.cmdbased.commands.motor.MotorInPipe;
import org.usfirst.frc4904.cmdbased.custom.controllers.Controller;
import org.usfirst.frc4904.cmdbased.humaninterface.Operator;
import org.usfirst.frc4904.robot.commands.SetWinch;
import org.usfirst.frc4904.robot.commands.grabber.GrabberToggle;

public class Griffin extends Operator {
	public Griffin() {
		super("Griffin"); // Supergriffin!
	}
	
	public void bindCommands() {
		// Set Joystick to output y axis via pipe (for manual adjustments)
		DriverStationMap.stick.setPipe(Controller.PipeModes.Y);
		DriverStationMap.stick.button7.toggleWhenPressed(new MotorInPipe(RobotMap.winch, DriverStationMap.stick));
		// Grabber commands
		DriverStationMap.stick.button10.whenPressed(new GrabberToggle(RobotMap.grabber, RobotMap.pdp, RobotMap.limitSwitches));
		// Winch automatic movement
		DriverStationMap.stick.button3.whenPressed(new SetWinch(RobotMap.winch, RobotMap.winch.getPosition() - RobotMap.TICK_PER_HALFTOTE));
		DriverStationMap.stick.button4.whenPressed(new SetWinch(RobotMap.winch, RobotMap.winch.getPosition() + RobotMap.TICK_PER_HALFTOTE));
		DriverStationMap.stick.button5.whenPressed(new SetWinch(RobotMap.winch, 0));
		DriverStationMap.stick.button6.whenPressed(new SetWinch(RobotMap.winch, 12));
	}
}
