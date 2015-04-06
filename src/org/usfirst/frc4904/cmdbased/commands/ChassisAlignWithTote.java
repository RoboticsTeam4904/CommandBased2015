package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.custom.LIDAR;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import edu.wpi.first.wpilibj.command.Command;

public class ChassisAlignWithTote extends Command {
	private final Chassis chassis;
	private final LIDAR lidar;
	
	public ChassisAlignWithTote(Chassis chassis, LIDAR lidar) {
		super("ChassisAlignWithTote");
		this.chassis = chassis;
		this.lidar = lidar;
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub
	}
	
	protected void execute() {
		// TODO Auto-generated method stub
	}
	
	protected void end() {
		// TODO Auto-generated method stub
	}
	
	protected void interrupted() {
		// TODO Auto-generated method stub
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
