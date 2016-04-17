package clickyboom;

public class TableroZaila extends Tableroa {

	protected TableroZaila() {
		this.altuera = 25;
    	this.zabalera = 12;
    	this.laukiak = new Laukia[altuera][zabalera];
    	this.bonbaKop = this.altuera*3;
    	this.egoera = new StateHutsa();
    	this.begiratuak = new boolean[altuera][zabalera];
    	laukiKop = altuera*zabalera;
	}

}
