package me.marianonavas.undoredo.command;

import java.util.ArrayList;
import java.util.List;

class CommandStack {
	private final int maxStackSize;
	private List<Command> commandsStack = new ArrayList<Command>();
	private int commandsStackPointer = 0;
	
	CommandStack(int maxStackSize) {
		super();
		this.maxStackSize = maxStackSize;
	}

	public void push(Command cmd) {
		if (commandsStack.size() > commandsStackPointer) {
			removeCommandsAboveCurrentStackPointer();
		}
		commandsStack.add(cmd);
		commandsStackPointer++;
		fitStackToMaxSize();
	}
	
	public Command getLastCommand() {
		if(commandsStackPointer > 0) {
			Command ret = commandsStack.get(--commandsStackPointer);
			return ret;
		}
		return null;
	}
	
	public Command recoverLastGettedCommand() {
		if(commandsStackPointer < commandsStack.size()) {
			Command ret = commandsStack.get(commandsStackPointer++);
			return ret;
		}
		return null;
	}
	
	public int size() {
		return commandsStackPointer;
	}

	private void fitStackToMaxSize() {
		if(commandsStack.size() > maxStackSize) {
			commandsStack.remove(0);
			commandsStackPointer--;
		}
	}

	private void removeCommandsAboveCurrentStackPointer() {
		int stackSize;
		do {
			stackSize = commandsStack.size();
			commandsStack.remove(stackSize - 1);
		} while(stackSize > commandsStackPointer + 1);
	}
}
