package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.custom.MecanumHelper;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisDrive extends CommandGroup {
	public ChassisDrive(double speed, double angle, double turnSpeed) {
		super("ChassisDrive");
		requires(CommandBase.chassis);
		// Calclulations (defines output variables for verbosity)
		double[] speeds = MecanumHelper.calculateWheels(speed, angle, turnSpeed);
		double frontLeft = speeds[0];
		double frontRight = speeds[1];
		double backLeft = speeds[2];
		double backRight = speeds[3];
		// Individual wheel commands
		addParallel(new WheelSpin(CommandBase.chassis.frontLeftWheel, frontLeft));
		addParallel(new WheelSpin(CommandBase.chassis.frontRightWheel, frontRight));
		addParallel(new WheelSpin(CommandBase.chassis.backLeftWheel, backLeft));
		addParallel(new WheelSpin(CommandBase.chassis.backRightWheel, backRight));
	}
	
	public ChassisDrive(double speed, double angle) {
		new ChassisDrive(speed, angle, 0);
	}
}
