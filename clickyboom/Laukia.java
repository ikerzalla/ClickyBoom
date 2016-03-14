package clickyboom;

public abstract class Laukia {
	
	public Laukia() {}
	
	public void egituratu(int altuera, int zabalera){
		Pantaila.getNPantaila().botonOff(altuera, zabalera);
	}
}
