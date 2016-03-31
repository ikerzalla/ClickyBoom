package clickyboom;
/*
1. Sprint:
	Tableroa sortzea: 4 ordu

2. Sprint:
	Bandera jartzea: 3 ordu
	
	*/
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
		Pantaila p = Pantaila.getNPantaila();
		System.out.println("Pantaila sortu dugu");
		p.setVisible(true);
		
	}

	public static void main(String[] args){
		getNireJokoa().jokatu();
	}
}
