package state;

import clickyboom.Jokoa;

public class StateBeteta implements State {

	public StateBeteta() {}

	@Override
	public void ezkerClickEgin(int alt, int zab) {
		Jokoa.getNireJokoa().getTableroa().getLauki(alt, zab).ezkerClickEgin(alt, zab);
	}
	
	public void eskuinClickEgin(int alt, int zab){
		Jokoa.getNireJokoa().getTableroa().getLauki(alt, zab).eskuinClickEgin(alt, zab);
	}
}
