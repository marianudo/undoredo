package me.marianonavas.undoredo.command;

public class UndoableSampleCommand implements Command {
	private final DefaultCommandTarget migration;

	public UndoableSampleCommand(DefaultCommandTarget migration) {
		this.migration = migration;
	}

	@Override
	public void doIt() {
		migration.doForward();
	}

	@Override
	public String whoAmI() {
		return "I'm a sample undoable command. Can you guess what I do?";
	}

	@Override
	public void undoIt() {
		migration.doBackward();
	}

}
