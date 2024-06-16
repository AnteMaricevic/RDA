import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class main {

	private JFrame frame;
	private JTextField UsernameText;
	private JTextField EmailText;
	private JPasswordField PasswordField;
	private JPasswordField RePasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 572, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		UsernameText = new JTextField();
		UsernameText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		UsernameText.setBounds(128, 33, 141, 33);
		frame.getContentPane().add(UsernameText);
		UsernameText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(26, 26, 103, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(26, 90, 103, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(26, 213, 103, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		EmailText = new JTextField();
		EmailText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		EmailText.setBounds(85, 216, 184, 33);
		frame.getContentPane().add(EmailText);
		EmailText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Select your age: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(26, 265, 186, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox AgeComboBox = new JComboBox();
		AgeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		AgeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Under 18", "18-25", "25 or over"}));
		AgeComboBox.setBounds(222, 263, 119, 36);
		frame.getContentPane().add(AgeComboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Repeat password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(26, 150, 167, 30);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		PasswordField = new JPasswordField();
		PasswordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PasswordField.setBounds(117, 95, 141, 29);
		frame.getContentPane().add(PasswordField);
		
		RePasswordField = new JPasswordField();
		RePasswordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RePasswordField.setBounds(191, 155, 150, 29);
		frame.getContentPane().add(RePasswordField);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String username = UsernameText.getText();
	             String password = new String(PasswordField.getPassword());
	             String email = EmailText.getText();
	             String age = (String) AgeComboBox.getSelectedItem(); 
	             String repeatPassword = new String(RePasswordField.getPassword());
	             
	             if (username.isEmpty() || password.isEmpty() || email.isEmpty() || repeatPassword.isEmpty()) {
	                    System.out.println("Svi podaci moraju biti uneseni.");
	                    return;
	             }
	             if (!password.equals(repeatPassword)) {
	                    System.out.println("Ponovljena lozinka se ne podudara sa originalnom lozinkom.");
	                    return;
	                }
	             upisUBazu(username, password, email, age);
				
				Prikaz prikaz = new Prikaz();
				prikaz.Main_screen(new String[0]);
				frame.dispose();
				
			}
		});
		btnRegister.setForeground(new Color(255, 0, 0));
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.setFont(new Font("Lucida Bright", Font.BOLD, 22));
		btnRegister.setBounds(119, 400, 150, 48);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblNewLabel_4 = new JLabel("Already have an account?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 323, 235, 33);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prikaz prikaz = new Prikaz();
				prikaz.Main_screen(new String[0]);
				frame.dispose();
			}
		});
		btnLogin.setForeground(new Color(255, 0, 0));
		btnLogin.setBounds(282, 332, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
	
	 private void upisUBazu(String username, String password, String email, String age) {
	        try {
	            Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/rrpolic?" + "user=rrpolic&password=11");
	            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Users (Username_user, password_user, email_user, age_user) VALUES (?, ?, ?, ?)");
	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            stmt.setString(3, email);
	            stmt.setString(4, age);
	            stmt.executeUpdate();
	            stmt.close();
	            conn.close();
	            System.out.println("Podaci su uspješno upisani u bazu.");
	        } catch (SQLException ex) {
	            System.out.println("Greška prilikom upisa u bazu: " + ex.getMessage());
	        }
	 }    
}
