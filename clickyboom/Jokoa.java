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
		System.out.println("Tableroa sortu dugu");
		Pantaila p = new Pantaila();
		System.out.println("Pantaila sortu dugu");
		p.setVisible(true);
		
	}

	public static void main(String[] args){
		getNireJokoa().jokatu();
	}
}
