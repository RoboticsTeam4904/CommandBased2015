package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.custom.MecanumHelper;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisDriveCartesian extends CommandGroup {
	private final Chassis chassis;
	
	public ChassisDriveCartesian(Chassis chassis, double xSpeed, double ySpeed, double turnSpeed) {
		super("ChassisDriveCartesian");
		this.chassis = chassis;
		// Calclulations (defines output variables for verbosity)
		double[] polar = MecanumHelper.cartesianToPolar(xSpeed, ySpeed);
		double speed = polar[0];
		double angle = polar[1];
		// Commands
		addSequential(new ChassisDrive(chassis, speed, angle, turnSpeed));
	}
	
	public ChassisDriveCartesian(Chassis chassis, double speed, double angle) {
		new ChassisDriveCartesian(chassis, speed, angle, 0);
		this.chassis = chassis;
	}
	
	public void initialize() {
		requires(chassis);
	}
}
