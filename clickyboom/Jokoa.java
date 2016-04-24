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
	private int kronometroa;
	private TimerTask timerTask;
	
	
	private Jokoa() {
		kronometroa = 0;
		timerTask = new TimerTask(){
			public void run() {
				kronometroa++;
				Pantaila.getNPantaila().eguneratuKronometroa(kronometroa);
			}
        	
        };
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
		getNireJokoa().jokalariaSartu();
	}
	
	public void jokalariaSartu(){
		//Login l = new Login();
		//l.setVisible(true);
		Menu m = new Menu();
		m.setVisible(true);
	}
	
	public void zailtasunaAukeratu() {
		Menu m = new Menu();
		m.setVisible(true);	
	}

	public void amaitu(boolean irabazi) {
		timerTask.cancel();
		if (!irabazi){
			taula.bonbakErakutsi();
		}
		Pantaila.getNPantaila().amaitu(irabazi);
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
        Timer timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
	}
}
