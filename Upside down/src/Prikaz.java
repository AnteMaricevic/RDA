import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Prikaz {

	private JFrame frame;
	public static User user=null;

	/**
	 * Launch the application.
	 */
	public static void Main_screen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prikaz window = new Prikaz();
					JPanel panel = new JPanel(new GridLayout(2, 2, 2, 2));
				    JLabel labelU = new JLabel("Korisničko ime:");
					JTextField username_J = new JTextField();
				    panel.add(labelU);
					panel.add(username_J);
				    JLabel labelP = new JLabel("Lozinka:");
					JPasswordField password_J = new JPasswordField();
					panel.add(labelP);
					panel.add(password_J);
					
					if (JOptionPane.showConfirmDialog(null,panel, "Unesite korisničko ime i lozinku",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
						String username= username_J.getText();
						String password = String.valueOf(password_J.getPassword());
						
						provjeriUser(username, password);
						if (user==null) {
							JOptionPane.showMessageDialog(null, "Ne postoji korisnik u bazi","Greška", JOptionPane.ERROR_MESSAGE);
						} else {
							if (user.isAdmin()) {
								window.frame.setVisible(true);
							} else {
								window.frame.setVisible(true);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
				private void provjeriUser(String username, String password) {
					// TODO Auto-generated method stub
					try {
						Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
						Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/rrpolic?" +
							                                   "user=rrpolic&password=11");
						
						String sql = "SELECT * FROM Users WHERE Username_user=? AND Password_user=?";
						PreparedStatement stmt = conn.prepareStatement(sql);
						stmt.setString(1, username);
						stmt.setString(2, password);
						ResultSet rs = stmt.executeQuery();
						if (rs.next()) {
							user = new User(rs.getInt("Id_user"), rs.getString("Username_user"),rs.getInt("Health"),rs.getInt("Sanity"),rs.getInt("Hunger"),rs.getInt("Energy"),rs.getString("Type_user"));									
						}	
						conn.close();
							
					} catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
				}
						
			}		
		});
	}

	/**
	 * Create the application.
	 */
	public Prikaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 291, 237);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LVL1 LVL1 = new LVL1();
				LVL1.main(new String[0]);
				frame.dispose();
				
			}
		});
		btnStartGame.setBounds(51, 52, 131, 21);
		frame.getContentPane().add(btnStartGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		btnExit.setBounds(51, 116, 131, 21);
		frame.getContentPane().add(btnExit);
		
		JButton btnPatchNotes = new JButton("Patch notes");
		btnPatchNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pNotes dlg = new pNotes();
				dlg.setVisible(true);
			}
		});
		btnPatchNotes.setBounds(51, 84, 131, 21);
		frame.getContentPane().add(btnPatchNotes);
	}
}
