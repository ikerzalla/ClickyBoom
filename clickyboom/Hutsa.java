package clickyboom;

public class Hutsa extends Laukia {

	public Hutsa() {
		super();
	}

	public void egituratu(int x, int y) {
		if(Pantaila.getNPantaila().entzutenDago(y, x)){
			super.egituratu(y,x);
			Pantaila.getNPantaila().setIrudi('h', y, x);
			State estado = new StateBeteta();
			Tableroa taula = Jokoa.getNireJokoa().getTableroa();
			if (x > 0) {
				estado.eskatu(x,y);
				if (y > 0) {
					estado.eskatu(x-1,y-1);
					estado.eskatu(x,y-1);
				}
				if (y < taula.getAltuera()-1) {
					estado.eskatu(x-1,y+1);
					estado.eskatu(x,y+1);
				}
			}
			else if (x < taula.getZabalera()-1) {
				estado.eskatu(x+1,y);
				if (y > 0) {
					estado.eskatu(x+1,y-1);
					estado.eskatu(x,y-1);
				}
				if (y < taula.getAltuera()-1) {
					estado.eskatu(x+1,y+1);
					estado.eskatu(x,y+1);
				}
			}
			else {
				if (y > 0) 
					estado.eskatu(x,y-1);
				if (y < taula.getAltuera()) 
					estado.eskatu(x,y+1);
			}
		}
	}
	
	
}
