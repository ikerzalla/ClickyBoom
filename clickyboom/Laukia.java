package clickyboom;

public abstract class Laukia implements Observable{
	private State egoera;
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
	
	public void egoeraAldatu(){
		if(this.egoera instanceof StateGarbia){
			this.egoera = new StateBandera();
			System.out.println("EGOERA ALDATUTA --> BANDERA");
		}
		else{
			this.egoera = new StateGarbia();
			System.out.println("EGOERA ALDATUTA --> GARBIA");
		}
	}
	
	public char irudiaEman() {
		return 'a';
	}
	
	@Override
	public void banderaJarri(int alt, int zab, boolean bandera) {
		if (bandera)
		pantaila.updateIrudia('m', alt, zab);
		else
		pantaila.updateIrudia('x', alt, zab);
	}
	
}
