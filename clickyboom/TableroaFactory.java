
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
	
	//Hasieran tablero mota bakarra izango dugu. Hala ere, geroago zailtasun-maila gehiago gehitzeko,
	//"Factory" patroia erabiliko dugu, bakoitzaren sorrera errazteko
	public Tableroa createTableroa(String s){	
		Tableroa nireTableroa = null;
		
		if(s.equalsIgnoreCase("erraza")){
			nireTableroa = new TableroErraza();
		}
		else if (s.equals("Normal")|| s.equals("normal")){
			nireTableroa = new TableroNormala();
		}
		else {
			nireTableroa = new TableroZaila();
		}
		return nireTableroa;
	}

}