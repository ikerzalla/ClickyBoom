package state;

import clickyboom.Jokoa;
import clickyboom.Tableroa;

public class StateHutsa implements State{
	
	public StateHutsa(){}

	
	@Override
	public void ezkerClickEgin(int alt, int zab){
		Tableroa tab = Jokoa.getNireJokoa().getTableroa();
		tab.tableroaBete(alt, zab);
		tab.egoeraAldatu(new StateBeteta());
		tab.ezkerClickEgin(alt, zab);
	}
	
	@Override
	public void eskuinClickEgin(int alt, int zab){
		Jokoa.getNireJokoa().getTableroa().getLauki(alt, zab).eskuinClickEgin(alt, zab);
	}
}
