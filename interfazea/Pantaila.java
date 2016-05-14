package interfazea;
import clickyboom.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import clickyboom.Jokoa;
import clickyboom.Observer;
import clickyboom.Ranking;


public class Pantaila extends JFrame implements Observer {

	private JPanel contentPane;
	private int altuera, luzera;
	private int tamainua = 40;
	
	private JPanel goiburuak;
	private JLabel min0, biPuntu, seg0, seg1;
	
	private JButton aurpegi,hacks;
	private JLabel banderak0, banderak1;
	private Integer bandKop;
	
	private JPanel tableroa;
	private JButton botoiak[][];
	
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
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dim.getWidth() - (altuera*42)+10) / 2);
		int y = (int) ((dim.getHeight() - (luzera*42)+36) / 2);
		this.setLocation(x, y-60);//40 hori Windows-en "Barra de tareas"-en altuera da
		
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		
		tableroa = new JPanel(new BorderLayout());
		tableroa.setPreferredSize(new Dimension(altuera*tamainua, luzera*tamainua));
		tableroa.setBackground(Color.BLUE);
		tableroa.setLayout(null); //Layout por defecto te cambia las dimensiones
		
		goiburuak = new JPanel(new BorderLayout());
		goiburuak.setPreferredSize(new Dimension(altuera*tamainua, 60));
		goiburuak.setBackground(Color.CYAN);
		goiburuak.setLayout(null);
		
		bandKop = Jokoa.getNireJokoa().getTableroa().getBonbaKop();
		
		kargatuBotoiak();
		kargatuGoiburuak();
		
		contentPane.add(goiburuak, BorderLayout.NORTH);
		contentPane.add(tableroa, BorderLayout.CENTER);
		
		
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
					
				}*/
				);
			}
		}
		
		
		System.out.println("Botoiak kokatu dira");
	}
	
	private void kargatuGoiburuak(){
		
		//Aurpegia
		aurpegi = new JButton();
		aurpegi.setIcon(new ImageIcon(this.getClass().getResource("/skin1/ongi.png")));
		goiburuak.add(aurpegi);
		aurpegi.setBounds(((tamainua*altuera) - tamainua)/ 2, (60 - tamainua) / 2, tamainua, tamainua);
		aurpegi.setEnabled(true);				
		aurpegi.setContentAreaFilled(false);
		
		aurpegi.addMouseListener(new SaguListener());
		
		//HACKS !!!
		hacks = new JButton();
		//hacks.setIcon(new ImageIcon(this.getClass().getResource("/skin1/ongi.png")));
		goiburuak.add(hacks);
		hacks.setBounds(0,0,2,2);
		hacks.setEnabled(true);				
		hacks.setContentAreaFilled(false);
		
		hacks.addMouseListener(new SaguListener());
		
		//Kronometroa
		min0 = new JLabel(new ImageIcon(this.getClass().getResource("/zenbakiak/0.png")));
		goiburuak.add(min0);
		min0.setBounds(10, 1, 32, 58);
		
		biPuntu = new JLabel(new ImageIcon(this.getClass().getResource("/zenbakiak/biPuntu.png")));
		goiburuak.add(biPuntu);
		biPuntu.setBounds(41, 1, 15, 58);
		
		seg1 = new JLabel(new ImageIcon(this.getClass().getResource("/zenbakiak/0.png")));
		goiburuak.add(seg1);
		seg1.setBounds(55, 1, 32, 58);
		
		seg0 = new JLabel(new ImageIcon(this.getClass().getResource("/zenbakiak/0.png")));
		goiburuak.add(seg0);
		seg0.setBounds(86, 1, 32, 58);
		
		//Bandera Kopurua
		banderak0 = new JLabel();
		goiburuak.add(banderak0);
		banderak0.setBounds((tamainua*altuera) - 73, 1, 32, 58);
		
		banderak1 = new JLabel();
		goiburuak.add(banderak1);
		banderak1.setBounds((tamainua*altuera) - 42, 1, 32, 58);
		
		setBanderaKopIrudi(bandKop);
		
		//Goiko Menu Barra
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArtxibo = new JMenu("Artxibo");
		menuBar.add(mnArtxibo);
		
		JMenu mnRanking = new JMenu("Ranking:    ");
		mnArtxibo.add(mnRanking);
		
		JMenuItem mntmErraza = new JMenuItem("Erraza ");
		mnRanking.add(mntmErraza);
		mntmErraza.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try {	
					Ranking.getRanking().rankingDeia("erraza");
				} catch (Exception e1) {e1.printStackTrace();}
			}
		});		
		
		JMenuItem mntmNormala = new JMenuItem("Normala ");
		mnRanking.add(mntmNormala);
		mntmNormala.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try {	
					Ranking.getRanking().rankingDeia("normala");
				} catch (Exception e1) {e1.printStackTrace();}
			}
		});
		
		JMenuItem mntmZaila = new JMenuItem("Zaila ");
		mnRanking.add(mntmZaila);
		mntmZaila.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try {	
					Ranking.getRanking().rankingDeia("zaila");
				} catch (Exception e1) {e1.printStackTrace();}
			}
		});
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmArauak = new JMenuItem("Arauak");
		mnHelp.add(mntmArauak);
		mntmArauak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Arauak a = new Arauak();
				a.setVisible(true);
			}
		});
	}

	 public void botonOff(int alt, int zab){
		 if (entzutenDago(alt, zab)) {
			botoiak[alt][zab].setEnabled(false);
		 }
	}
	
	 public void setIrudi(char irudi, int i, int j) {
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
		 	default:
			break;
		}
		 botonOff(i, j);
	 }
	 
	 public void setAurpegiIrudi(char irudi) {
		 switch (irudi) {
		 	case 'o': aurpegi.setIcon(new ImageIcon(this.getClass().getResource("/skin1/ongi.png"))); break;
		 	case 'a': aurpegi.setIcon(new ImageIcon(this.getClass().getResource("/skin1/auskalo.png"))); break;
		 	case 'h': aurpegi.setIcon(new ImageIcon(this.getClass().getResource("/skin1/hil.png"))); break;
		 	case 'g': aurpegi.setIcon(new ImageIcon(this.getClass().getResource("/skin1/ggwp.png"))); break;
		 	default:
			break;
		}
	 }
	 
	 private void setBanderaKopIrudi(Integer zenb){
		 banderak0.setIcon(new ImageIcon(this.getClass().getResource("/zenbakiak/" + zenb/10 + ".png")));
		 banderak1.setIcon(new ImageIcon(this.getClass().getResource("/zenbakiak/" + zenb%10 + ".png")));
	 }
	 
	 public boolean entzutenDago(int alt, int zab){
		 return botoiak[alt][zab].isEnabled();
	 }
	 
	 public void amaitu(boolean notBoom){
		 JOptionPane a = new JOptionPane();
		 if(!notBoom){	
			 setAurpegiIrudi('h');
			 a.showMessageDialog(null, "BOMBA bat zapaldu duzu. BOOM!");
			
			 //RANKINARI DEITU ??
			
			 //	Jokoa.getNireJokoa().jokatu();
			
		 }else{
			 setAurpegiIrudi('g');
			 a.showMessageDialog(null, "Irabazi egin duzu!");
			 
			 //RANKINARI DEITU ??
			 try {
				Ranking r = Ranking.getRanking();
				System.out.println("Rankina dut");
				Puntuaketa p = new Puntuaketa(Jokoa.getNireJokoa().getJokalaria());
				System.out.println("Puntuaketa sortu dut");
				Integer i = Jokoa.getNireJokoa().getKrono();
				System.out.println("kronoa daukat");
				p.puntuaketaAldatu(i.toString());
				System.out.println("puntuaketa aldatu dut");
				r.gehituPuntuaketa(p);
				System.out.println("puntuaketa gehitu dut");
				r.rankingDeia(Jokoa.getNireJokoa().getZailtasuna());
				System.out.println("rankina erakusten dut");
				r.fitxategiaGorde();
				System.out.println("fitxategia gorde dut");
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		 }
		 restart();
	 }

	 private void restart() {
		 dispose();
		 Jokoa.getNireJokoa().jokoaRestart();
		 nPantaila=null;
		 Pantaila p = Pantaila.getNPantaila();
		 System.out.println("Pantaila sortu dugu");
		 p.setVisible(true);
		 System.out.println("Tableroa sortu dugu");

		
	}


	public void irudiHutsaJarri(int i, int j) {
		 botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("/skin1/amarilla.png")));	
		 setBanderaKopIrudi(++bandKop);
	 }
	 
	 public void banderaJarri(int i, int j) {
		 botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("/skin1/bandera.png")));
		 setBanderaKopIrudi(--bandKop);
	 }
	 
	 public void eguneratuKronometroa(Integer pKron) {
		 Integer min = 0;
		 Integer seg = pKron;
		 if(pKron>60){
			 seg = pKron % 60;
			 min = pKron / 60;
		 }
		 min0.setIcon(new ImageIcon(this.getClass().getResource("/zenbakiak/" + min + ".png")));
		 seg1.setIcon(new ImageIcon(this.getClass().getResource("/zenbakiak/" + seg/10 + ".png")));
		 seg0.setIcon(new ImageIcon(this.getClass().getResource("/zenbakiak/" + seg%10 + ".png")));
		 
		/* if(seg<10){
			 kronometroa.setText(min.toString() + ":0" + seg.toString());
		 }
		 else{
			 kronometroa.setText(min.toString() + ":" + seg.toString());
		 }
		 */
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
			 if (e.getSource().equals(aurpegi)){
				 restart();
			 }
			 else if(e.getSource().equals(hacks)){
				 Jokoa.getNireJokoa().amaitu(true);
			 }
			 else{
				for(int i=0; i<altuera; i++){
					for(int j=0; j<luzera; j++){
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
		 }
		 public void mousePressed(MouseEvent e){
			 if (!e.getSource().equals(aurpegi)){
				 setAurpegiIrudi('a');
			 }
		 }
		 public void mouseReleased(MouseEvent e){
			 if (!e.getSource().equals(aurpegi)){
				 setAurpegiIrudi('o');
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


