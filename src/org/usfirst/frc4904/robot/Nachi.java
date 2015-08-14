package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.cmdbased.Operator;
import org.usfirst.frc4904.cmdbased.commands.motor.MotorInPipe;
import org.usfirst.frc4904.robot.commands.SetWinch;
import org.usfirst.frc4904.robot.commands.grabber.GrabberToggle;

public class Nachi extends Operator {
	public Nachi() {
		super("Nachi"); // Supernachi!
		// Set Joystick to output y axis via pipe (for manual adjustments)
		DriverStationMap.stick.setPipe(2);
		DriverStationMap.stick.button7.whileHeld(new MotorInPipe(RobotMap.winch, DriverStationMap.stick));
		// Winch PID commands
		DriverStationMap.stick.button3.whenPressed(new SetWinch(RobotMap.winch, RobotMap.winch.getPosition() - RobotMap.TICK_PER_HALFTOTE));
		DriverStationMap.stick.button4.whenPressed(new SetWinch(RobotMap.winch, RobotMap.winch.getPosition() + RobotMap.TICK_PER_HALFTOTE));
		DriverStationMap.stick.button5.whenPressed(new SetWinch(RobotMap.winch, RobotMap.WINCH_MIN_HEIGHT * RobotMap.TICK_PER_HALFTOTE));
		DriverStationMap.stick.button6.whenPressed(new SetWinch(RobotMap.winch, RobotMap.WINCH_MAX_HEIGHT * RobotMap.TICK_PER_HALFTOTE));
		// Grabber commands
		DriverStationMap.stick.button1.whenPressed(new GrabberToggle(RobotMap.grabber, RobotMap.pdp, RobotMap.limitSwitches));
		/**
		 * DriverStationMap.stick.button1.toggleWhenPressed(new GrabTote(RobotMap.chassis, RobotMap.grabber, RobotMap.lidar, RobotMap.winch));
		 * DriverStationMap.stick.button2.toggleWhenPressed(new GrabCan(RobotMap.chassis, RobotMap.grabber, RobotMap.lidar, RobotMap.winch));
		 * DriverStationMap.stick.button3.whenPressed(new WinchChangeHeight(RobotMap.winch, -1)); // Lower winch two half-totes
		 * DriverStationMap.stick.button4.whenPressed(new WinchChangeHeight(RobotMap.winch, 1)); // Raise winch two half-totes
		 * DriverStationMap.stick.button5.whenPressed(new WinchSetHeight(RobotMap.winch, 0)); // Lower winch all the way (1 half-totes)
		 * DriverStationMap.stick.button6.whenPressed(new WinchSetHeight(RobotMap.winch, 12)); // Raise winch all the way (12 half-totes)
		 */
	}
}
