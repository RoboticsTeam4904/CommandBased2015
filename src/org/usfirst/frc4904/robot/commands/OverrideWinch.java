package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.cmdbased.commands.motor.ControlMotorFromControllerY;
import org.usfirst.frc4904.cmdbased.custom.controllers.Controller;
import org.usfirst.frc4904.robot.subsystems.Winch;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class OverrideWinch extends CommandGroup {
	public OverrideWinch(Winch winch, Controller stick) {
		addSequential(new SetWinchPID(winch, false));
		addSequential(new ControlMotorFromControllerY(winch, stick));
	}
}
