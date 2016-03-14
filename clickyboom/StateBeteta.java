package clickyboom;

public class StateBeteta implements State {

	public StateBeteta() {
		//Auto-generated constructor stub
	}

	@Override
	public void eskatu(int alt, int zab) {
		Laukia laukia = Jokoa.getNireJokoa().getTableroa().getLauki(alt, zab);
		if (laukia instanceof Hutsa)
			((Hutsa)laukia).egituratu(alt, zab);
		else if (laukia instanceof Hurbila)
			((Hurbila)laukia).egituratu(alt,zab);
		else
			((Bonba)laukia).egituratu(alt,zab);
			
	}

	

}
