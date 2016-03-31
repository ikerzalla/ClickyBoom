package clickyboom;

public class StateBeteta implements State {

	public StateBeteta() {}

	@Override
	public void ezkerClickEgin(int alt, int zab) {
		Laukia laukia = Jokoa.getNireJokoa().getTableroa().getLauki(alt, zab);
		if (laukia instanceof Hutsa)
			((Hutsa)laukia).ezkerClickEgin(alt, zab);
		else if (laukia instanceof Hurbila)
			((Hurbila)laukia).ezkerClickEgin(alt,zab);
		else {
			((Bonba)laukia).ezkerClickEgin(alt,zab);
		}
	}
	
	public void eskuinClickEgin(int alt, int zab){
		Laukia laukia = Jokoa.getNireJokoa().getTableroa().getLauki(alt, zab);
		laukia.eskuinClickEgin(alt, zab);
	}

	

}
