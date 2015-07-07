package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.custom.MecanumHelper;
import org.usfirst.frc4904.cmdbased.subsystems.chassis.FourWheelChassis;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MecanumDriveCartesian extends CommandGroup {
	private final FourWheelChassis chassis;
	
	public MecanumDriveCartesian(FourWheelChassis chassis, double xSpeed, double ySpeed, double turnSpeed) {
		super("ChassisDriveCartesian");
		this.chassis = chassis;
		// Calclulations (defines output variables for verbosity)
		double[] polar = MecanumHelper.cartesianToPolar(xSpeed, ySpeed);
		double speed = polar[0];
		double angle = polar[1];
		// Commands
		addSequential(new MecanumDrive(chassis, speed, angle, turnSpeed));
	}
	
	public MecanumDriveCartesian(FourWheelChassis chassis, double speed, double angle) {
		new MecanumDriveCartesian(chassis, speed, angle, 0);
		this.chassis = chassis;
	}
	
	public void initialize() {
		requires(chassis);
	}
}
