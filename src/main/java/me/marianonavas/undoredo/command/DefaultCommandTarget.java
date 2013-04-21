package me.marianonavas.undoredo.command;

public class DefaultCommandTarget {
	private final String initState;
	private final String finalState;
	
	public DefaultCommandTarget(String source, String destination) {
		super();
		this.initState = source;
		this.finalState = destination;
	}
	
	public void doForward() {
		System.out.println(String.format("%s state transition to %s", initState, finalState));
	}
	
	public void doBackward() {
		System.out.println(String.format("Rolled back transition from %s to %s", finalState, initState));
	}
}
