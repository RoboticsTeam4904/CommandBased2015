package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Winch;
import org.usfirst.frc4904.standard.commands.motor.ControlMotor;
import org.usfirst.frc4904.standard.custom.controllers.Controller;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class OverrideWinch extends CommandGroup {
	public OverrideWinch(Winch winch, Controller stick, int axis) {
		addSequential(new SetWinchPID(winch, false));
		addSequential(new ControlMotor(winch.getMotor(), stick, axis));
	}
}
