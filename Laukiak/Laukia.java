package Laukiak;

public abstract class Laukia {
	
	public Laukia() {}
	
	public void egituratu(int x, int y){
		Jokoa.getNireJokoa().getTableroa().botonOff(x, y);
	}
}
