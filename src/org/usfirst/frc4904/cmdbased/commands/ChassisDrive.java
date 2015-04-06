package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.custom.MecanumHelper;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisDrive extends CommandGroup {
	public ChassisDrive(Chassis chassis, double speed, double angle, double turnSpeed) {
		super("ChassisDrive");
		requires(chassis);
		// Calclulations (defines output variables for verbosity)
		double[] speeds = MecanumHelper.calculateWheels(speed, angle, turnSpeed);
		double frontLeft = speeds[0];
		double frontRight = speeds[1];
		double backLeft = speeds[2];
		double backRight = speeds[3];
		// Individual wheel commands
		addParallel(new WheelSpin(chassis.frontLeftWheel, frontLeft));
		addParallel(new WheelSpin(chassis.frontRightWheel, frontRight));
		addParallel(new WheelSpin(chassis.backLeftWheel, backLeft));
		addParallel(new WheelSpin(chassis.backRightWheel, backRight));
	}
	
	public ChassisDrive(Chassis chassis, double speed, double angle) {
		new ChassisDrive(chassis, speed, angle, 0);
	}
}
