package clickyboom;

public class Hurbila extends Laukia {

	int bonbaKop;
	public Hurbila() {
		bonbaKop = 1;
	}

	public void bonbaGehitu(){
		bonbaKop++;
	}
	
	public int getBonbaKop() {
		return bonbaKop;
	}
	
	public void egituratu(int x, int y) {
		super.egituratu(x,y);
		Pantaila.getNPantaila().setIrudi((char)bonbaKop, x, y);
	}
}
