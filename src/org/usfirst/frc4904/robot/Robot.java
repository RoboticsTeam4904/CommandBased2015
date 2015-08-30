/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.cmdbased.CommandRobotBase;
import org.usfirst.frc4904.cmdbased.commands.chassis.ChassisIdle;
import org.usfirst.frc4904.cmdbased.commands.chassis.ChassisMove;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends CommandRobotBase {
	// Even static objects need initializers
	RobotMap map = new RobotMap();
	DriverStationMap dsMap = new DriverStationMap();
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		super.robotInit();
		System.out.println("CommandRobotBase init complete");
		// Configure autonomous command chooser
		autoChooser.addDefault(new ChassisIdle(map.chassis));
		// Configure driver command chooser
		driverChooser.addDefault(new Nathan());
		// Configure operator command chooser
		operatorChooser.addDefault(new Nachi());
		operatorChooser.addObject(new Griffin());
		// Display choosers on SmartDashboard
		displayChoosers();
		SmartDashboard.putData(Scheduler.getInstance());
		RobotMap.pdp.addLiveWindow();
	}
	
	public void autonomousInit() {
		// Get chosen autonomous command
		autonomousCommand = autoChooser.getSelected();
		// Schedule the autonomous command
		teleopCommand.cancel();
		autonomousCommand.start();
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		teleopCommand = new ChassisMove(RobotMap.chassis, DriverStationMap.xbox);
		teleopCommand.start();
		RobotMap.winch.enable();
		// Bind commands
		operatorChooser.getSelected().bindCommands();
		driverChooser.getSelected().bindCommands();
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void disabledInit() {
		if (teleopCommand != null) {
			teleopCommand.cancel();
		}
		RobotMap.winch.disable();
	}
	
	public void disabledPeriodic() {}
	
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
