package clickyboom;

public class StateBandera implements State{
	
	public StateBandera(){}
	
	@Override
	public void eskatu(int alt, int zab){
		Pantaila.getNPantaila().banderaJarri(alt, zab);
	}

}