package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.RobotMap;
import org.usfirst.frc4904.cmdbased.custom.MecanumHelper;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisDriveAbsolute extends CommandGroup {
	public ChassisDriveAbsolute(double speed, double angle, double turnSpeed) {
		super("ChassisDriveAbsolute");
		requires(CommandBase.chassis);
		// Calclulations (defines output variables for verbosity)
		double angleOffset = RobotMap.IMU_SENSOR.getAngle();
		double[] speeds = MecanumHelper.calculateWheels(speed, angle - angleOffset, turnSpeed);
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

	public ChassisDriveAbsolute(double speed, double angle) {
		new ChassisDriveAbsolute(speed, angle, 0);
	}
}
