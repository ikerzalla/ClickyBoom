package clickyboom;

public class Bonba extends Laukia {

	public Bonba() {
		// TODO Auto-generated constructor stub
	}

	public void egituratu(int altuera, int zabalera) {
		if(Pantaila.getNPantaila().entzutenDago(altuera, zabalera)){
			Pantaila.getNPantaila().setIrudi('b', altuera, zabalera);
			super.egituratu(altuera,zabalera);			
		}
	}
}
