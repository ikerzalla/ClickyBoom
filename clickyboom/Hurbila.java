package clickyboom;

import state.StateBandera;

public class Hurbila extends Laukia {

	Integer bonbaKop;
	
	public Hurbila() {
		super();
		bonbaKop = 1;
	}

	public void bonbaGehitu(){
		bonbaKop++;
	}
	
	public int getBonbaKop() {
		return (int)bonbaKop;
	}
	
	public void egituratu(int altuera, int zabalera) {
		if (!banderaDu()) {
			super.egituratu(altuera, zabalera);
			Jokoa.getNireJokoa().getTableroa().laukiaMarkatu(altuera, zabalera);
		}
	}
	
	@Override
	public void notifyObserver(int i, int j) {
		pantaila.updateIrudia(bonbaKop.toString().charAt(0), i, j);
	}
}
