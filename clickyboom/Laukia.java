package clickyboom;

public abstract class Laukia {
	
	public Laukia() {}
	
	public void egituratu(int altuera, int zabalera){
		Pantaila p = Pantaila.getNPantaila();
		p.botonOff(altuera, zabalera);		
	}
}
