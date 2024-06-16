import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LVL1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LVL1 window = new LVL1();
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
	public LVL1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 663, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrYouWakeUp = new JTextArea();
		txtrYouWakeUp.setText("You wake up with a start. \r\nYour dreams were filled with calm until a sudden image startled you awake.\r\nYou rack your mind for minutes while lying in bed, trying to remember\r\nexactly what was that woke you but to no avail. Eventually you grew bored\r\nof thinking about it and chose to start your day.\r\n\r\n\t\t\t     What will you do?");
		txtrYouWakeUp.setBounds(10, 11, 615, 228);
		frame.getContentPane().add(txtrYouWakeUp);
		
		JButton btnBathroom = new JButton("Go to the bathroom");
		btnBathroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bathroom bathroom = new bathroom();
				bathroom.main(new String[0]);
				frame.dispose();
			}
		});
		btnBathroom.setBounds(254, 321, 166, 53);
		frame.getContentPane().add(btnBathroom);
		
		JButton btnKitchen = new JButton("Go to the kitchen");
		btnKitchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kitchen kitchen = new kitchen();
				kitchen.main(new String[0]);
				frame.dispose();
			}
		});
		btnKitchen.setBounds(32, 321, 166, 53);
		frame.getContentPane().add(btnKitchen);
		
		JButton btnOut = new JButton("Go change and head out");
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outside outside = new outside();
				outside.main(new String[0]);
				frame.dispose();
			}
		});
		btnOut.setBounds(459, 321, 166, 53);
		frame.getContentPane().add(btnOut);
	}
}
