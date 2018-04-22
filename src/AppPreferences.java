import java.util.prefs.*;

public class AppPreferences {
	
	private Preferences prefsRoot;
	private Preferences myprefs;
	
	
	public void setDefaultSettings() {
		//set and save the default settings
		saveSettings("pi", "raspberry", "192.168.1.1");
				
	}
	
	public void saveSettings(String name, String passw, String ipAddress) {
		//initialize our preferences node
		initPrefs();
		// 'put' our values at that node
		putKeyValue("Name", name);
		putKeyValue("Password", passw);
		putKeyValue("RPI-address", ipAddress);
		
	}
	
	
	public String getName() {
		initPrefs();
		return myprefs.get("Name", "pi1");
	}
	
	public String getPassword() {
		initPrefs();
		return myprefs.get("Password", "raspberry");
		
	}
	
	public String getRpiAddress() {
		initPrefs();
		// retrieve the RPI address stored or return the default
		return myprefs.get("RPI-address", "192.168.1.1");
	}
	
	private void initPrefs() {
		
		// Retrieve the user preference node for SSHManager
		prefsRoot = Preferences.userRoot();
		myprefs = prefsRoot.node("SSHManager");
	}
	
	private void putKeyValue(String key, String value) {
	
		//put the values with their keys
		//if the value = null throw an exception
		if(value != null) {
			myprefs.put(key, value);
		} else {
			throw new NullPointerException("Can not write a Null value to preference location");
		}
		
	}
	
}
