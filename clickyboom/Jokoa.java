package clickyboom;

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
		new Pantaila(taula.altuera, taula.zabalera);
	}

	public static void main(String[] args){
		getNireJokoa().jokatu();
	}
}
