import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The main.
 * 
 * @author Celine Lee, Wensdon Gao, Ashley Helfinstein
 * @version 5/23/16
 *
 */
public class Main extends JFrame implements ActionListener {

	JPanel cardPanel;
	JButton menu, instructions, menu2, instructions2;
	SheetMusic shP, shG;
	InstrumentKeyboard ikG, ikP;
	
	
	/**
	 * Constructs the main to run the program. Switches between three panels:
	 * menu, graphical window, instructions.
	 * 
	 * @param title
	 *            name of the program: Virtual Maestro.
	 */
	public Main(String title) {
		super(title);
		setBounds(100, 100, 1500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBackground(Color.WHITE);

		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);

		

		JPanel pianoPlayerPage = new JPanel();
		pianoPlayerPage.setBackground(Color.WHITE);
		pianoPlayerPage.setLayout(new BorderLayout());
		
		JPanel guzhengPlayerPage = new JPanel();
		guzhengPlayerPage.setBackground(Color.WHITE);
		guzhengPlayerPage.setLayout(new BorderLayout());

		instructions = new JButton("Instructions");
		instructions.addActionListener(this);
		menu = new JButton("Menu");
		menu.addActionListener(this);
		
		instructions2 = new JButton("Instructions");
		instructions2.addActionListener(this);
		menu2 = new JButton("Menu");
		menu2.addActionListener(this);

		JPanel bP = new JPanel();
		bP.add(instructions);
		bP.add(menu);
		bP.setBackground(Color.WHITE);

		JPanel bG = new JPanel();
		bG.add(instructions2);
		bG.add(menu2);
		bG.setBackground(Color.WHITE);

		JPanel playerP = new JPanel();
		playerP.setLayout(new GridLayout(2, 1));
		playerP.setBackground(Color.WHITE);

		shP = new SheetMusic(100, 0, 900, 375, new Piano("Piano.gif", 0, 0, 300, 300));
		playerP.add(shP);
		/*InstrumentKeyboard*/ ikP = new InstrumentKeyboard("piano", shP);
		playerP.add(ikP);

		pianoPlayerPage.add(bP, BorderLayout.NORTH);
		pianoPlayerPage.add(playerP, BorderLayout.CENTER);

		//
		
		JPanel playerG = new JPanel();
		playerG.setLayout(new GridLayout(2, 1));
		playerG.setBackground(Color.WHITE);

		/*SheetMusic */shG = new SheetMusic(100, 0, 900, 375, new Guzheng("Guzheng.gif", 0, 0, 300, 300));
		playerG.add(shG);
		/*InstrumentKeyboard*/ ikG = new InstrumentKeyboard("guzheng", shG);
		playerG.add(ikG);

		guzhengPlayerPage.add(bG, BorderLayout.NORTH);
		guzhengPlayerPage.add(playerG, BorderLayout.CENTER);

		//

		InstructionsPage panel3 = new InstructionsPage(this);
		MenuPage panel1 = new MenuPage(this);
		
		cardPanel.add(panel1, "1");
		cardPanel.add(pianoPlayerPage, "2");
		cardPanel.add(panel3, "3");
		cardPanel.add(guzhengPlayerPage, "4");

		add(cardPanel);

		setVisible(true);
	}
	
	/**Run the program
	 * 
	 * @param args comments line
	 */
	public static void main(String[] args) {
		Main m = new Main("Virtual Maestro");
	}
	
	/** Add keyListener to the instrumentKeyboard where we are 
	 * 
	 * @param s the name of the instrument where we are
	 */
	public void addKey(String s){
		if (s.equalsIgnoreCase("guzheng")){
			removeKeyListener(ikP);
			addKeyListener(ikG);
		}
		else if (s.equalsIgnoreCase("piano")){
			removeKeyListener(ikG);
			addKeyListener(ikP);}
	}
	
	/**
	 * Switches between panels as user presses buttons.
	 * 
	 * @param name name of panel to be switched to ("1" is menu, "pianoPlayerPage" is the piano player, "guzhengPlayerPage" is the guzheng player, and "3" is instructions)
	 */
	public void changePanel(String name) {
		((CardLayout) cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}
	
	/**
	 * Switches panels as user clicks on buttons.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu || e.getSource() == menu2) {
			changePanel("1");
			shP.resetLineX();
			shP.resetLineY();
			shG.resetLineX();
			shG.resetLineY();
		} else if (e.getSource() == instructions || e.getSource() == instructions2) {
			changePanel("3");
			shP.resetLineX();
			shP.resetLineY();
			shG.resetLineX();
			shG.resetLineY();
		}

	}
}
