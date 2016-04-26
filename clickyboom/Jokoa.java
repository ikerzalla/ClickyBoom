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
	private static Jokoa nJokoa;
	private Tableroa taula;
	private Integer kronometroa;
	private TimerTask timerTask;
	private Timer timer;
	
	private Jokoa() {
		kronometroa = 0;
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
		//llama al login que llama al menu que llama al juego y a jugar
		Login l = new Login();
		l.setVisible(true);
	}
	
	public void zailtasunaAukeratu() {
		Menu m = new Menu();
		m.setVisible(true);	
	}

	public void amaitu(boolean irabazi) {
		timer.cancel();
		if (!irabazi){
			taula.bonbakErakutsi();
		}
		Pantaila.getNPantaila().amaitu(irabazi);
	}
	
	public void jokoaRestart() {
		String zail;
		if (taula instanceof TableroErraza) zail = "Erraza";
		else if (taula instanceof TableroNormala) zail = "Normala";
		else zail = "Zaila";
		nJokoa = new Jokoa(jokalaria, zail);
	}

	public void eskuinClickEgin(int i, int j) {
		taula.eskuinClickEgin(i, j);
	}

	public void ezkerClickEgin(int i, int j) {
		taula.ezkerClickEgin(i, j);
		if(kronometroa==0){
			kronometroaHasi();
		}
	}
	
	public void aldatuJokalaria(String p){
		nJokoa.jokalaria=p;
	}
	
	public void inprimatuJokalaria(){
		System.out.println(jokalaria);
	}
	
	private void kronometroaHasi(){
        timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
	}
}
