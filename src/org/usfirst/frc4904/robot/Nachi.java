package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.cmdbased.Operator;

public class Nachi extends Operator {
	public Nachi() {
		super("Nachi");
		DriverStationMap.stick.button1.toggleWhenPressed(new GrabTote(RobotMap.chassis, RobotMap.grabber, RobotMap.lidar, RobotMap.winch));
		DriverStationMap.stick.button2.toggleWhenPressed(new GrabCan(RobotMap.chassis, RobotMap.grabber, RobotMap.lidar, RobotMap.winch));
		DriverStationMap.stick.button3.whenPressed(new WinchChangeHeight(RobotMap.winch, -1)); // Lower winch two half-totes
		DriverStationMap.stick.button4.whenPressed(new WinchChangeHeight(RobotMap.winch, 1)); // Raise winch two half-totes
		DriverStationMap.stick.button5.whenPressed(new WinchSetHeight(RobotMap.winch, 0)); // Lower winch all the way (1 half-totes)
		DriverStationMap.stick.button6.whenPressed(new WinchSetHeight(RobotMap.winch, 12)); // Raise winch all the way (12 half-totes)
	}
}
