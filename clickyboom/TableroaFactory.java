
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
			nireTableroa = new TableroaErraza(7,10,10);
		}
		else if (s.equals("Normal")|| s.equals("normal")){
			nireTableroa = new TableroNormala(10,15,30);
		}
		else {
			nireTableroa = new TableroZaila(25,12,75);
		}
		return nireTableroa;
	}

}