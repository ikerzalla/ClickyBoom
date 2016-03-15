package clickyboom;

public class Hutsa extends Laukia {

	public Hutsa() {
		super();
	}

	public void egituratu(int altuera, int zabalera) {
		if(Pantaila.getNPantaila().entzutenDago(altuera, zabalera)){
			super.egituratu(altuera,zabalera);
			Pantaila.getNPantaila().setIrudi('h', altuera, zabalera);
			State estado = new StateBeteta();
			Tableroa taula = Jokoa.getNireJokoa().getTableroa();
			if (altuera > 0) {
				estado.eskatu(altuera-1,zabalera);
				if (zabalera > 0) {
					estado.eskatu(altuera-1,zabalera-1);
					estado.eskatu(altuera,zabalera-1);
				}
				if (zabalera < taula.getZabalera()-1) {
					estado.eskatu(altuera-1,zabalera+1);
					estado.eskatu(altuera,zabalera+1);
				}
			}
			if (altuera < taula.getAltuera()-1) {
				estado.eskatu(altuera+1,zabalera);
				if (zabalera > 0) {
					estado.eskatu(altuera+1,zabalera-1);
					estado.eskatu(altuera,zabalera-1);
				}
				if (zabalera < taula.getZabalera()-1) {
					estado.eskatu(altuera+1,zabalera+1);
					estado.eskatu(altuera,zabalera+1);
				}
			}
			else {
				if (zabalera > 0) 
					estado.eskatu(altuera,zabalera-1);
				if (zabalera < taula.getZabalera()-1) 
					estado.eskatu(altuera,zabalera+1);
			}
		}
	}
	
	
}
