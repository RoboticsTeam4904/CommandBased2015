package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Winch;
import org.usfirst.frc4904.standard.commands.motor.MotorInPipe;
import org.usfirst.frc4904.standard.custom.controllers.Controller;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class OverrideWinch extends CommandGroup {
	public OverrideWinch(Winch winch, Controller stick) {
		addSequential(new SetWinchPID(winch, false));
		addSequential(new MotorInPipe(winch.getMotor(), stick));
	}
}
