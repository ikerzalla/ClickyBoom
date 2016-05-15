package clickyboom;

import java.io.*;
import javax.swing.*;
import java.util.Comparator;

public class Puntuaketa {
	private String jokalaria;
	private String puntuaketa;
	
	public Puntuaketa(String pJok, String pPunt){
		this.jokalaria = pJok;
		this.puntuaketa = pPunt;
	}
	/*
	public void puntuaketaAldatu(String z){
		this.puntuaketa = z;
	}
*/
	
	static final Comparator<Puntuaketa> PUNTUAKETA = new Comparator<Puntuaketa>() {
		public int compare(Puntuaketa pPunt1, Puntuaketa pPunt2) {
			return new Integer(pPunt1.puntuaketa).compareTo(new Integer(pPunt2.puntuaketa));
		}
	 };
	 
	public JLabel showpuntuaketa(){
		JLabel l = new JLabel(this.jokalaria + " : " + this.puntuaketa + "  ");
		return l;
	}

	public void idatzi(BufferedWriter p) {
		try {
			p.write(this.jokalaria + "\t" + this.puntuaketa);
			
		} catch (IOException e) {e.printStackTrace();}
		
	}
}
