package me.marianonavas.undoredo.command;

public interface Command {
	void doIt();
	
	void undoIt();
	
	String whoAmI();
}
