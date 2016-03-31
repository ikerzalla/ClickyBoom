package clickyboom;

public class StateGarbia implements State{
	
	public StateGarbia(){}
	
	@Override
	public void eskatu(int alt, int zab){
		Pantaila.getNPantaila().irudiHutsaJarri(alt, zab);
	}

}
