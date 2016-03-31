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
	
	public void setZailtasun(int z){
		TableroaFactory faktoria = TableroaFactory.tableroaFactoryLortu();
		if (z == 1){
			taula = faktoria.createTableroa("Erraza");
		}else if(z == 2){
			taula = faktoria.createTableroa("Normala");
		}else if(z == 3){
			taula = faktoria.createTableroa("Zaila");
		}
		Pantaila p = Pantaila.getNPantaila();
		System.out.println("Pantaila sortu dugu");
		p.setVisible(true);
		System.out.println("Tableroa sortu dugu");		
	}
	
	public void jokatu() {
		Menu m = new Menu();
		m.setVisible(true);		
		System.out.println("Menua sortu dugu");		
	}

	public static void main(String[] args){
		getNireJokoa().jokatu();
	}
}
