package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.RobotMap;
import org.usfirst.frc4904.cmdbased.custom.LIDAR;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import org.usfirst.frc4904.cmdbased.subsystems.Grabber;
import org.usfirst.frc4904.cmdbased.subsystems.Winch;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GrabCan extends CommandGroup {
	public GrabCan(Chassis chassis, Grabber grabber, LIDAR lidar, Winch winch) {
		super("GrabCan");
		// first stage: open and lower grabber
		addParallel(new GrabberOpen(grabber)); // done first so grabber won't hit can
		addSequential(new WinchSetHeight(winch, RobotMap.CAN_GRAB_HEIGHT));
		// second stage: align
		addSequential(new ChassisAlignWithTote(chassis, lidar));
		// third stage: close grabber
		addSequential(new GrabberClose(grabber));
		// TODO raise grabber to avoid hitting can?
		// TODO figure out if GrabberOpen can be parallel (based on distance and grabber height)
	}
}
