package clickyboom;

public class StateBandera implements State{
	//Klase honek lauki batean bandera bat jarrita dagoela adierazten du
	
	public StateBandera(){}
	
	@Override
	public void ezkerClickEgin(int alt, int zab){}
	
	@Override
	public void eskuinClickEgin(int alt, int zab){
		Laukia l = Jokoa.getNireJokoa().getTableroa().getLauki(alt, zab);
		l.banderaJarri(alt, zab, false);
		l.egoeraAldatu();
	}

}