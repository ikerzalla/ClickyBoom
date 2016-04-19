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
	public void jokatu() {
		Menu2 m = new Menu2();
		m.setVisible(true);		
		System.out.println("Menua sortu dugu");		
	}

	public static void main(String[] args){
		getNireJokoa().jokatu();
	}

	public void amaitu(boolean irabazi) {
		Pantaila.getNPantaila().amaitu(irabazi);
	}

	public void eskuinClickEgin(int i, int j) {
		taula.eskuinClickEgin(i, j);
	}

	public void ezkerClickEgin(int i, int j) {
		taula.ezkerClickEgin(i, j);
	}
}
