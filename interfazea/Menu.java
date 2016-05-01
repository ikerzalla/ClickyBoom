package interfazea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import clickyboom.*;

public class Menu extends JFrame {

	private JPanel contentPane;

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
		setResizable(false);
		setTitle("ClickyBoom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(302, 328);
		int x = (int) ((dim.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dim.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y-40);//40 hori Windows-en "Barra de tareas"-en altuera da
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
		
		JTextField izena = new JTextField(10);
		izena.setToolTipText("Idatzi zure izena");
		izena.setBounds(75, 80, 150, 30);
		
		Font letra = new Font("Courier", Font.BOLD, 15);
		izena.setFont(letra);
		
		izena.setBackground(Color.ORANGE);
		getContentPane().add(izena);
		
		/*izena.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        izena.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    }
		});*/
		
		
		JButton b1 = new JButton();
	    b1.setIcon(new ImageIcon(this.getClass().getResource("/argazkiak/Erreza.jpg")));
	    b1.setBounds(13, 200, b1.getIcon().getIconWidth(), b1.getIcon().getIconHeight());
	    getContentPane().add(b1);
	    b1.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				aukeratu("erraza", izena.getText());
			}
		});
	    
	    JButton b2 = new JButton();
	    b2.setIcon(new ImageIcon(this.getClass().getResource("/argazkiak/Normala.jpg")));
	    b2.setBounds(121, 155, b2.getIcon().getIconWidth(), b2.getIcon().getIconHeight());
	    getContentPane().add(b2);
	    b2.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				aukeratu("normala", izena.getText());
			}
		});
	    
	    JButton b3 = new JButton();
	    b3.setIcon(new ImageIcon(this.getClass().getResource("/argazkiak/Zaila.jpg")));
	    b3.setBounds(216, 200, b3.getIcon().getIconWidth(), b3.getIcon().getIconHeight());
	    getContentPane().add(b3);
	    b3.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				aukeratu("zaila", izena.getText());
			}
		});
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArtxibo = new JMenu("Artxibo");
		menuBar.add(mnArtxibo);
		
		JMenuItem mntmRanking = new JMenuItem("Ranking");
		mnArtxibo.add(mntmRanking);
		mntmRanking.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try {
					Ranking.getRanking().rankingDeia();
					
				} catch (Exception e1) {e1.printStackTrace();}
			}
		});
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmArauak = new JMenuItem("Arauak");
		mnHelp.add(mntmArauak);
	    

	}
	
	private void aukeratu(String pZailtasun, String pIzena){
		Jokoa j = Jokoa.getNireJokoa();
		j.aldatuJokalaria(pIzena);
		j.setZailtasun(pZailtasun);
		dispose();
		Pantaila p = Pantaila.getNPantaila();
		p.setVisible(true);
	}
	
	/*private void aukeratu(String pZailtasun){
		Jokoa j = Jokoa.getNireJokoa();
		
		dispose();
	    Pantaila p = Pantaila.getNPantaila();
		System.out.println("Pantaila sortu dugu");
		
		System.out.println("Tableroa sortu dugu");
	}*/
	
}
