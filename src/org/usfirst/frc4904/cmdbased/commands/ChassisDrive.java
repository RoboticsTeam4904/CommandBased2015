package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.custom.MecanumHelper;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisDrive extends CommandGroup {
	private final Chassis chassis;
	
	public ChassisDrive(Chassis chassis, double speed, double angle, double turnSpeed) {
		super("ChassisDrive");
		this.chassis = chassis;
		// Calclulations (defines output variables for verbosity)
		double[] speeds = MecanumHelper.calculateWheels(speed, angle, turnSpeed);
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
	
	public ChassisDrive(Chassis chassis, double speed, double angle) {
		new ChassisDrive(chassis, speed, angle, 0);
		this.chassis = chassis;
	}
	
	public void initialize() {
		requires(chassis);
	}
}
