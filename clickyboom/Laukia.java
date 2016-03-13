package clickyboom;

public abstract class Laukia {
	
	public Laukia() {}
	
	public void egituratu(int x, int y){
		Pantaila.getNPantaila().botonOff(x, y);
	}
}
