package clickyboom;
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
	private ArrayList<Puntuaketa> lista  = new ArrayList<Puntuaketa>();
	
	
	
	
	/**
	 * Launch the application.
	 */
	public void rankingDeia() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Collections.sort(lista,Puntuaketa.PUNTUAKETA);
					jokalariakJarri();
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
		setTitle("ClickyBoom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		
	   
	        
	    
		}
	
	public static Ranking getRanking()throws Exception{
		if (nRanking == null){
			nRanking = new Ranking();
			nRanking.rankingaKargatu("C://Users/Eka/workspace/ClickyBoom/src/Ranking/Ranking.txt");;
		}
		return nRanking;
	}
	
	public void gehituPuntuaketa(Puntuaketa p)throws Exception{
		Ranking.nRanking.lista.add(p);
		Ranking.nRanking.ordenatuRankina();
	}
	
	private void ordenatuRankina(){
		
	}
	
	private void rankingaKargatu(String fitx) throws Exception{
		//this.lista.clear();
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
		ArrayList<Puntuaketa> l = nRanking.lista;
		Puntuaketa p = null;
			
			for(int i=0;i<l.size();i++){
				p = l.get(i);
				p.idatzi();
			}
	}
	
	public void jokalariakJarri(){
		JPanel b = new JPanel();
		b.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(b);
		for (int i=0;i<10;i++){
			JPanel a = new JPanel();
			JLabel k = new JLabel("#" + (i+1));
			
			if (nRanking.lista.size()>i){
				JLabel l = nRanking.lista.get(i).showpuntuaketa();
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


