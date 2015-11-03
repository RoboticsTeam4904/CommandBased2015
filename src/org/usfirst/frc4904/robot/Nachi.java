package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.logkitten.LogKitten;
import org.usfirst.frc4904.robot.commands.OverrideWinch;
import org.usfirst.frc4904.standard.commands.motor.ControlMotor;
import org.usfirst.frc4904.standard.custom.controllers.Controller;
import org.usfirst.frc4904.standard.humaninterface.Operator;

public class Nachi extends Operator {
	public Nachi() {
		super("Nachi"); // Supernachi!
		LogKitten.setPrintMute(true);
	}
	
	public void bindCommands() {
		LogKitten.d("Binding nachi");
		// Set Joystick to output y axis via pipe (for manual adjustments)
		// DriverStationMap.stick.button9.toggleWhenPressed(new OverrideWinch(RobotMap.winch, DriverStationMap.stick, Controller.Y_AXIS));
		// DriverStationMap.stick.button10.toggleWhenPressed(new ControlMotor(RobotMap.grabber, DriverStationMap.stick, Controller.X_AXIS, false));
		(new OverrideWinch(RobotMap.winch, DriverStationMap.stick, Controller.Y_AXIS)).start();
		(new ControlMotor(RobotMap.grabber, DriverStationMap.stick, Controller.X_AXIS, false)).start();
		// Winch PID commands
		// DriverStationMap.stick.button3.whenPressed(new DeltaWinch(RobotMap.winch, RobotMap.winch.getPosition() - RobotMap.TICK_PER_HALFTOTE));
		// DriverStationMap.stick.button4.whenPressed(new SetWinch(RobotMap.winch, RobotMap.WINCH_MIN_HEIGHT * RobotMap.TICK_PER_HALFTOTE));
		// DriverStationMap.stick.button5.whenPressed(new DeltaWinch(RobotMap.winch, RobotMap.winch.getPosition() + RobotMap.TICK_PER_HALFTOTE));
		// DriverStationMap.stick.button6.whenPressed(new SetWinch(RobotMap.winch, RobotMap.WINCH_MAX_HEIGHT * RobotMap.TICK_PER_HALFTOTE));
		// Grabber commands
		// DriverStationMap.stick.button1.whenPressed(new GrabberToggle(RobotMap.grabber, RobotMap.pdp));
		// RobotMap.grabber.getSwitches().whenPressed(new GrabberStop(RobotMap.grabber));
	}
}
