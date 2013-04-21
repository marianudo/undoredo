package me.marianonavas.undoredo.command;

public class MigrateEmailAccountCommand implements Command {
	private final EmailMigration migration;

	public MigrateEmailAccountCommand(EmailMigration migration) {
		this.migration = migration;
	}

	@Override
	public void doIt() {
		migration.migrate();
	}

	@Override
	public String whoAmI() {
		return "I'm a email account migration command. Can you guess what I do?";
	}

	@Override
	public void undoIt() {
		migration.reverseMigration();
	}

}
