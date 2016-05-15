
package clickyboom;


public class TableroaFactory {
	
	private static TableroaFactory fact;
	
	private TableroaFactory(){}
	
	public static TableroaFactory tableroaFactoryLortu(){
		if(fact==null){
			fact = new TableroaFactory();
		}
		return fact;
	}

	public Tableroa createTableroa(String s){	
		Tableroa nireTableroa = null;
		
		if(s.equalsIgnoreCase("erraza")){
			nireTableroa = new TableroErraza();
		}
		else if (s.equalsIgnoreCase("normala")){
			nireTableroa = new TableroNormala();
		}
		else {
			nireTableroa = new TableroZaila();
		}
		return nireTableroa;
	}
}