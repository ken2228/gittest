import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class window {

	private JFrame frame;
	SSHManager instance = new SSHManager("pi","raspberry", "192.168.178.122", "");
	private JTextField textLogin;
	private JTextField textPass;
	private JTextField textIP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public window() {
		initialize();
		
		instance.connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 11, 414, 206);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("Dir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texts = instance.sendCommand("ls -al");
				textPane.setText(texts);
			}
		});
		btnNewButton.setBounds(10, 336, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSaveSettings = new JButton("Save settings");
		btnSaveSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AppPreferences prefs = new AppPreferences();
				prefs.saveSettings(textLogin.getText(), textPass.getText(), textIP.getText());
			}
		});
		btnSaveSettings.setBounds(322, 336, 89, 23);
		frame.getContentPane().add(btnSaveSettings);
		
		JButton btnSetDefaultsettings = new JButton("set defaultsettings");
		btnSetDefaultsettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppPreferences prefs = new AppPreferences();
				prefs.setDefaultSettings();
			}
		});
		btnSetDefaultsettings.setBounds(168, 336, 89, 23);
		frame.getContentPane().add(btnSetDefaultsettings);
		
		JLabel lblLoginname = new JLabel("loginname:");
		lblLoginname.setBounds(449, 29, 65, 14);
		frame.getContentPane().add(lblLoginname);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(449, 54, 65, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblIpaddress = new JLabel("IP-Address:");
		lblIpaddress.setBounds(449, 79, 89, 14);
		frame.getContentPane().add(lblIpaddress);
		
		textLogin = new JTextField();
		textLogin.setBounds(548, 29, 103, 20);
		frame.getContentPane().add(textLogin);
		textLogin.setColumns(10);
		
		textPass = new JTextField();
		textPass.setBounds(548, 54, 103, 20);
		frame.getContentPane().add(textPass);
		textPass.setColumns(10);
		
		textIP = new JTextField();
		textIP.setBounds(548, 79, 103, 20);
		frame.getContentPane().add(textIP);
		textIP.setColumns(10);
		
		JButton btnLoadSettings = new JButton("Load settings");
		btnLoadSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AppPreferences prefs = new AppPreferences();
				
				textLogin.setText(prefs.getName());
				textPass.setText(prefs.getPassword());
				textIP.setText(prefs.getRpiAddress());
			}
		});
		btnLoadSettings.setBounds(449, 336, 89, 23);
		frame.getContentPane().add(btnLoadSettings);
		btnLoadSettings.doClick();
	}
}
