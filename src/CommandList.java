
public enum CommandList {

	LS("ls -al"),
	PWD("pwd"),
	CAT("cat"),
	ECHO("echo "),
	OUT("out");
	
	private String command;
	
	CommandList(String command) {
		
		this.command = command;
	}
	
	public String command() {
		return command;
	}
}
