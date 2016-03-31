package clickyboom;

public abstract class Laukia {
	private State egoera;
	
	public Laukia() {
		this.egoera = new StateGarbia();
	}
	
	public void egituratu(int altuera, int zabalera){
		Pantaila p = Pantaila.getNPantaila();
		p.botonOff(altuera, zabalera);		
	}
	
	public void ezkerClickEgin(int alt, int zab){
		if(this.egoera instanceof StateGarbia){
			this.egituratu(alt, zab);
		}
	}
	
	public void eskuinClickEgin(int alt, int zab){
		if(this.egoera instanceof StateGarbia){
			this.egoera = new StateBandera();
			this.egoera.eskatu(alt, zab);
		}
		else{
			this.egoera = new StateGarbia();
			this.egoera.eskatu(alt, zab);
		}
	}
}
