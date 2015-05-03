package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.custom.Gyro;
import org.usfirst.frc4904.cmdbased.custom.MecanumHelper;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisDriveAbsolute extends CommandGroup {
	private final Chassis chassis;
	
	public ChassisDriveAbsolute(Chassis chassis, Gyro imu, double speed, double angle, double turnSpeed) {
		super("ChassisDriveAbsolute");
		this.chassis = chassis;
		// Calculations (defines output variables for verbosity)
		double angleOffset = imu.getYaw();
		double[] speeds = MecanumHelper.calculateWheels(speed, angle - angleOffset, turnSpeed);
		double frontLeft = speeds[0];
		double frontRight = speeds[1];
		double backLeft = speeds[2];
		double backRight = speeds[3];
		// Individual wheel commands
		addParallel(new MotorSpin(chassis.frontLeftWheel, frontLeft));
		addParallel(new MotorSpin(chassis.frontRightWheel, frontRight));
		addParallel(new MotorSpin(chassis.backLeftWheel, backLeft));
		addParallel(new MotorSpin(chassis.backRightWheel, backRight));
	}
	
	public ChassisDriveAbsolute(Chassis chassis, Gyro imu, double speed, double angle) {
		new ChassisDriveAbsolute(chassis, imu, speed, angle, 0);
		this.chassis = chassis;
	}
	
	public void initialize() {
		requires(chassis);
	}
}
