
public enum CommandList {
	
	LS("ls -al"),
	PWD("pwd"),
	CAT("cat");
	
	private String command;
	
	CommandList(String command) {
		
		this.command = command;
	}
	
	public String command() {
		return command;
	}
}
