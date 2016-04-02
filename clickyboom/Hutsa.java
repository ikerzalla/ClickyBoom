package clickyboom;

public class Hutsa extends Laukia {

	public Hutsa() {
		super();
	}

	public void egituratu(int altuera, int zabalera) {
		State estado = new StateBeteta();
		Tableroa taula = Jokoa.getNireJokoa().getTableroa();
		if (!taula.begiratutakoLaukia(altuera, zabalera)) {
			super.egituratu(altuera, zabalera);
			if (altuera > 0) {
				estado.ezkerClickEgin(altuera-1,zabalera);
				if (zabalera > 0) {
					estado.ezkerClickEgin(altuera-1,zabalera-1);
					estado.ezkerClickEgin(altuera,zabalera-1);
				}
				if (zabalera < taula.getZabalera()-1) {
					estado.ezkerClickEgin(altuera-1,zabalera+1);
					estado.ezkerClickEgin(altuera,zabalera+1);
				}
			}
			if (altuera < taula.getAltuera()-1) {
				estado.ezkerClickEgin(altuera+1,zabalera);
				if (zabalera > 0) {
					estado.ezkerClickEgin(altuera+1,zabalera-1);
					estado.ezkerClickEgin(altuera,zabalera-1);
				}
				if (zabalera < taula.getZabalera()-1) {
					estado.ezkerClickEgin(altuera+1,zabalera+1);
					estado.ezkerClickEgin(altuera,zabalera+1);
				}
			}
			else {
				if (zabalera > 0) 
					estado.ezkerClickEgin(altuera,zabalera-1);
				if (zabalera < taula.getZabalera()-1) 
					estado.ezkerClickEgin(altuera,zabalera+1);
			}
		}
	}
	
	@Override
	public void notifyObserver(int i, int j) {
		pantaila.updateIrudia('h', i, j);
	}
	
	
}
