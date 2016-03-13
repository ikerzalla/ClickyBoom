package clickyboom;

public class StateHutsa implements State{
	
	public StateHutsa(){}

	
	@Override
	public void eskatu(int x, int y){//Click egin dugun posizioa
		Tableroa tab = Jokoa.getNireJokoa().getTableroa();
		tab.tableroaBete(x, y);
		tab.egoeraAldatu(new StateBeteta());
		tab.clickEgin(x, y);
		
	}

}
