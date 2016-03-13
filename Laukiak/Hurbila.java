package Laukiak;

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
}
