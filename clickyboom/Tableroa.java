package clickyboom;
import javax.swing.JButton;

//Enkapsulazio handiagoa nahiko bagenu Singleton patroia Tableroa klasean erabiltzeko eta
//tablero bakarra egoteko, Tableroa interfaze bat izan beharko litzateke, klase abstraktu
//batean ezin daitekeelako Singleton patroia inplementatu.
//Hala ere, gure proiektuarentzako Tableroa abstraktua edo interfazea izateak ez du
//ezberdintasun askorik.
 
public abstract class Tableroa {
    private Laukia[][] laukiak;
    private JButton[][] botoiak;
    private int bonbaKop;
    private int altuera;
    private int zabalera;
    private State egoera;
    //Bi atributu hauek erabili ditut bonben ondoan dauden laukiak ikutzean,
    //hasieran click egin dugun laukia HUTSA jarraitzen izateko hurbilakAldatu() metodoa eta gero
    //Hala ere, inprimatu metodoaren emaitza ikusita, baliteke "zabalera" eta "altuera" hitzak trukatzea
    private int hasY;
    private int hasX;
    
    protected Tableroa(int alt, int zab, int bon){
    	this.altuera = alt;
    	this.zabalera = zab;
    	this.laukiak = new Laukia[alt][zab];
		this.botoiak = new JButton[alt][zab];
    	this.bonbaKop = bon;
    	this.egoera = new StateHutsa();
    }
    //Lauki batean click egitean, laukiak metodo honi deituko
    //dio bere posizioa pasatuz
    public void clickEgin(int y, int x){
    	System.out.println("Click egin da " + y + "," + x +" posizioan");
    	egoera.eskatu(y, x);
    }

	//public abstract Tableroa nTableroaLortu();
   
    //0 <= laukZab <= (laukiak[].lenght)-1
    //0 <= laukAlt <= (laukiak[0][].lenght)-1
    public void tableroaBete(int laukZab, int laukAlt){
    	this.hasY = laukAlt;
    	this.hasX = laukZab;
        laukiak[laukAlt][laukZab] = new Hutsa();
        this.bonbakKokatu();
        int y = 0;
        int x = 0;
        Laukia [] lista = null;
        while (y<=this.altuera-1){
        	lista =  this.laukiak[y];
            for (Laukia l : lista){
                if(l==null){
                    laukiak[y][x] = new Hutsa();
                }
                else if (l instanceof Bonba){
                    hurbilakAldatu(y,x); 
                    //hasX eta hasY gehitu ditut bonben ondoan dauden laukiak aldatzean 
                    //hasierako hutsunea ez aldatzeko
                }
                x++;
            }
            x=0;
            y++;
        }
        System.out.println("Tableroa bete da");
    }
 
    protected void bonbakKokatu(){
        int b = 0;
        int posY;
        int posX;
        while(b<this.bonbaKop){
            posY =(int)(Math.random()*this.altuera-1);
            posX =(int)(Math.random()*this.zabalera-1);
            if(!(posY+1 ==this.hasY || posY-1==this.hasY) && !(posX+1 ==this.hasX || posX-1==this.hasX)
            && laukiak[posY][posX]==null){ 	//If honen baldintza luzea da, hasieran click 
            								//egin dugun posizioaren alboan bonbak ez kokatzeko
                laukiak[posY][posX] = new Bonba();
                b++;
            }
        }
        System.out.println("Bonbak kokatu dira");
    }
   
    protected void hurbilakAldatu(int y, int x){
        //Aurrebaldintza: Tableroa 2x2-koa izango da gutxienez
        //Metodo honetan bonbak egoteagatik aldaketak non egin ahal diren begiratzen du bakarrik,
        //ez du ezer ez aldatzen
        if (y == 0){                                //Ezkerraldeko zutabea
            if (x == 0){                            //Goiko errenkada
                hurbilaAldatu(y+1, x  );
                hurbilaAldatu(y+1, x+1);
                hurbilaAldatu(y  , x+1);
            }
            else if (x == (zabalera-1)){   //Beheko errenkada
                hurbilaAldatu(y  , x-1);
                hurbilaAldatu(y+1, x-1);
                hurbilaAldatu(y+1, x  );
            }
            else{
                hurbilaAldatu(y  , x-1);
                hurbilaAldatu(y+1, x-1);
                hurbilaAldatu(y+1, x  );
                hurbilaAldatu(y+1, x+1);
                hurbilaAldatu(y  , x+1);
            }
        }
        else if (y == (altuera-1)){          //Eskuinaldeko zutabea
            if (x == 0){
                hurbilaAldatu(y  , x+1);
                hurbilaAldatu(y-1, x+1);
                hurbilaAldatu(y-1, x  );
            }
            else if (x == (zabalera-1)){
                hurbilaAldatu(y  , x-1);
                hurbilaAldatu(y-1, x  );
                hurbilaAldatu(y-1, x-1);
            }
            else{
                hurbilaAldatu(y  , x-1);
                hurbilaAldatu(y  , x+1);
                hurbilaAldatu(y-1, x+1);
                hurbilaAldatu(y-1, x  );
                hurbilaAldatu(y-1, x-1);
            }
        }
        else{
            if (x == 0){
                hurbilaAldatu(y+1, x  );
                hurbilaAldatu(y+1, x+1);
                hurbilaAldatu(y  , x+1);
                hurbilaAldatu(y-1, x+1);
                hurbilaAldatu(y-1, x  );
            }
            else if (x == (zabalera-1)){
                hurbilaAldatu(y  , x-1);
                hurbilaAldatu(y+1, x-1);
                hurbilaAldatu(y+1, x  );
                hurbilaAldatu(y-1, x  );
                hurbilaAldatu(y-1, x-1);
            }
            else{
                hurbilaAldatu(y  , x-1);
                hurbilaAldatu(y+1, x-1);
                hurbilaAldatu(y+1, x  );
                hurbilaAldatu(y+1, x+1);
                hurbilaAldatu(y  , x+1);
                hurbilaAldatu(y-1, x+1);
                hurbilaAldatu(y-1, x  );
                hurbilaAldatu(y-1, x-1);
               
            }
        }
        System.out.println(y + "," + x + " posizioko bonbaren albokoak aldatu dira");
    }
   
    protected void hurbilaAldatu(int y, int x){
    	if(!(y== this.hasY && x == this.hasX)){
	        if(laukiak[y][x] instanceof Hurbila){
	            Hurbila hur = (Hurbila)laukiak[y][x];
	            hur.bonbaGehitu();
	        }
	        else if(!(laukiak[y][x] instanceof Bonba)){
	            laukiak[y][x] = new Hurbila();
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
		return laukiak[y][x];
	}

	public int getAltuera() {
		return altuera;
	}

	public int getZabalera() {
		return zabalera;
	}
	//Metodo hau tableroa ondo sortu dela probatzeko da bakarrik
	public void inprimatu(){
		int y = 0;
        Laukia [] lista = null;
        while (y<=this.altuera-1){
        	lista =  this.laukiak[y];
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
            y++;
        }
	}
 
}