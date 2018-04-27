
public class CommandBuilder {
	SSHManager instance;
	
	public CommandBuilder(String username, String passw, String ip) {
		
		instance = new SSHManager(username, passw, ip, "");
		instance.connect();
		
	}
	
	public String listdirectory(String path) {
		
		return instance.sendCommand(CommandList.LS.command());
		
	}
}
