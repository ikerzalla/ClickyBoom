package state;

import clickyboom.Jokoa;
import clickyboom.Laukia;
import clickyboom.Tableroa;

public class StateBandera implements State{

	public StateBandera(){}
	
	@Override
	public void ezkerClickEgin(int alt, int zab){}
	
	@Override
	public void eskuinClickEgin(int alt, int zab){
		Tableroa t = Jokoa.getNireJokoa().getTableroa();
		Laukia l = t.getLauki(alt, zab);
		l.banderaJarri(alt, zab, false);
		t.banderaKendu();
		l.egoeraAldatu(new StateGarbia());
	}
}