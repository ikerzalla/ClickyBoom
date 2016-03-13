package Laukiak;

public class StateBeteta implements State {

	public StateBeteta() {
		//Auto-generated constructor stub
	}

	@Override
	public void eskatu(int x, int y) {
		Laukia laukia = Jokoa.getNireJokoa().getTableroa().getLauki(x, y);
		if (laukia instanceof Hutsa)
			((Hutsa)laukia).egituratu(x,y);
		else if (laukia instanceof Hurbila)
			((Hurbila)laukia).egituratu(x,y);
		else
			((Bonba)laukia).egituratu(x,y);
			
	}

	

}
