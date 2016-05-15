package clickyboom;

import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListaPuntuaketa {
	private ArrayList<Puntuaketa> lista;
	public ListaPuntuaketa() {
		lista = new ArrayList<Puntuaketa>();
	}
	
	public void gehituPuntuaketa(Puntuaketa p){
		this.lista.add(p);
	}
	
	public void listaKargatu(String fitx){
		try{
			Puntuaketa p = null;
			int i = 0;
			String lerroa;
			Scanner sarrera = new Scanner(new FileReader(fitx));
			while(sarrera.hasNext()){
				i=0;
				lerroa = sarrera.nextLine();
				String[] hitzak = lerroa.split("\t");
				p = new Puntuaketa(hitzak[i]);
				i++;
				p.puntuaketaAldatu(hitzak[i]);
				this.lista.add(p);
			}
			sarrera.close();
		}catch(Exception e){System.out.println(e);}
	}

	public void listaGorde(String fitx){
		try{
			FileWriter fw = new FileWriter(fitx);
			Puntuaketa p = null;
			BufferedWriter output = new BufferedWriter(fw);
			for (int i=0;i<this.lista.size();i++){
				p = this.lista.get(i);
				p.idatzi(output);
				output.newLine();
			}
			output.close();
		}catch(Exception e){System.out.println(e);}
	}
	
	public void ordenatu(){
		Collections.sort(lista,Puntuaketa.PUNTUAKETA);
	}
	
	public JPanel jokalariakJarri(JPanel b){
		for(int i=0;i<10;i++){
			JPanel a = new JPanel();
			JLabel k = new JLabel("#"+ (i+1));
			if(lista.size()>i){
				JLabel l = lista.get(i).showpuntuaketa();
				a.add(k, BorderLayout.CENTER);
				a.add(l, BorderLayout.CENTER);
			}
			b.add(a, BorderLayout.CENTER);
		}
		return b;
	}
}
