
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sendCommand");

	     /**
	      * YOU MUST CHANGE THE FOLLOWING
	      * FILE_NAME: A FILE IN THE DIRECTORY
	      * USER: LOGIN USER NAME
	      * PASSWORD: PASSWORD FOR THAT USER
	      * HOST: IP ADDRESS OF THE SSH SERVER
	     **/
	     String command = "ls oor";
	     String userName = "pi";
	     String password = "raspberry";
	     String connectionIP = "192.168.137.2";
	     SSHManager instance = new SSHManager(userName, password, connectionIP, "");
	     String errorMessage = instance.connect();

	     if(errorMessage != null)
	     {
	        System.out.println(errorMessage);
	       
	     }

	     String expResult = "oor\n";
	     // call sendCommand for each command and the output 
	     //(without prompts) is returned
	     String result = instance.sendCommand(command);

	     System.out.println("expected: " + expResult);
	     System.out.println("Result: "+ result);
	     
	     result = instance.sendCommand("ls -al");
	     
	     //System.out.println("ls -al returns: " + result);
	     
	     // close only after all commands are sent
	     instance.close();
	}

}
