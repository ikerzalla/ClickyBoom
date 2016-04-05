package clickyboom;

public class StateGarbia implements State{
	//Klase honek lauki batean bandera bat jarrita ez dagoela adierazten du
	
	public StateGarbia(){}
	
	@Override
	public void ezkerClickEgin(int alt, int zab){
		Laukia l = Jokoa.getNireJokoa().getTableroa().getLauki(alt, zab);
		l.egituratu(alt, zab);
	}
	
	@Override
	public void eskuinClickEgin(int alt, int zab){
		Laukia l = Jokoa.getNireJokoa().getTableroa().getLauki(alt, zab);
		l.banderaJarri(alt, zab, true);
		l.egoeraAldatu();
	}

}
