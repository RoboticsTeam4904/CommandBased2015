package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.custom.LIDAR;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousFindToteSideways extends Command {
	private final Chassis chassis;
	private final LIDAR lidar;
	
	public AutonomousFindToteSideways(Chassis chassis, LIDAR lidar) {
		super("AutonomousFindToteSideways");
		this.chassis = chassis;
		this.lidar = lidar;
	}
	
	protected void initialize() {}
	
	protected void execute() {
		(new ChassisDriveCartesian(chassis, 1, 0)).start();
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return lidar.getCorrectedAngleDist(0) < 100;
	}
}
