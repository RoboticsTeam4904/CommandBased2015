/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.cmdbased2015;


import org.usfirst.frc4904.cmdbased.RobotBase;
import org.usfirst.frc4904.cmdbased.commands.ChassisIdle;
import org.usfirst.frc4904.cmdbased.commands.XboxDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends RobotBase {
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		super.robotInit();
		// Configure autonomous command chooser
		autoChooser.addDefault(new ChassisIdle(RobotMap.chassis));
		// Configure driver command chooser
		driverChooser.addDefault(new Nathan());
		// Configure operator command chooser
		operatorChooser.addDefault(new Nachi());
		operatorChooser.addObject(new Griffin());
		// Display choosers on SmartDashboard
		displayChoosers();
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
	public void autonomousPeriodic() {}
	
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		autonomousCommand.cancel();
		teleopCommand = new XboxDrive(RobotMap.chassis, DriverStationMap.xbox, 1, 1, 1);
		teleopCommand.start();
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {}
	
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
