package clickyboom;

public class Bonba extends Laukia {

	public Bonba() {
		// TODO Auto-generated constructor stub
	}

	public void egituratu(int x, int y) {
		super.egituratu(x,y);
		Pantaila.getNPantaila().setIrudi('b', x, y);
	}
}
