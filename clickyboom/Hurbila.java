package clickyboom;

public class Hurbila extends Laukia {

	Integer bonbaKop;
	public Hurbila() {
		bonbaKop = 1;
	}

	public void bonbaGehitu(){
		bonbaKop++;
	}
	
	public int getBonbaKop() {
		return (int)bonbaKop;
	}
	
	public void egituratu(int altuera, int zabalera) {
		if(Pantaila.getNPantaila().entzutenDago(altuera, zabalera)){
			Pantaila.getNPantaila().setIrudi(bonbaKop.toString().charAt(0), altuera, zabalera);
			super.egituratu(altuera,zabalera);
		}
	}
}
