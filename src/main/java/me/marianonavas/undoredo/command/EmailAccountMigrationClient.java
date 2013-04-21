package me.marianonavas.undoredo.command;

public class EmailAccountMigrationClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// First let's migrate the account pp@gmail.com
		String accountToMigrate = "pp@jimail.com";
		String destinationAccount = "ppsbrother@jimail.com";
		EmailMigration migration = new EmailMigration(accountToMigrate, destinationAccount);
		Command cmd = new MigrateEmailAccountCommand(migration);
		CommandExecutor exec = new CommandExecutor(5);
		exec.executeCommand(cmd);
		exec.undoLastCommand();
		exec.redoLastUndoedCommand();
	}

}
