package clickyboom;
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
    //Bi atributu hauek erabili ditut bonben ondoan dauden laukiak ikutzean,
    //hasieran click egin dugun laukia HUTSA jarraitzen izateko hurbilakAldatu() metodoa eta gero
    //Hala ere, inprimatu metodoaren emaitza ikusita, baliteke "zabalera" eta "altuera" hitzak trukatzea
    protected int hasX;
    protected int hasY;
    
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
    	System.out.println("Click egin da");
    	egoera.eskatu(x, y);
    }

	//public abstract Tableroa nTableroaLortu();
   
    //0 <= laukZab <= (laukiak[].lenght)-1
    //0 <= laukAlt <= (laukiak[0][].lenght)-1
    public void tableroaBete(int laukZab, int laukAlt){
    	this.hasX = laukZab;
    	this.hasY = laukAlt;
        laukiak[laukZab][laukAlt] = new Hutsa();
        this.bonbakKokatu();
        int x = 0;
        int y = 0;
        Laukia [] lista = null;
        while (x<=this.zabalera-1){
        	lista =  this.laukiak[x];
            for (Laukia l : lista){
                if(l==null){
                    laukiak[x][y] = new Hutsa();
                }
                else if (l instanceof Bonba){
                    hurbilakAldatu(x,y); 
                    //hasX eta hasY gehitu ditut bonben ondoan dauden laukiak aldatzean 
                    //hasierako hutsunea ez aldatzeko
                }
                y++;
            }
            y=0;
            x++;
        }
        System.out.println("Tableroa bete da");
    }
 
    protected void bonbakKokatu(){
        int b = 0;
        int posX;
        int posY;
        while(b<this.bonbaKop){
            posX =(int)(Math.random()*this.zabalera-1);
            posY =(int)(Math.random()*this.altuera-1);
            if(laukiak[posX][posY]==null){
                laukiak[posX][posY] = new Bonba();
                b++;
            }
        }
        System.out.println("Bonbak kokatu dira");
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
        System.out.println(x + "," + y + " posizioko bonbaren albokoak aldatu dira");
    }
   
    protected void hurbilaAldatu(int x, int y){
    	if(x!= this.hasX && y != this.hasY){
	        if(laukiak[x][y] instanceof Hurbila){
	            Hurbila hur = (Hurbila)laukiak[x][y];
	            hur.bonbaGehitu();
	        }
	        else if(!(laukiak[x][y] instanceof Bonba)){
	            laukiak[x][y] = new Hurbila();
	        }
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
		return altuera;
	}

	public int getZabalera() {
		return zabalera;
	}
	//Metodo hau tableroa ondo sortu dela probatzeko da bakarrik
	public void inprimatu(){
		int x = 0;
        Laukia [] lista = null;
        while (x<=this.zabalera-1){
        	lista =  this.laukiak[x];
        	for (Laukia l : lista){
                if(l instanceof Bonba){
                    System.out.print("* ");
                }
                else if (l instanceof Hutsa){
                	System.out.print(". ");
                }
                else if(l instanceof Hurbila){
                	switch (((Hurbila) l).getBonbaKop()) {
					case 1: System.out.print("1 ");break;
					case 2: System.out.print("2 ");break;
					case 3: System.out.print("3 ");break;
					case 4: System.out.print("4 ");break;
					case 5: System.out.print("5 ");break;
					case 6: System.out.print("6 ");break;
					case 7: System.out.print("7 ");break;
					case 8: System.out.print("8 ");break;
					default:
						break;
					}
                }
            }
        	System.out.println("");
            x++;
        }
	}
 
}