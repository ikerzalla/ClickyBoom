package clickyboom;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfazea.Pantaila;


public  class Ranking extends JFrame{
	private static Ranking nRanking = null;
	private ListaPuntuaketa erraza  = new ListaPuntuaketa();
	private ListaPuntuaketa normala  = new ListaPuntuaketa();
	private ListaPuntuaketa zaila  = new ListaPuntuaketa();
	private String path;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public void rankingDeia(String z) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(z.equalsIgnoreCase("erraza")){
					erraza.ordenatu();
					jokalariakJarri(z);
					setTitle("Ranking Erreza");
					}
					else if (z.equalsIgnoreCase("normala")){
					normala.ordenatu();
					jokalariakJarri(z);
					setTitle("Ranking Normala");
					}
					else{
					zaila.ordenatu();
					jokalariakJarri(z);
					setTitle("Ranking Zaila");
					}
					setIconImage(Toolkit.getDefaultToolkit().getImage(Pantaila.class.getResource("/argazkiak/icono.jpg")));
					botoiakGehitu();
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private Ranking()throws Exception{
		path = System.getProperty("user.dir");
		setResizable(false);
		setTitle("Ranking");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		
	   
	        
	    
		}
	
	public static Ranking getRanking()throws Exception{
		if (nRanking == null){
			nRanking = new Ranking();
			nRanking.rankingaKargatu();
		}
		return nRanking;
	}
	
	public void sortuPuntuaketa(String jok, Integer kron) {
		try {
			Puntuaketa p = new Puntuaketa(jok, kron.toString());
			gehituPuntuaketa(p);
			rankingDeia(Jokoa.getNireJokoa().getZailtasuna());
			fitxategiaGorde();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void gehituPuntuaketa(Puntuaketa p)throws Exception{
		
		if(Jokoa.getNireJokoa().getZailtasuna().equalsIgnoreCase("erraza")){
			erraza.gehituPuntuaketa(p);
		}
		else if (Jokoa.getNireJokoa().getZailtasuna().equalsIgnoreCase("normala")){
			normala.gehituPuntuaketa(p);
		}
		else{
			zaila.gehituPuntuaketa(p);
		}
	}
	

	
	private void rankingaKargatu() throws Exception{
		try{
		String fitx  = path+"/src/Ranking/Ranking_Erreza.txt";
		String fitx1 = path+"/src/Ranking/Ranking_Normala.txt";
		String fitx2 = path+"/src/Ranking/Ranking_Zaila.txt";
		erraza.listaKargatu(fitx);
		normala.listaKargatu(fitx1);
		zaila.listaKargatu(fitx2);
		}catch(Exception e){System.out.println(e);}
	}
	
	/*private static void fitxSortu(String[] taula) throws IOException{
		File fitxategia = new File("Ranking.txt");
		try{
			FileWriter fw = new FileWriter(fitxategia);
			BufferedWriter output = new BufferedWriter(fw);
			int sz = taula.length;
			for (int i=0; i<sz; i++){
				output.write(taula[i]);
				output.newLine();
			}
			output.close();
		
			
		}catch(Exception e){JOptionPane.showMessageDialog(null, "ezin da fitxategia sortu");}
	
	}*/
	public void fitxategiaGorde(){
		try {
			String fitx  = path+"/src/Ranking/Ranking_Erreza.txt";
			String fitx1 = path+"/src/Ranking/Ranking_Normala.txt";
			String fitx2 = path+"/src/Ranking/Ranking_Zaila.txt";
			if ((Jokoa.getNireJokoa().getZailtasuna().equalsIgnoreCase("erraza"))){
				erraza.listaGorde(fitx);
			}
			else if ((Jokoa.getNireJokoa().getZailtasuna().equalsIgnoreCase("normala"))){
				normala.listaGorde(fitx1);
			}
			else{
				zaila.listaGorde(fitx2);
			}		
		} catch (Exception e) {e.printStackTrace();}
		

	}
	
	public void jokalariakJarri(String z){
		JPanel b = new JPanel();
		b.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(b);
		
		if(z.equalsIgnoreCase("erraza")){
			b = erraza.jokalariakJarri(b);
		}
		else if (z.equalsIgnoreCase("normala")){
			b = normala.jokalariakJarri(b);
		}
		else{
			b = zaila.jokalariakJarri(b);
		}

		
	}
	
	private void botoiakGehitu(){
		JButton b1 = new JButton("Atzera");
		nRanking.add(b1,BorderLayout.SOUTH);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
	}
	public void erakutsi(){
		nRanking.setVisible(true);
	}
	

}