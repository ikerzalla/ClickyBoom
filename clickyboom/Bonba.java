package clickyboom;

public class Bonba extends Laukia {

	public Bonba() {
		// TODO Auto-generated constructor stub
	}

	public void egituratu(int x, int y) {
		if(Pantaila.getNPantaila().entzutenDago(y, x)){
			super.egituratu(x,y);
			Pantaila.getNPantaila().setIrudi('b', x, y);
		}
	}
}
