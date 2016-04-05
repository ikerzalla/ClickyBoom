package clickyboom;

import java.util.Comparator;

public class Puntuaketa {
	private String jokalaria;
	private String puntuaketa;
	
	public Puntuaketa(String pJok){
		this.jokalaria = pJok;
		this.puntuaketa = "0";
	}
	
	public void puntuaketaAldatu(String z){
		this.puntuaketa = z;
	}
	
	static final Comparator<Puntuaketa> PUNTUAKETA = new Comparator<Puntuaketa>() {
		public int compare(Puntuaketa pPunt1, Puntuaketa pPunt2) {
			return new Integer(pPunt2.puntuaketa).compareTo(new Integer(pPunt1.puntuaketa));
		}
	 };
}
