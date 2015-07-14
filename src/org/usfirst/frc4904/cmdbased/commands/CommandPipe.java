package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.InPipable;
import org.usfirst.frc4904.cmdbased.OutPipable;
import edu.wpi.first.wpilibj.command.Command;

public class CommandPipe extends Command {
	private final InPipable dataRead;
	private final OutPipable dataWrite;
	
	public CommandPipe(InPipable dataRead, OutPipable dataWrite) {
		this.dataRead = dataRead;
		this.dataWrite = dataWrite;
	}
	
	protected void execute() {
		dataWrite.writePipe(dataRead.readPipe());
	}
	
	protected void end() {}
	
	protected void initialize() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false;
	}
}
