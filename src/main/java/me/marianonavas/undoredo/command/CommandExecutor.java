package me.marianonavas.undoredo.command;


public class CommandExecutor {
	private final CommandStack commandStack;

	public CommandExecutor(int undoBufferSize) {
		super();
		commandStack = new CommandStack(undoBufferSize);
	}

	public void executeCommand(Command cmd) {
		commandStack.push(cmd);
		cmd.doIt();
	}
	
	public void undoLastCommand() {
		Command cmd = commandStack.getLastCommand();
		cmd.undoIt();
	}
	
	public void redoLastUndoedCommand() {
		Command cmd = commandStack.recoverLastGettedCommand();
		cmd.doIt();
	}
}
