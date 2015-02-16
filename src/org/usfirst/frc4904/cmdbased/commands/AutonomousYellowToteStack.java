package org.usfirst.frc4904.cmdbased.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousYellowToteStack extends CommandGroup {
	public AutonomousYellowToteStack() {
		super("AutonomousYellowToteStack");
		// Stage 1
		addParallel(new GrabberOpen());
		addSequential(new AutonomousApproachYellowTote());
		// Stage 2
		addSequential(new GrabberClose());
		// Stage 3
		addParallel(new WinchSetHeight(3));
		addSequential(new AutonomousClearToteSideways());
		// Stage 4
		addSequential(new AutonomousFindToteSideways());
		// Stage 5
		addParallel(new GrabberOpen());
		addSequential(new WinchSetHeight(1));
		// Stage 6
		addSequential(new GrabberClose());
	}
}
