package clickyboom;

public class TableroErraza extends Tableroa {
	
	public TableroErraza(){
		this.altuera = 7;
    	this.zabalera = 10;
    	this.laukiak = new Laukia[altuera][zabalera];
    	this.bonbaKop = zabalera*1;
    	this.egoera = new StateHutsa();
    	this.begiratuak = new boolean[altuera][zabalera];
    	laukiKop = altuera*zabalera;
	}
}