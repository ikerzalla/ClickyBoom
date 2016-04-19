package interfazea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import clickyboom.Jokoa;
import clickyboom.Observer;


public class Pantaila extends JFrame implements Observer {

	private JPanel contentPane;
	private int altuera, luzera;
	private int tamainua = 40;
	private JButton botoiak[][];
	private JPanel fondoa = new JPanel();
	private JPanel tableroa = new JPanel();
	private static Pantaila nPantaila = null;
	

	
	public static void main(String []args) {
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

	
	private Pantaila() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pantaila.class.getResource("/argazkiak/icono.jpg")));
		setTitle("ClickyBoom");
		this.altuera = Jokoa.getNireJokoa().getTableroa().getAltuera();
		this.luzera = Jokoa.getNireJokoa().getTableroa().getZabalera();
		botoiak = new JButton[altuera][luzera];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 228, 146);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dim.getWidth() - (altuera*42)+10) / 2);
		int y = (int) ((dim.getHeight() - (luzera*42)+36) / 2);
		this.setLocation(x, y-40);//40 hori Windows-en "Barra de tareas"-en altuera da
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
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
		this.pack();
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
				botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("/skin1/amarilla.png")));
				tableroa.add(botoiak[i][j]);
				botoiak[i][j].setBounds(i*tamainua, j*tamainua, tamainua, tamainua);
				botoiak[i][j].setEnabled(true);				
				botoiak[i][j].setContentAreaFilled(false);
				//botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("Button.png")));
				//botoiak[i][j].setText(" ");
				//botoiak[i][j].setSize(new Dimension(25, 25));
				
				botoiak[i][j].addMouseListener(new SaguListener() /*{
					
					public void mouseClicked(MouseEvent e) {
						for(int i=0; i<altuera; i++){
							for(int j=0; j<luzera; j++){
								System.out.println("se ha mirado "+j+" , "+i);
								if (e.getSource().equals(botoiak[i][j])){
									Jokoa.getNireJokoa().getTableroa().ezkerClickEgin(i, j);
									//JOptionPane a = new JOptionPane();
									//a.showConfirmDialog(null, "Has pusado el boton: "+i+","+j);
									//a.showMessageDialog(null, "Has pulsado el boton: "+(i+1)+","+(j+1));
									//botonOff(i,j);
									//botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("c4.png")));
									//botoiak[i][j].setBackground(new Color(100, 50, 30));
									//botoiak[i][j].setText("1");
								}
							}
						}
					}
					
				}*/);				
			}
		}
		System.out.println("Botoiak kokatu dira");
	}

	 public void botonOff(int alt, int zab){
		 if (entzutenDago(alt, zab)) {
			botoiak[alt][zab].setEnabled(false);
		 }
	}
	
	 public void setIrudi(char irudi, int i, int j) {
		 System.out.println(j + "," + i + " posizioko laukiari irudia jarriko zaio...");
		 switch (irudi) {
		 	case '1': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin1/uno.png"))); break;
		 	case '2': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin1/dos.png"))); break;
		 	case '3': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin1/tres.png"))); break;
		 	case '4': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin1/cuatro.png"))); break;
		 	case '5': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin1/cinco.png"))); break;
		 	case '6': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin1/seis.png"))); break;
		 	case '7': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin1/siete.png"))); break;
		 	case '8': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin1/ocho.png"))); break;
		 	case 'b': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin1/c4.png"))); break;
		 	//case 'h': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/argazkiak/laukia.jpg"))); break; //falta una imagen
		 	default:
			break;
		}
		 botonOff(i, j);
	 }
	 public boolean entzutenDago(int alt, int zab){
		 return botoiak[alt][zab].isEnabled();
	 }
	 
	 public void amaitu(boolean notBoom){
		 JOptionPane a = new JOptionPane();
		 if(!notBoom){	
			a.showMessageDialog(null, "BOMBA bat zapaldu duzu. BOOM!");
			dispose();
			
			//RANKINARI DEITU ??
			
		//	Jokoa.getNireJokoa().jokatu();
			
		 }else{
			 a.showMessageDialog(null, "Irabazi egin duzu!");
			 dispose();
			 
			 //RANKINARI DEITU ??
			
		 }
	 }

	 public void irudiHutsaJarri(int i, int j) {
		 botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("/skin1/amarilla.png")));	
	 }
	 
	 public void banderaJarri(int i, int j) {
		 botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("/skin1/bandera.png"))); //Irudi hau falta da
	 }
	 
	 @Override
		public void updateIrudia(char ch, int i, int j) {
		 if (ch == 'x')
			 irudiHutsaJarri(i, j);
		 else if (ch == 'm')
			 banderaJarri(i, j);
		 else
			 setIrudi(ch, i, j);
		}
	 
	 private class SaguListener extends MouseAdapter{
		 public SaguListener(){}
		 
		 public void mouseClicked(MouseEvent e) {
				for(int i=0; i<altuera; i++){
					for(int j=0; j<luzera; j++){
						System.out.println("se ha mirado "+j+" , "+i);
						if (e.getSource().equals(botoiak[i][j])){
							if(SwingUtilities.isLeftMouseButton(e)){
								ezkerClickEgin(i, j);
							}
							else  if(SwingUtilities.isRightMouseButton(e)){
								eskuinClickEgin(i, j);
							}
						}
					}
				}
			}
		 
		 private void eskuinClickEgin(int i, int j) {
			 if (entzutenDago(i, j)){
				 Jokoa.getNireJokoa().eskuinClickEgin(i, j);
			 }
		}

		private void ezkerClickEgin(int i, int j) {
			 if (entzutenDago(i, j)){
				 Jokoa.getNireJokoa().ezkerClickEgin(i, j);
			 }
		 }
	 }

}


