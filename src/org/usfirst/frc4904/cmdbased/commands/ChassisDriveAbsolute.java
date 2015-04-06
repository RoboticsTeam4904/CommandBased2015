package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.custom.IMU;
import org.usfirst.frc4904.cmdbased.custom.MecanumHelper;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisDriveAbsolute extends CommandGroup {
	public ChassisDriveAbsolute(Chassis chassis, IMU imu, double speed, double angle, double turnSpeed) {
		super("ChassisDriveAbsolute");
		requires(chassis);
		// Calclulations (defines output variables for verbosity)
		double angleOffset = imu.read()[0];
		double[] speeds = MecanumHelper.calculateWheels(speed, angle - angleOffset, turnSpeed);
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
	
	public ChassisDriveAbsolute(Chassis chassis, IMU imu, double speed, double angle) {
		new ChassisDriveAbsolute(chassis, imu, speed, angle, 0);
	}
}
