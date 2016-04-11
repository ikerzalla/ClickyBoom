package clickyboom;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public  class Ranking extends JFrame{
	private static Ranking nRanking = null;
	private ArrayList<Puntuaketa> lista  = new ArrayList<Puntuaketa>();
	private JPanel contentPane;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame =nRanking.getRanking();
					nRanking.rankingaKargatu("C://Users/Eka/workspace/ClickyBoom/src/Ranking/Ranking.txt");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private Ranking()throws Exception{
		//this.rankingaKargatu("C://Users/Eka/workspace/ClickyBoom/src/Ranking/Ranking.txt");
		
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

}


