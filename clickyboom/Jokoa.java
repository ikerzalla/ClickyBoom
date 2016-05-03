package clickyboom;

import java.util.Timer;
import java.util.TimerTask;

import interfazea.*;
/*
1. Sprint:
	Tableroa sortzea: 4 ordu

2. Sprint:
	Bandera jartzea (eskuineko click-a jaso): 3 ordu
	
	*/
public class Jokoa {

	private String jokalaria = null;
	private String zailtasuna;
	private static Jokoa nJokoa;
	private Tableroa taula;
	private Integer kronometroa;
	private TimerTask timerTask;
	private Timer timer;
	
	private Jokoa() {
		kronometroa = 0;
		timer = new Timer();
		timerTask = new TimerTask(){
			public void run() {
				kronometroa++;
				Pantaila.getNPantaila().eguneratuKronometroa(kronometroa);
			}
        	
        };
	}
	
	private Jokoa(String pJokalaria, String pZailtasun) {
	kronometroa = 0;
	timerTask = new TimerTask(){
	public void run() {
		kronometroa++;
		Pantaila.getNPantaila().eguneratuKronometroa(kronometroa);
		}            
	};
	jokalaria = pJokalaria;
	taula = TableroaFactory.tableroaFactoryLortu().createTableroa(pZailtasun);
	}

	public static Jokoa getNireJokoa() {
		if (nJokoa == null)
			nJokoa = new Jokoa();	
		return nJokoa;
	}

	public Tableroa getTableroa() {
		return taula;
	}
	
	public void setZailtasun(String zailtasun){
		nJokoa.zailtasuna = zailtasun;
		TableroaFactory faktoria = TableroaFactory.tableroaFactoryLortu();
		taula = faktoria.createTableroa(zailtasun);
		
		//menura mugitu da 
		/*Pantaila p = Pantaila.getNPantaila();
		System.out.println("Pantaila sortu dugu");
		p.setVisible(true);
		System.out.println("Tableroa sortu dugu");*/
	}
	
	//interfaz grafikoa eta sistema ezberdindu behar dira
	

	public static void main(String[] args){
		getNireJokoa().jokoaHasieratu();
		//getNireJokoa().zailtasunaAukeratu();
	}
	
	private void jokatu() {
		Pantaila p = Pantaila.getNPantaila();
		System.out.println("Pantaila sortu dugu");
		p.setVisible(true);
		System.out.println("Tableroa sortu dugu");
	}

	
	public void jokoaHasieratu(){
		//Llama a menu, que ahora tiene el Login y el selector de dificultad junto
		/*Login l = new Login();
		l.setVisible(true);*/
		Menu m = new Menu();
		m.setVisible(true);	
	}
	
	/*public void zailtasunaAukeratu() {
		Menu m = new Menu();
		m.setVisible(true);	
	}*/

	public void amaitu(boolean irabazi) {
		//timer.cancel();
		timerTask.cancel();
		if (!irabazi){
			taula.bonbakErakutsi();
		}
		Pantaila.getNPantaila().amaitu(irabazi);
	}
	
	public void jokoaRestart() {
		timerTask.cancel();
		timer.cancel();
		kronometroa = 0;
		timer = new Timer();
		timerTask = new TimerTask(){
		public void run() {
			Pantaila.getNPantaila().eguneratuKronometroa(kronometroa);
			kronometroa++;
			}            
		};
		taula = TableroaFactory.tableroaFactoryLortu().createTableroa(zailtasuna);
	}

	public void eskuinClickEgin(int i, int j) {
		taula.eskuinClickEgin(i, j);
	}

	public void ezkerClickEgin(int i, int j) {
		if(kronometroa==0){
	        timer.schedule(timerTask, 0, 1000);
		}
		taula.ezkerClickEgin(i, j);
	}
	
	public void aldatuJokalaria(String p){
		nJokoa.jokalaria=p;
	}
	
	public void inprimatuJokalaria(){
		System.out.println(jokalaria);
	}
	
	public String getJokalaria(){
		return nJokoa.jokalaria;
	}
	public int getKrono(){
		return nJokoa.kronometroa;
	}
	public String getZailtasuna(){
		return nJokoa.zailtasuna;
	}
}
