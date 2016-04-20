package clickyboom;

public class TableroaTest {
	private Jokoa jok = Jokoa.getNireJokoa();
	
	@Before
	public void setUp() throws Exception {
		//jok.jokatu();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSortuTableroErraza() {
		System.out.println("Tablero Erraza:");
		Tableroa tab = new TableroErraza();
		
		tab.tableroaBete(0, 0);
		tab.inprimatu();
		
		tab = new TableroErraza();
		tab.tableroaBete(0, tab.getZabalera()/2);
		tab.inprimatu();
		
		tab = new TableroErraza();
		tab.tableroaBete(0, tab.getZabalera()-1);
		tab.inprimatu();
		
		tab = new TableroErraza();
		tab.tableroaBete(tab.getAltuera()/2, tab.getZabalera()-1);
		tab.inprimatu();
		
		tab = new TableroErraza();
		tab.tableroaBete(tab.getAltuera()-1, tab.getZabalera()-1);
		tab.inprimatu();
		
		tab = new TableroErraza();
		tab.tableroaBete(tab.getAltuera()-1, tab.getZabalera()/2);
		tab.inprimatu();
		
		tab = new TableroErraza();
		tab.tableroaBete(tab.getAltuera()-1, 0);
		tab.inprimatu();
		
		tab = new TableroErraza();
		tab.tableroaBete(tab.getAltuera()/2, 0);
		tab.inprimatu();
		
		tab = new TableroErraza();
		tab.tableroaBete(tab.getAltuera()/2, tab.getZabalera()/2);
		tab.inprimatu();
		
	}
	
	@Test
	public void testSortuTableroNormala() {
		System.out.println("Tablero Normala:");
		Tableroa tab = new TableroNormala();
		
		tab.tableroaBete(0, 0);
		tab.inprimatu();
		
		tab = new TableroNormala();
		tab.tableroaBete(0, tab.getZabalera()/2);
		tab.inprimatu();
		
		tab = new TableroNormala();
		tab.tableroaBete(0, tab.getZabalera()-1);
		tab.inprimatu();
		
		tab = new TableroNormala();
		tab.tableroaBete(tab.getAltuera()/2, tab.getZabalera()-1);
		tab.inprimatu();
		
		tab = new TableroNormala();
		tab.tableroaBete(tab.getAltuera()-1, tab.getZabalera()-1);
		tab.inprimatu();
		
		tab = new TableroNormala();
		tab.tableroaBete(tab.getAltuera()-1, tab.getZabalera()/2);
		tab.inprimatu();
		
		tab = new TableroNormala();
		tab.tableroaBete(tab.getAltuera()-1, 0);
		tab.inprimatu();
		
		tab = new TableroNormala();
		tab.tableroaBete(tab.getAltuera()/2, 0);
		tab.inprimatu();
		
		tab = new TableroNormala();
		tab.tableroaBete(tab.getAltuera()/2, tab.getZabalera()/2);
		tab.inprimatu();
		
	}
	
	@Test
	public void testSortuTableroZaila() {
		System.out.println("Tablero Zaila:");
		Tableroa tab = new TableroZaila();
		
		tab.tableroaBete(0, 0);
		tab.inprimatu();
		
		tab = new TableroZaila();
		tab.tableroaBete(0, tab.getZabalera()/2);
		tab.inprimatu();
		
		tab = new TableroZaila();
		tab.tableroaBete(0, tab.getZabalera()-1);
		tab.inprimatu();
		
		tab = new TableroZaila();
		tab.tableroaBete(tab.getAltuera()/2, tab.getZabalera()-1);
		tab.inprimatu();
		
		tab = new TableroZaila();
		tab.tableroaBete(tab.getAltuera()-1, tab.getZabalera()-1);
		tab.inprimatu();
		
		tab = new TableroZaila();
		tab.tableroaBete(tab.getAltuera()-1, tab.getZabalera()/2);
		tab.inprimatu();
		
		tab = new TableroZaila();
		tab.tableroaBete(tab.getAltuera()-1, 0);
		tab.inprimatu();
		
		tab = new TableroZaila();
		tab.tableroaBete(tab.getAltuera()/2, 0);
		tab.inprimatu();
		
		tab = new TableroZaila();
		tab.tableroaBete(tab.getAltuera()/2, tab.getZabalera()/2);
		tab.inprimatu();
		
	}

}
