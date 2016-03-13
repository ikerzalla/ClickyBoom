package clickyboom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Pantaila extends JFrame {

	private JPanel contentPane;
	private int altuera=25;
	private int luzera=12;
	private int zBomba=5;
	private int tamainua = 40;
	private JButton botoiak[][]=new JButton[altuera][luzera];
	private JPanel fondoa = new JPanel();
	private JPanel tableroa = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantaila frame = new Pantaila();
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
	public Pantaila() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);		
		contentPane.add(fondoa);
		
		tableroa.setPreferredSize(new Dimension(altuera*tamainua, luzera*tamainua));
		tableroa.setBackground(Color.BLUE);
		tableroa.setLayout(null); //Layout por defecto te cambia las dimensiones
		fondoa.add(tableroa);	
		
		
		kargatuBotoiak();
	}
	
	private void kargatuBotoiak(){
		for(int i=0; i<altuera; i++){
			for(int j=0; j<luzera; j++){
				botoiak[i][j] = new JButton();
				botoiak[i][j].setIcon(new ImageIcon("a.png"));
				tableroa.add(botoiak[i][j]);
				botoiak[i][j].setBounds(i*tamainua, j*tamainua, tamainua, tamainua);
				
				botoiak[i][j].setEnabled(true);				
				botoiak[i][j].setContentAreaFilled(false);
				botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("/argazkiak/a.png")));
				//botoiak[i][j].setText(" ");
				//botoiak[i][j].setSize(new Dimension(25, 25));
				botoiak[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						for(int i=0; i<altuera; i++){
							for(int j=0; j<luzera; j++){
								if (e.getSource().equals(botoiak[i][j])){
									JOptionPane a = new JOptionPane();
									//a.showConfirmDialog(null, "Has pusado el boton: "+i+","+j);
									a.showMessageDialog(null, "Has pulsado el boton: "+(i+1)+","+(j+1));
									botoiak[i][j].setEnabled(false);
									botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/c4.png")));
									//botoiak[i][j].setBackground(new Color(100, 50, 30));
									//botoiak[i][j].setText("1");
									
								}
							}
						}
					}
				});
			}
		}
	}

}
