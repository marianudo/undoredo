package me.marianonavas.undoredo.command;

public class EmailMigration {
	private final String sourceEmail;
	private final String destinationEmail;
	
	public EmailMigration(String sourceEmail, String destinationEmail) {
		super();
		this.sourceEmail = sourceEmail;
		this.destinationEmail = destinationEmail;
	}
	
	public void migrate() {
		System.out.println(String.format("%s account migrated to %s", sourceEmail, destinationEmail));
	}
	
	public void reverseMigration() {
		System.out.println(String.format("Rolled back migration from %s to %s", destinationEmail, sourceEmail));
	}
}
