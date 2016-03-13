package Laukiak;

public class Jokoa {

	private static Jokoa nJokoa;
	private Tableroa taula;
	private Jokoa() {
		
	}
	
	public static Jokoa getNireJokoa() {
		if (nJokoa == null)
			nJokoa = new Jokoa();	
		return nJokoa;
	}

	public Tableroa getTableroa() {
		return taula;
	}
	
	public void jokatu() {
		TableroaFactory faktoria = TableroaFactory.tableroaFactoryLortu();
		taula = faktoria.createTableroa("Erraza");
	}

}
