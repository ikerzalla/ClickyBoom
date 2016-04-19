package interfazea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import clickyboom.Jokoa;

public class Menu2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu2 frame = new Menu2();
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
	public Menu2() {
		setResizable(false);
		setTitle("ClickyBoom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(302, 278);
		int x = (int) ((dim.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dim.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    JLabel l = new JLabel(new ImageIcon(this.getClass().getResource("/argazkiak/FondoMenu.jpg")));
	    setContentPane(l);
	    botoiak();	    
	    this.pack();
	}
	
	private void botoiak(){
		JButton b1 = new JButton();
	    b1.setIcon(new ImageIcon(this.getClass().getResource("/argazkiak/Erreza.jpg")));
	    b1.setBounds(15, 150, b1.getIcon().getIconWidth(), b1.getIcon().getIconHeight());
	    getContentPane().add(b1);
	    b1.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				aukeratu("erraza");
			}
		});
	    
	    JButton b2 = new JButton();
	    b2.setIcon(new ImageIcon(this.getClass().getResource("/argazkiak/Normala.jpg")));
	    b2.setBounds(113, 111, b2.getIcon().getIconWidth(), b2.getIcon().getIconHeight());
	    getContentPane().add(b2);
	    b2.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				aukeratu("normala");
			}
		});
	    
	    JButton b3 = new JButton();
	    b3.setIcon(new ImageIcon(this.getClass().getResource("/argazkiak/Zaila.jpg")));
	    b3.setBounds(220, 150, b3.getIcon().getIconWidth(), b3.getIcon().getIconHeight());
	    getContentPane().add(b3);
	    b3.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				aukeratu("zaila");
			}
		});
	}
	
	private void aukeratu(String zailtasun){
		Jokoa j = Jokoa.getNireJokoa();
		j.setZailtasun(zailtasun);
	    Pantaila p = Pantaila.getNPantaila();
		System.out.println("Pantaila sortu dugu");
		p.setVisible(true);
		System.out.println("Tableroa sortu dugu");
		dispose();
	}
}
