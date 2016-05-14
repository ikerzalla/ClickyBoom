package interfazea;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.Font;

public class Arauak extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arauak frame = new Arauak();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Arauak() {
		setTitle("Arauak");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Arauak.class.getResource("/argazkiak/icono.jpg")));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea txtArauak = new JTextArea();
		txtArauak.setFont(new Font("Sitka Small", Font.BOLD, 13));
		txtArauak.setText("Helburua: Pantailan agertzen diren laukietan klik eginez zelaia garbitzea, minak zapaldu gabe.\r\n\r\nBadaude lau motatako laukiak:\r\n- Hasieran agertzen diren laukiak: Jarraian azaldutako edozein lauki mota izan ahal dira.\r\n- Ezer ez daukatenak: Lauki hutsak dira, ez dago arriskurik.\r\n- Zenbaki bat daukatenak: Lauki hutsak dira ere, ez daukate minarik, baina zenbakia alboan daukaten bonba kopurua adierazten du.\r\n- Mina daukatenak: Hauetan klik egiterakoan partida galdu egiten da.\r\n\r\nEzkerreko klik eginez oraindik zapaldu gabe dauden laukietan bandera bat ipini diezaiokegu mina dauden laukiak markatzeko, hauetan klik egiten badiogu ez du ezer egingo.\r\n\r\nHiru maila desberdin daude:\r\n- Erreza: 7x10 –eko pantaila, 10 mina dituena.\r\n- Normala: 10x15 –eko pantaila, 30 mina dituena.\r\n- Zaila: 12x25 –eko pantaila, 75 mina dituena.");
		contentPane.add(txtArauak, BorderLayout.CENTER);
		this.pack();
		}

}
