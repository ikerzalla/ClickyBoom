package clickyboom;

import interfazea.Pantaila;
import state.State;
import state.StateBandera;
import state.StateGarbia;

public abstract class Laukia implements Observable{
	protected State egoera;
	protected Observer pantaila;
	
	public Laukia() {
		this.egoera = new StateGarbia();
		this.pantaila = Pantaila.getNPantaila();
	}
	
	public void ezkerClickEgin(int alt, int zab){
		egoera.ezkerClickEgin(alt, zab);
	}
	
	public void eskuinClickEgin(int alt, int zab){
		egoera.eskuinClickEgin(alt, zab);
	}
	
	public void egituratu(int altuera, int zabalera){
		this.notifyObserver(altuera, zabalera);
	}
	
	public void egoeraAldatu(State pEgoeraBerria){
		this.egoera = pEgoeraBerria;
	}
	
	@Override
	public void banderaJarri(int alt, int zab, boolean bandera) {
		if (bandera) pantaila.updateIrudia('m', alt, zab);
		else pantaila.updateIrudia('x', alt, zab);
	}
	
	public boolean banderaDu() {
		if (egoera instanceof StateBandera) return true;
		else return false;
	}
	
}
