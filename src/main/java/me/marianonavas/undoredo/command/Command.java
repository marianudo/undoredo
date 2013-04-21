package me.marianonavas.undoredo.command;

public interface Command {
	void doItNow();
	
	String whoAmI();
}
