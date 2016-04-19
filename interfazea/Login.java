package interfazea;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clickyboom.Jokoa;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblUserName = new JLabel("User Name:");
		panel.add(lblUserName);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				izenaIrakurri(textField.getText());
			}
		});
		panel.add(btnOk);
		
		this.pack();
	}
	
	private void izenaIrakurri(String pUserName){
		Jokoa j = Jokoa.getNireJokoa();
		j.aldatuJokalaria(pUserName);
		j.inprimatuJokalaria();
		dispose();
		j.zailtasunaAukeratu();
	}
}