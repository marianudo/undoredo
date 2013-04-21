package me.marianonavas.undoredo.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class CommandExecutorTest {
	private CommandExecutor executor;
	
	@Before
	public void setUp() {
		executor = new CommandExecutor(10);
	}
	
	@Test
	public void testExecuteCommand() {
		Command cmd = mock(Command.class);
		executor.executeCommand(cmd);
		verify(cmd).doIt();
	}
	
	@Test
	public void testUndo() {
		Command cmd = mock(Command.class);
		executor.executeCommand(cmd);
		executor.undoLastCommand();
		verify(cmd).undoIt();
	}
	
	@Test
	public void testRedo() {
		Command cmd = mock(Command.class);
		executor.executeCommand(cmd);
		executor.undoLastCommand();
		executor.redoLastUndoedCommand();
		verify(cmd, times(2)).doIt();
		verify(cmd, times(1)).undoIt();
	}
}
