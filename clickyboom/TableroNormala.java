package clickyboom;

public class TableroNormala extends Tableroa {

	protected TableroNormala() {
		this.altuera = 10;
    	this.zabalera = 15;
    	this.laukiak = new Laukia[altuera][zabalera];
    	this.bonbaKop = zabalera*2;
    	this.egoera = new StateHutsa();
    	this.begiratuak = new boolean[altuera][zabalera];
    	laukiKop = altuera*zabalera;
	}

}
