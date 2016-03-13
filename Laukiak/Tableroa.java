package Laukiak;
import javax.swing.JButton;

//Enkapsulazio handiagoa nahiko bagenu Singleton patroia Tableroa klasean erabiltzeko eta
//tablero bakarra egoteko, Tableroa interfaze bat izan beharko litzateke, klase abstraktu
//batean ezin daitekeelako Singleton patroia inplementatu.
//Hala ere, gure proiektuarentzako Tableroa abstraktua edo interfazea izateak ez du
//ezberdintasun askorik.
 
public abstract class Tableroa {
    protected Laukia[][] laukiak;
    protected JButton[][] botoiak;
    protected State egoera;
    protected int bonbaKop;
    protected int zabalera;
    protected int altuera;
    
    protected Tableroa(int zab, int alt, int bon){
    	this.zabalera = zab;
    	this.altuera = alt;
    	this.laukiak = new Laukia[zab][alt];
		this.botoiak = new JButton[zab][alt];
    	this.bonbaKop = bon;
    	this.egoera = new StateHutsa();
    }
    //Lauki batean click egitean, laukiak metodo honi deituko
    //dio bere posizioa pasatuz
    public void clickEgin(int x, int y){
    	egoera.eskatu(x, y);
    }

	//public abstract Tableroa nTableroaLortu();
   
    //0 <= laukZab <= (laukiak[].lenght)-1
    //0 <= laukAlt <= (laukiak[0][].lenght)-1
    public void tableroaBete(int laukZab, int laukAlt){
        laukiak[laukZab-1][laukAlt-1] = new Hutsa();
        this.bonbakKokatu();
        int x = 0;
        int y = 0;
        for (Laukia[] lista : this.laukiak){
            for (Laukia l : lista){
                if(l==null){
                    laukiak[x][y] = new Hutsa();
                }
                else if (l instanceof Bonba){
                    hurbilakAldatu(x,y);
                }
                y++;
            }
        }
    }
 
    protected void bonbakKokatu(){
        int b = 0;
        int posX;
        int posY;
        while(b<this.bonbaKop){
            posX =(int)Math.random()*this.zabalera;
            posY =(int)Math.random()*this.altuera;
            if(laukiak[posX][posY]==null){
                laukiak[posX][posY] = new Bonba();
                b++;
            }
        }
    }
   
    protected void hurbilakAldatu(int x, int y){
        //Aurrebaldintza: Tableroa 2x2-koa izango da gutxienez
        //Metodo honetan bonbak egoteagatik aldaketak non egin ahal diren begiratzen du bakarrik,
        //ez du ezer ez aldatzen
        if (x == 0){                                //Ezkerraldeko zutabea
            if (y == 0){                            //Goiko errenkada
                hurbilaAldatu(x+1, y  );
                hurbilaAldatu(x+1, y+1);
                hurbilaAldatu(x  , y+1);
            }
            else if (y == (altuera-1)){   //Beheko errenkada
                hurbilaAldatu(x  , y-1);
                hurbilaAldatu(x+1, y-1);
                hurbilaAldatu(x+1, y  );
            }
            else{
                hurbilaAldatu(x  , y-1);
                hurbilaAldatu(x+1, y-1);
                hurbilaAldatu(x+1, y  );
                hurbilaAldatu(x+1, y+1);
                hurbilaAldatu(x  , y+1);
            }
        }
        else if (x == (zabalera-1)){          //Eskuinaldeko zutabea
            if (y == 0){
                hurbilaAldatu(x  , y+1);
                hurbilaAldatu(x-1, y+1);
                hurbilaAldatu(x-1, y  );
            }
            else if (y == (altuera-1)){
                hurbilaAldatu(x  , y-1);
                hurbilaAldatu(x-1, y  );
                hurbilaAldatu(x-1, y-1);
            }
            else{
                hurbilaAldatu(x  , y-1);
                hurbilaAldatu(x  , y+1);
                hurbilaAldatu(x-1, y+1);
                hurbilaAldatu(x-1, y  );
                hurbilaAldatu(x-1, y-1);
            }
        }
        else{
            if (y == 0){
                hurbilaAldatu(x+1, y  );
                hurbilaAldatu(x+1, y+1);
                hurbilaAldatu(x  , y+1);
                hurbilaAldatu(x-1, y+1);
                hurbilaAldatu(x-1, y  );
            }
            else if (y == (altuera-1)){
                hurbilaAldatu(x  , y-1);
                hurbilaAldatu(x+1, y-1);
                hurbilaAldatu(x+1, y  );
                hurbilaAldatu(x-1, y  );
                hurbilaAldatu(x-1, y-1);
            }
            else{
                hurbilaAldatu(x  , y-1);
                hurbilaAldatu(x+1, y-1);
                hurbilaAldatu(x+1, y  );
                hurbilaAldatu(x+1, y+1);
                hurbilaAldatu(x  , y+1);
                hurbilaAldatu(x-1, y+1);
                hurbilaAldatu(x-1, y  );
                hurbilaAldatu(x-1, y-1);
               
            }
        }
    }
   
    protected void hurbilaAldatu(int x, int y){
        if(laukiak[x][y] instanceof Hurbila){
            Hurbila hur = (Hurbila)laukiak[x][y];
            hur.bonbaGehitu();
        }
        else if(!(laukiak[x][y] instanceof Bonba)){
            laukiak[x][y] = new Hurbila();
        }
    }
   
    public void egoeraAldatu(State e){
    	this.egoera = e;
    }
   
    public void botonOff(int i, int j){
		botoiak[i][j].setEnabled(false);
	}
	
	public Laukia getLauki(int x, int y) {
		return laukiak[x][y];
	}

	public int getAltuera() {
		// TODO Auto-generated method stub
		return altuera;
	}

	public int getZabalera() {
		// TODO Auto-generated method stub
		return zabalera;
	}
 
}