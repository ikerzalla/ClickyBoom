package clickyboom;

import java.util.Timer;
import java.util.TimerTask;

import interfazea.*;

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
	}

	public static void main(String[] args){
		getNireJokoa().jokoaHasieratu();
	}
	
	public void jokoaHasieratu(){
		Menu m = new Menu();
		m.setVisible(true);	
	}
	
	public void amaitu(boolean irabazi) {
		timerTask.cancel();
		if (!irabazi){
			taula.bonbakErakutsi();
		}
		else{
			try {
				Ranking r = Ranking.getRanking();
				r.sortuPuntuaketa(this.jokalaria, this.kronometroa);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		if (taula.getLauki(i, j) == null) {
			if(kronometroa==0){
				timer.schedule(timerTask, 0, 1000);
			}
		}
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
