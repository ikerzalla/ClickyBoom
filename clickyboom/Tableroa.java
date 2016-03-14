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
    private int hasAlt;
    private int hasZab;
    
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
    public void clickEgin(int alt, int zab){
    	System.out.println("Click egin da " + zab + "," + alt +" posizioan");
    	egoera.eskatu(alt, zab);
    }

	//public abstract Tableroa nTableroaLortu();
   
    //0 <= laukZab <= (laukiak[].lenght)-1
    //0 <= laukAlt <= (laukiak[0][].lenght)-1
    public void tableroaBete(int alt, int zab){
    	this.hasAlt = alt;
    	this.hasZab = zab;
        laukiak[alt][zab] = new Hutsa();
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
        int alt;
        int zab;
        while(b<this.bonbaKop){
            alt =(int)(Math.random()*this.altuera-1);
            zab =(int)(Math.random()*this.zabalera-1);
            if(!(alt+1 ==this.hasAlt || alt-1==this.hasAlt) && !(zab+1 ==this.hasZab || zab-1==this.hasZab)
            && laukiak[alt][zab]==null){ 	//If honen baldintza luzea da, hasieran click 
            								//egin dugun posizioaren alboan bonbak ez kokatzeko
                laukiak[alt][zab] = new Bonba();
                b++;
            }
        }
        System.out.println("Bonbak kokatu dira");
    }
   
    protected void hurbilakAldatu(int alt, int zab){
        //Aurrebaldintza: Tableroa 2zab2-koa izango da gutzabienez
        //Metodo honetan bonbak egoteagatik aldaketak non egin ahal diren begiratzen du bakarrik,
        //ez du ezer ez aldatzen
        if (alt == 0){                                //Ezkerraldeko zutabea
            if (zab == 0){                            //Goiko errenkada
                hurbilaAldatu(alt+1, zab  );
                hurbilaAldatu(alt+1, zab+1);
                hurbilaAldatu(alt  , zab+1);
            }
            else if (zab == (zabalera-1)){   //Beheko errenkada
                hurbilaAldatu(alt  , zab-1);
                hurbilaAldatu(alt+1, zab-1);
                hurbilaAldatu(alt+1, zab  );
            }
            else{
                hurbilaAldatu(alt  , zab-1);
                hurbilaAldatu(alt+1, zab-1);
                hurbilaAldatu(alt+1, zab  );
                hurbilaAldatu(alt+1, zab+1);
                hurbilaAldatu(alt  , zab+1);
            }
        }
        else if (alt == (altuera-1)){          //Eskuinaldeko zutabea
            if (zab == 0){
                hurbilaAldatu(alt  , zab+1);
                hurbilaAldatu(alt-1, zab+1);
                hurbilaAldatu(alt-1, zab  );
            }
            else if (zab == (zabalera-1)){
                hurbilaAldatu(alt  , zab-1);
                hurbilaAldatu(alt-1, zab  );
                hurbilaAldatu(alt-1, zab-1);
            }
            else{
                hurbilaAldatu(alt  , zab-1);
                hurbilaAldatu(alt  , zab+1);
                hurbilaAldatu(alt-1, zab+1);
                hurbilaAldatu(alt-1, zab  );
                hurbilaAldatu(alt-1, zab-1);
            }
        }
        else{
            if (zab == 0){
                hurbilaAldatu(alt+1, zab  );
                hurbilaAldatu(alt+1, zab+1);
                hurbilaAldatu(alt  , zab+1);
                hurbilaAldatu(alt-1, zab+1);
                hurbilaAldatu(alt-1, zab  );
            }
            else if (zab == (zabalera-1)){
                hurbilaAldatu(alt  , zab-1);
                hurbilaAldatu(alt+1, zab-1);
                hurbilaAldatu(alt+1, zab  );
                hurbilaAldatu(alt-1, zab  );
                hurbilaAldatu(alt-1, zab-1);
            }
            else{
                hurbilaAldatu(alt  , zab-1);
                hurbilaAldatu(alt+1, zab-1);
                hurbilaAldatu(alt+1, zab  );
                hurbilaAldatu(alt+1, zab+1);
                hurbilaAldatu(alt  , zab+1);
                hurbilaAldatu(alt-1, zab+1);
                hurbilaAldatu(alt-1, zab  );
                hurbilaAldatu(alt-1, zab-1);
               
            }
        }
        System.out.println(zab + "," + alt + " posizioko bonbaren albokoak aldatu dira");
    }
   
    protected void hurbilaAldatu(int alt, int zab){
    	if(!(alt== this.hasAlt && zab == this.hasZab)){
	        if(laukiak[alt][zab] instanceof Hurbila){
	            Hurbila hur = (Hurbila)laukiak[alt][zab];
	            hur.bonbaGehitu();
	        }
	        else if(!(laukiak[alt][zab] instanceof Bonba)){
	            laukiak[alt][zab] = new Hurbila();
	        }
    	}
    }
   
    public void egoeraAldatu(State e){
    	this.egoera = e;
    }
   
    public void botonOff(int alt, int zab){
		botoiak[alt][zab].setEnabled(false);
	}
	
	public Laukia getLauki(int alt, int zab) {
		return laukiak[alt][zab];
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