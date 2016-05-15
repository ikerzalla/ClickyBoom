package state;

import clickyboom.Jokoa;
import clickyboom.Laukia;
import clickyboom.Tableroa;

public class StateGarbia implements State{
	
	public StateGarbia(){}
	
	@Override
	public void ezkerClickEgin(int alt, int zab){
		Laukia l = Jokoa.getNireJokoa().getTableroa().getLauki(alt, zab);
		l.egituratu(alt, zab);
	}
	
	@Override
	public void eskuinClickEgin(int alt, int zab){
		Tableroa t = Jokoa.getNireJokoa().getTableroa();
		if (t.banderaJarriDatiteke()) {
			Laukia l = t.getLauki(alt, zab);
			l.banderaJarri(alt, zab, true);
			t.banderaGehitu();
			l.egoeraAldatu(new StateBandera());
		}
	}
}
