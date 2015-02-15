package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GrabTote extends CommandGroup {
	public GrabTote() {
		super("GrabTote");
		// first stage: open and lower grabber
		addParallel(new GrabberOpen()); // done first so grabber won't hit tote
		addSequential(new WinchSetHeight(RobotMap.TOTE_GRAB_HEIGHT));
		// second stage: align
		addSequential(new ChassisAlignWithTote());
		// third stage: close grabber
		addSequential(new GrabberClose());
		// TODO raise grabber to avoid hitting tote?
		// TODO figure out if GrabberOpen can be parallel (based on distance and grabber height)
	}
}
