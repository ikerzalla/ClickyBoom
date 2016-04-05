package clickyboom;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;


public  class Ranking{
	private static Ranking nRanking;
	private ArrayList<Puntuaketa> lista;
	
	private Ranking(){}
	
	public static Ranking getRanking(){
		if (nRanking == null){
			nRanking = new Ranking();
		}
		return nRanking;
	}
	
	public void gehituPuntuaketa(Puntuaketa p){
		nRanking.lista.add(p);
		nRanking.ordenatuRankina();
	}
	private void ordenatuRankina(){
		Collections.sort(this.lista,Puntuaketa.PUNTUAKETA);
	}
	
	private void RankingaKargatu(String fitx) throws Exception{
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
