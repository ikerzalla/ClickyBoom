package interfazea;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clickyboom.Jokoa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Menu extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/argazkiak/icono.jpg")));
		setResizable(false);
		setTitle("ClickyBoom");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAukeratuZailtasuna = new JLabel("Aukeratu zailtasuna");
		lblAukeratuZailtasuna.setBounds(0, 11, 327, 41);
		lblAukeratuZailtasuna.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratuZailtasuna.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblAukeratuZailtasuna);
		
		JRadioButton rdbtnErreza = new JRadioButton("Erreza");
		rdbtnErreza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(rdbtnErreza);
		rdbtnErreza.setBounds(83, 75, 109, 23);
		contentPane.add(rdbtnErreza);
		
		JRadioButton rdbtnNormala = new JRadioButton("Normala");
		rdbtnNormala.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(rdbtnNormala);
		rdbtnNormala.setBounds(83, 101, 109, 23);
		contentPane.add(rdbtnNormala);
		
		JRadioButton rdbtnZaila = new JRadioButton("Zaila");
		rdbtnZaila.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(rdbtnZaila);
		rdbtnZaila.setBounds(83, 127, 109, 23);
		contentPane.add(rdbtnZaila);
		
		JButton btnJokatu = new JButton("Jokatu");
		btnJokatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jokoa j = Jokoa.getNireJokoa();
				if(rdbtnErreza.isSelected()){
					j.setZailtasun("erraza");
					itxi();
				}else if(rdbtnNormala.isSelected()){
					j.setZailtasun("normala");
					itxi();
				}else if(rdbtnZaila.isSelected()){
					j.setZailtasun("zaila");
					itxi();
				}else{
					JOptionPane.showMessageDialog(null, "Aukeratu aurretik dagoen zailtasun bat.");
				}
				Pantaila p = Pantaila.getNPantaila();
				System.out.println("Pantaila sortu dugu");
				p.setVisible(true);
				System.out.println("Tableroa sortu dugu");	
			}
		});
		btnJokatu.setBounds(123, 172, 89, 23);
		contentPane.add(btnJokatu);
	}
	
	private void itxi(){
		this.dispose();
	}
}
