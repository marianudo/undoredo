package me.marianonavas.undoredo.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class CommandStackTest {
	private CommandStack stack;
	
	@Test
	public void testOverflowStack() {
		stack = new CommandStack(2);
		final int commandsSize = 3;
		pushNCommandsIntoStack(commandsSize);
		// The first command should have been deleted from the stack
		assertEquals(2, stack.size());
	}
	
	@Test
	public void testReverseStack() {
		stack = new CommandStack(2);
		final int commandsSize = 3;
		Command[] cmds = pushNCommandsIntoStack(commandsSize);
		// The first command should have been deleted from the stack
		assertSame(cmds[2], stack.getLastCommand());
		assertSame(cmds[1], stack.getLastCommand());
		assertNull(stack.getLastCommand());
	}
	
	@Test
	public void testForwardAndBackwardInStack() {
		final int commandsSize = 3;
		Command[] cmds = instanceMockCommands(commandsSize);
		stack = new CommandStack(commandsSize);
		pushCommandsIntoStack(cmds);
		assertSame(cmds[2], stack.getLastCommand());
		assertSame(cmds[1], stack.getLastCommand());
		assertSame(cmds[0], stack.getLastCommand());
		assertNull(stack.getLastCommand());
		assertSame(cmds[0], stack.recoverLastGettedCommand());
		assertSame(cmds[1], stack.recoverLastGettedCommand());
		assertSame(cmds[2], stack.recoverLastGettedCommand());
		assertNull(stack.recoverLastGettedCommand());
		assertSame(cmds[2], stack.getLastCommand());
		assertSame(cmds[1], stack.getLastCommand());
	}
	
	@Test
	public void testPushOnAReversedStack() {
		final int commandsSize = 3;
		Command[] cmds = instanceMockCommands(commandsSize);
		stack = new CommandStack(commandsSize);
		pushCommandsIntoStack(cmds);
		stack.getLastCommand();
		stack.getLastCommand();
		Command cmd1 = mock(Command.class);
		stack.push(cmd1);
		assertSame(cmd1, stack.getLastCommand());
		assertSame(cmds[0], stack.getLastCommand());
		assertNull(stack.getLastCommand());
	}
	
	@Test
	public void testPushAndOverflowOnAReversedStack() {
		final int commandsSize = 3;
		Command[] cmds = instanceMockCommands(commandsSize);
		stack = new CommandStack(commandsSize);
		pushCommandsIntoStack(cmds);
		stack.getLastCommand();
		Command cmd1 = mock(Command.class);
		Command cmd2 = mock(Command.class);
		stack.push(cmd1);
		stack.push(cmd2);
		assertSame(cmd2, stack.getLastCommand());
		assertSame(cmd1, stack.getLastCommand());
		assertSame(cmds[1], stack.getLastCommand());
		assertNull(stack.getLastCommand());
	}

	private Command[] pushNCommandsIntoStack(final int numberOfCommands) {
		Command[] cmds = instanceMockCommands(numberOfCommands);
		pushCommandsIntoStack(cmds);
		return cmds;
	}

	private void pushCommandsIntoStack(Command[] cmds) {
		for (Command command : cmds) {
			stack.push(command);
		}
	}
	
	private Command[] instanceMockCommands(int numOfCommands) {
		Command[] cmds = new Command[numOfCommands];
		for(int i = 0; i < numOfCommands; i++) {
			cmds[i] = mock(Command.class);
		}
		return cmds;
	}
}
