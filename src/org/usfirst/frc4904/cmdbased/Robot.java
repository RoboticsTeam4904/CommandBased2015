/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.cmdbased;


import org.usfirst.frc4904.cmdbased.commands.AutonomousIdle;
import org.usfirst.frc4904.cmdbased.commands.XboxDrive;
import org.usfirst.frc4904.cmdbased.custom.CommandSendableChooser;
import org.usfirst.frc4904.cmdbased.custom.TypedNamedSendableChooser;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends RobotBase {
	private Command autonomousCommand;
	private CommandSendableChooser autoChooser;
	private TypedNamedSendableChooser<OI> operatorChooser;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		// Initialize and configure autonomous command chooser
		autoChooser = new CommandSendableChooser();
		autoChooser.addDefault(new AutonomousIdle(RobotMap.grabber, RobotMap.winch));
		// Initialize and configure operator command chooser
		operatorChooser = new TypedNamedSendableChooser<OI>();
		operatorChooser.addDefault(new OINachi());
		operatorChooser.addObject(new OIGriffin());
		// Display autonomous chooser on SmartDashboard
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		SmartDashboard.putData("Operator control scheme chooser", operatorChooser);
	}
	
	public void autonomousInit() {
		// Get chosen autonomous command
		autonomousCommand = autoChooser.getSelected();
		// Schedule the autonomous command
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
		(new XboxDrive(this, RobotMap.chassis)).start();
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
