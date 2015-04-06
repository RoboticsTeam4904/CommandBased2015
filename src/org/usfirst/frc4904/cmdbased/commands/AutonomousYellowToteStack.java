package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.custom.LIDAR;
import org.usfirst.frc4904.cmdbased.subsystems.Camera;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import org.usfirst.frc4904.cmdbased.subsystems.Grabber;
import org.usfirst.frc4904.cmdbased.subsystems.Winch;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousYellowToteStack extends CommandGroup {
	public AutonomousYellowToteStack(Camera camera, Chassis chassis, Grabber grabber, LIDAR lidar, Winch winch) {
		super("AutonomousYellowToteStack");
		// Stage 1
		addParallel(new GrabberOpen(grabber));
		addSequential(new AutonomousApproachYellowTote(chassis, camera, lidar));
		// Stage 2
		addSequential(new GrabberClose(grabber));
		// Stage 3
		addParallel(new WinchSetHeight(winch, 3));
		addSequential(new AutonomousClearToteSideways(chassis, lidar));
		// Stage 4
		addSequential(new AutonomousFindToteSideways(chassis, lidar));
		// Stage 5
		addParallel(new GrabberOpen(grabber));
		addSequential(new WinchSetHeight(winch, 1));
		// Stage 6
		addSequential(new GrabberClose(grabber));
	}
}
