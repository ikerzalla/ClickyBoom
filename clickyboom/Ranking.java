package clickyboom;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public  class Ranking extends JFrame{
	private static Ranking nRanking = null;
	private ArrayList<Puntuaketa> lista  = new ArrayList<Puntuaketa>();
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame = getRanking();
					frame.rankingaKargatu("C://Users/Eka/workspace/ClickyBoom/src/Ranking/Ranking.txt");
					frame.ordenatuRankina();
					frame.jokalariakJarri();

				    
				    
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private Ranking()throws Exception{
		//nRanking.rankingaKargatu("C://Users/Eka/workspace/ClickyBoom/src/Ranking/Ranking.txt");
		setResizable(false);
		setTitle("ClickyBoom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 300);

	   
	        
	    
		}
	
	public static Ranking getRanking()throws Exception{
		if (nRanking == null){
			nRanking = new Ranking();
			//nRanking.lista = new ArrayList<Puntuaketa>();
		}
		return nRanking;
	}
	
	public void gehituPuntuaketa(Puntuaketa p)throws Exception{
		Ranking.nRanking.lista.add(p);
		Ranking.nRanking.ordenatuRankina();
	}
	private void ordenatuRankina(){
		Collections.sort(this.lista,Puntuaketa.PUNTUAKETA);
	}
	
	private void rankingaKargatu(String fitx) throws Exception{
		Puntuaketa p = null;
		int i;
		try{
			Scanner sarrera = new Scanner(new FileReader(fitx));
			String lerroa;
			while(sarrera.hasNext()){
				i=0;
				lerroa = sarrera.nextLine();
				String[] hitzak = lerroa.split("\t");
				p = new Puntuaketa(hitzak[i]);
				i++;
				p.puntuaketaAldatu(hitzak[i]);//COMO METO LA PUNTUACION ?
				this.gehituPuntuaketa(p);
				
			}
			sarrera.close();
			
		}catch(Exception e){System.out.println(e);}
	}
	
	private static void fitxSortu(String[] taula) throws IOException{
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
	
	}
	
	public void jokalariakJarri(){
		JPanel b = new JPanel();
		b.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(b);
		for (int i=0;i<10;i++){
			JPanel a = new JPanel();
			JLabel l = nRanking.lista.get(i).showpuntuaketa();
			a.add(l);
			nRanking.add(a);
			
		}
	}
}


