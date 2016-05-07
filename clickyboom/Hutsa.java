package clickyboom;

import state.StateBandera;

public class Hutsa extends Laukia {

	public Hutsa() {
		super();
	}

	public void egituratu(int altuera, int zabalera) {
		Tableroa taula = Jokoa.getNireJokoa().getTableroa();
		if (!taula.begiratutakoLaukia(altuera, zabalera)) {
			super.egituratu(altuera, zabalera);
			taula.laukiaMarkatu(altuera, zabalera);
			if (altuera > 0) {
				taula.ezkerClickEgin(altuera-1,zabalera);
				if (zabalera > 0) {
					taula.ezkerClickEgin(altuera-1,zabalera-1);
					taula.ezkerClickEgin(altuera,zabalera-1);
				}
				if (zabalera < taula.getZabalera()-1) {
					taula.ezkerClickEgin(altuera-1,zabalera+1);
					taula.ezkerClickEgin(altuera,zabalera+1);
				}
			}
			if (altuera < taula.getAltuera()-1) {
				taula.ezkerClickEgin(altuera+1,zabalera);
				if (zabalera > 0) {
					taula.ezkerClickEgin(altuera+1,zabalera-1);
					taula.ezkerClickEgin(altuera,zabalera-1);
				}
				if (zabalera < taula.getZabalera()-1) {
					taula.ezkerClickEgin(altuera+1,zabalera+1);
					taula.ezkerClickEgin(altuera,zabalera+1);
				}
			}
			else {
				if (zabalera > 0) 
					taula.ezkerClickEgin(altuera,zabalera-1);
				if (zabalera < taula.getZabalera()-1) 
					taula.ezkerClickEgin(altuera,zabalera+1);
			}
		}
	}
	
	@Override
	public void notifyObserver(int i, int j) {
		pantaila.updateIrudia('h', i, j);
	}
	
	
}
