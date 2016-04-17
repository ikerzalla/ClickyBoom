package clickyboom;

public class Bonba extends Laukia {

	public Bonba() {
		super();
	}

	public void egituratu(int altuera, int zabalera) {
		Jokoa.getNireJokoa().getTableroa().bonbakErakutsi();
		Jokoa.getNireJokoa().amaitu(false);
		super.egituratu(altuera, zabalera);
	}

	@Override
	public void notifyObserver(int i, int j) {
		pantaila.updateIrudia('b', i, j);
	}
}
