package clickyboom;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public  class Ranking extends JFrame{
	private static Ranking nRanking = null;
	private ArrayList<Puntuaketa> erraza  = new ArrayList<Puntuaketa>();
	private ArrayList<Puntuaketa> normala  = new ArrayList<Puntuaketa>();
	private ArrayList<Puntuaketa> zaila  = new ArrayList<Puntuaketa>();
	
	
	
	
	/**
	 * Launch the application.
	 */
	public void rankingDeia(String z) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(z=="erraza"||z=="Erraza"){
					Collections.sort(erraza,Puntuaketa.PUNTUAKETA);
					jokalariakJarri(z);
					setTitle("Ranking_Erreza");
					}
					else if (z == "normala"||z=="Normala"){
					Collections.sort(normala,Puntuaketa.PUNTUAKETA);
					jokalariakJarri(z);
					setTitle("Ranking_Normala");
					}
					else{
					Collections.sort(zaila,Puntuaketa.PUNTUAKETA);
					jokalariakJarri(z);
					setTitle("Ranking_Zaila");
					}
					botoiakGehitu();
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private Ranking()throws Exception{
		//nRanking.rankingaKargatu("C://Users/Eka/workspace/ClickyBoom/src/Ranking/Ranking.txt");
		setResizable(false);
		setTitle("Ranking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		
	   
	        
	    
		}
	
	public static Ranking getRanking()throws Exception{
		if (nRanking == null){
			nRanking = new Ranking();
			nRanking.rankingaKargatu();
		}
		return nRanking;
	}
	
	public void gehituPuntuaketa(Puntuaketa p)throws Exception{
		
		if(Jokoa.getNireJokoa().getZailtasuna()=="Erraza" || Jokoa.getNireJokoa().getZailtasuna()=="erraza"){
			Ranking.nRanking.erraza.add(p);
		}
		else if (Jokoa.getNireJokoa().getZailtasuna()=="Normala" || Jokoa.getNireJokoa().getZailtasuna()=="normala"){
			Ranking.nRanking.normala.add(p);
		}
		else{
			Ranking.nRanking.zaila.add(p);
		}
	}
	

	
	private void rankingaKargatu() throws Exception{
		Puntuaketa p = null;
		String fitx  = "C://Users/Mielotxim/workspace/ClickyBoom/src/Ranking/Ranking_Erreza.txt";
		String fitx1 = "C://Users/Mielotxim/workspace/ClickyBoom/src/Ranking/Ranking_Normala.txt";
		String fitx2 = "C://Users/Mielotxim/workspace/ClickyBoom/src/Ranking/Ranking_Zaila.txt";
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
				nRanking.erraza.add(p);
				
			}
			sarrera.close();
			
			Scanner sarrera1 = new Scanner(new FileReader(fitx1));
			while(sarrera1.hasNext()){
				i=0;
				lerroa = sarrera1.nextLine();
				String[] hitzak1 = lerroa.split("\t");
				p = new Puntuaketa(hitzak1[i]);
				i++;
				p.puntuaketaAldatu(hitzak1[i]);//COMO METO LA PUNTUACION ?
				nRanking.normala.add(p);
				
			}
			sarrera1.close();
			
			Scanner sarrera2 = new Scanner(new FileReader(fitx2));
			while(sarrera2.hasNext()){
				i=0;
				lerroa = sarrera2.nextLine();
				String[] hitzak2 = lerroa.split("\t");
				p = new Puntuaketa(hitzak2[i]);
				i++;
				p.puntuaketaAldatu(hitzak2[i]);//COMO METO LA PUNTUACION ?
				nRanking.zaila.add(p);
				
			}
			sarrera2.close();
			
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
		ArrayList<Puntuaketa> l;
		Puntuaketa p = null;
		FileWriter fw;
		try {
			if (Jokoa.getNireJokoa().getZailtasuna()==("Erraza")||Jokoa.getNireJokoa().getZailtasuna()==("erraza")){
				fw = new FileWriter("C://Users/Mielotxim/workspace/ClickyBoom/src/Ranking/Ranking_Erreza.txt");
				l = nRanking.erraza;
			}
			else if (Jokoa.getNireJokoa().getZailtasuna()==("Normala")||Jokoa.getNireJokoa().getZailtasuna()=="normala"){
				fw = new FileWriter("C://Users/Mielotxim/workspace/ClickyBoom/src/Ranking/Ranking_Normala.txt");
				l = nRanking.normala;
			}
			else{
				fw = new FileWriter("C://Users/Mielotxim/workspace/ClickyBoom/src/Ranking/Ranking_Zaila.txt");
				l = nRanking.zaila;
			}
			
			BufferedWriter output = new BufferedWriter(fw);
			
			for(int i=0;i<l.size();i++){
				
				p = l.get(i);
				p.idatzi(output);
				output.newLine();
			}
			output.close();
			
		} catch (IOException e) {e.printStackTrace();}
		

	}
	
	public void jokalariakJarri(String z){
		
		ArrayList<Puntuaketa> lista;
		if(z=="erraza"||z=="Erraza"){
			lista = nRanking.erraza;
		}
		else if (z=="normala"||z=="Normala"){
			lista = nRanking.normala;
		}
		else{
			lista = nRanking.zaila;
		}
		JPanel b = new JPanel();
		b.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(b);
		for (int i=0;i<10;i++){
			JPanel a = new JPanel();
			JLabel k = new JLabel("#" + (i+1));
			
			if (lista.size()>i){
				JLabel l = lista.get(i).showpuntuaketa();
				a.add(k, BorderLayout.CENTER);
				a.add(l, BorderLayout.CENTER);
			}
			
			b.add(a, BorderLayout.CENTER);
			
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