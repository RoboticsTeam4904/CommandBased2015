package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.custom.MecanumHelper;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisDriveCartesian extends CommandGroup {
	public ChassisDriveCartesian(double xSpeed, double ySpeed, double turnSpeed) {
		super("ChassisDriveCartesian");
		requires(CommandBase.chassis);
		// Calclulations (defines output variables for verbosity)
		double[] polar = MecanumHelper.cartesianToPolar(xSpeed, ySpeed);
		double speed = polar[0];
		double angle = polar[1];
		// Commands
		addSequential(new ChassisDrive(speed, angle, turnSpeed));
	}
	
	public ChassisDriveCartesian(double speed, double angle) {
		new ChassisDriveCartesian(speed, angle, 0);
	}
}
