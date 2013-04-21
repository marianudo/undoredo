package me.marianonavas.undoredo.command;

public class SampleCommandClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// First let's migrate the account pp@gmail.com
		String initialState = "First";
		String finalState = "Second";
		DefaultCommandTarget migration = new DefaultCommandTarget(initialState, finalState);
		Command cmd = new UndoableSampleCommand(migration);
		CommandExecutor exec = new CommandExecutor(5);
		System.out.print("Command execution: ");
		exec.executeCommand(cmd);
		System.out.print("Undo action: ");
		exec.undoLastCommand();
		System.out.print("Redo action: ");
		exec.redoLastUndoedCommand();
	}

}
