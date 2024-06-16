import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;

public class pNotes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JTextArea textAreaPregled;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			pNotes dialog = new pNotes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public pNotes() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 11, 354, 156);
		contentPanel.add(scrollPane);
		{
			textAreaPregled = new JTextArea();
			scrollPane.setViewportView(textAreaPregled);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		selectPatchNotes();
	}
	
	private void selectPatchNotes() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn =
					DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/rrpolic?" + "user=rrpolic&password=11");
			String sql = "SELECT DatumDeveloperNotesa,SadrzajDeveloperNotesa FROM DeveloperNotes";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			String tekst = "";
			while (rs.next()) {
				tekst+= "Datum: "+rs.getString("DatumDeveloperNotesa")+"\t"+"\n";
				tekst+= "Sadrzaj:"+rs.getString("SadrzajDeveloperNotesa")+"\t"+"\n";
			}
			textAreaPregled.setText(tekst);
			conn.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška",JOptionPane.ERROR_MESSAGE);
		}
	}
}
