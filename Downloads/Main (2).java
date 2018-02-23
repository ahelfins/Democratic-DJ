import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The main.
 * @author Celine Lee
 * @version 5/15/16
 *
 */
public class Main extends JFrame{

	JPanel cardPanel;
	
	/**
	 * Constructs the main to run the program. Switches between three panels: menu, graphical window, instructions.
	 * @param title name of the program: Virtual Maestro.
	 */
	public Main(String title) {
		super(title);
		setBounds(100, 100, 1500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);
		
		Menu panel1 = new Menu(this);
		GraphicalWindow panel2 = new GraphicalWindow();
		Instructions panel3 = new Instructions();
//		InstrumentKeyboard ikey = new InstrumentKeyboard("piano");
		
//		addKeyListener(ikey.getKeyHandler());
		
		cardPanel.add(panel1, "1");
		cardPanel.add(panel2, "2");
		cardPanel.add(panel3, "3");

		
		add(cardPanel);
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		Main m = new Main("Virtual Maestro");
	}
	
	/**
	 * Switches between panels as user presses buttons.
	 * @param name name of panel to be switched to
	 */
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
}
