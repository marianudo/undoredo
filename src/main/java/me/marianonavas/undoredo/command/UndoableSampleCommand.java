package me.marianonavas.undoredo.command;

public class UndoableSampleCommand implements Command {
	private final DefaultCommandTarget target;

	public UndoableSampleCommand(DefaultCommandTarget target) {
		this.target = target;
	}

	@Override
	public void doIt() {
		target.doForward();
	}

	@Override
	public String whoAmI() {
		return "I'm a sample undoable command. Can you guess what I do?";
	}

	@Override
	public void undoIt() {
		target.doBackward();
	}

}
