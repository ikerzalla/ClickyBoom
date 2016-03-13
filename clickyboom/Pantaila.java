package clickyboom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Pantaila extends JFrame {

	private JPanel contentPane;
	private int altuera;
	private int luzera;
	private int tamainua = 40;
	private JButton botoiak[][];
	private JPanel fondoa = new JPanel();
	private JPanel tableroa = new JPanel();
	private static Pantaila nPantaila = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantaila frame = Pantaila.getNPantaila();
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
	private Pantaila() {
		//Tableroa taula = Jokoa.getNireJokoa().getTableroa();
		luzera=25;
		altuera=12;
		//luzera = taula.getZabalera();
		//altuera = taula.getAltuera();
		botoiak = new JButton[luzera][altuera];
		
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
	
	public static Pantaila getNPantaila() {
		if (nPantaila == null) {
			nPantaila = new Pantaila();
		}
		return nPantaila;
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
				//botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("/argazkiak/Button.png")));
				//botoiak[i][j].setText(" ");
				//botoiak[i][j].setSize(new Dimension(25, 25));
				botoiak[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						for(int i=0; i<altuera; i++){
							for(int j=0; j<luzera; j++){
								if (e.getSource().equals(botoiak[i][j])){
									Jokoa.getNireJokoa().getTableroa().clickEgin(i, j);
									//JOptionPane a = new JOptionPane();
									//a.showConfirmDialog(null, "Has pusado el boton: "+i+","+j);
									//a.showMessageDialog(null, "Has pulsado el boton: "+(i+1)+","+(j+1));
									//botonOff(i,j);
									//botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/c4.png")));
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

	 public void botonOff(int i, int j){
			botoiak[i][j].setEnabled(false);
	}
	
	 public void setIrudi(char irudi, int i, int j) {
		 switch (irudi) {
		 	case '1': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/uno.png"))); break;
		 	case '2': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/dos.png"))); break;
		 	case '3': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/tres.png"))); break;
		 	case '4': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/cuatro.png"))); break;
		 	case '5': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/cinco.png"))); break;
		 	case '6': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/seis.png"))); break;
		 	case '7': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/siete.png"))); break;
		 	case '8': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/ocho.png"))); break;
		 	case 'b': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/c4.png"))); break;
		 	case 'h': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/arrow.png"))); break; //falta una imagen
		 	default:
			break;
		}
	 }
}
