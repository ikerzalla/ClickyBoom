package clickyboom;

public class StateHutsa implements State{
	
	public StateHutsa(){}

	
	@Override
	public void eskatu(int alt, int zab){//Click egin dugun posizioa
		Tableroa tab = Jokoa.getNireJokoa().getTableroa();
		tab.tableroaBete(alt, zab);
		tab.egoeraAldatu(new StateBeteta());
		tab.clickEgin(alt, zab);
		
	}

}
