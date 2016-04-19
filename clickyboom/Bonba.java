package clickyboom;

public class Bonba extends Laukia {

	public Bonba() {
		super();
	}

	public void egituratu(int altuera, int zabalera) {
		super.egituratu(altuera, zabalera);
		Jokoa.getNireJokoa().amaitu(false);
	}

	@Override
	public void notifyObserver(int i, int j) {
		pantaila.updateIrudia('b', i, j);
	}
}
