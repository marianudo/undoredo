package me.marianonavas.undoredo.memento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class Caretaker {

	@Test
	public void testGenericOriginator() {
		String expected = "State 1";
		State state = new State(expected);
		GenericOriginator<State> originator = new GenericOriginator<State>(state);
		// Let's create a restore point for originator
		Memento<State> memento1 = originator.saveToMemento();
		assertEquals(state, memento1.getState());
	}

	@Test
	public void testUndo() {
		State state1 = new State("State 1");
		State state2 = new State("State 2");
		GenericOriginator<State> originator = new GenericOriginator<State>(state1);
		Memento<State> memento1 = originator.saveToMemento();
		originator.setState(state2);
		assertEquals(state2, originator.getState());
		originator.restoreFromMemento(memento1);
		assertEquals(state1, originator.getState());
	}

	@Test
	public void testRedo() {
		State state1 = new State("State 1");
		State state2 = new State("State 2");
		GenericOriginator<State> originator = new GenericOriginator<State>(state1);
		Memento<State> memento1 = originator.saveToMemento();
		originator.setState(state2);
		Memento<State> memento2 = originator.saveToMemento();
		originator.restoreFromMemento(memento1);
		assertFalse(originator.getState().equals(state2));
		originator.restoreFromMemento(memento2);
		assertEquals(state2, originator.getState());
	}
}
