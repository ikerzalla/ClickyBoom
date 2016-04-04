package clickyboom;
import java.util.*;

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
	
}
