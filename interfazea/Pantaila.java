package interfazea;

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

	private static final long serialVersionUID = 1L;
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
		this.setLocation(x, y-60);
		
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		tableroa = new JPanel(new BorderLayout());
		tableroa.setPreferredSize(new Dimension(altuera*tamainua, luzera*tamainua));
		tableroa.setBackground(Color.BLUE);
		tableroa.setLayout(null);
		
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
				botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("/skin/amarilla.png")));
				tableroa.add(botoiak[i][j]);
				botoiak[i][j].setBounds(i*tamainua, j*tamainua, tamainua, tamainua);
				botoiak[i][j].setEnabled(true);				
				botoiak[i][j].setContentAreaFilled(false);
				botoiak[i][j].addMouseListener(new SaguListener()
				);
			}
		}
		System.out.println("Botoiak kokatu dira");
	}
	
	private void kargatuGoiburuak(){
		
		//Aurpegia
		aurpegi = new JButton();
		aurpegi.setIcon(new ImageIcon(this.getClass().getResource("/skin/ongi.png")));
		goiburuak.add(aurpegi);
		aurpegi.setBounds(((tamainua*altuera) - tamainua)/ 2, (60 - tamainua) / 2, tamainua, tamainua);
		aurpegi.setEnabled(true);				
		aurpegi.setContentAreaFilled(false);
		
		aurpegi.addMouseListener(new SaguListener());
		
		//HACKS
		hacks = new JButton();
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
		 	case '1': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin/uno.png"))); break;
		 	case '2': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin/dos.png"))); break;
		 	case '3': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin/tres.png"))); break;
		 	case '4': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin/cuatro.png"))); break;
		 	case '5': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin/cinco.png"))); break;
		 	case '6': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin/seis.png"))); break;
		 	case '7': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin/siete.png"))); break;
		 	case '8': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin/ocho.png"))); break;
		 	case 'b': botoiak[i][j].setDisabledIcon(new ImageIcon(this.getClass().getResource("/skin/c4.png"))); break;
		 	default:
			break;
		}
		 botonOff(i, j);
	 }
	 
	 public void setAurpegiIrudi(char irudi) {
		 switch (irudi) {
		 	case 'o': aurpegi.setIcon(new ImageIcon(this.getClass().getResource("/skin/ongi.png"))); break;
		 	case 'a': aurpegi.setIcon(new ImageIcon(this.getClass().getResource("/skin/auskalo.png"))); break;
		 	case 'h': aurpegi.setIcon(new ImageIcon(this.getClass().getResource("/skin/hil.png"))); break;
		 	case 'g': aurpegi.setIcon(new ImageIcon(this.getClass().getResource("/skin/ggwp.png"))); break;
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
		 if(!notBoom){	
			 setAurpegiIrudi('h');
			 JOptionPane.showMessageDialog(null, "BOMBA bat zapaldu duzu. BOOM!");
			
		 }else{
			 setAurpegiIrudi('g');
			 JOptionPane.showMessageDialog(null, "Irabazi egin duzu!");
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
		 botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("/skin/amarilla.png")));	
		 setBanderaKopIrudi(++bandKop);
	 }
	 
	 public void banderaJarri(int i, int j) {
		 botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("/skin/bandera.png")));
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