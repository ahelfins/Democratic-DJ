import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Celine Lee
 * @version 5/20/16
 */
public class InstructionsPage extends JPanel implements ActionListener {

	public static final int WIDTH = 1500;
	public static final int HEIGHT = 800;

	Main m;
	JButton play, menu;

	public InstructionsPage(Main m) {
		super();

		this.m=m;
		
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
				
		play = new JButton("Play!");
		menu = new JButton("Back");
		play.addActionListener(this);
		menu.addActionListener(this);
		
		JPanel bp = new JPanel();
		bp.add(play);
		bp.add(menu);
		bp.setBackground(Color.WHITE);
		
		JPanel t = new JPanel();
		JLabel title = new JLabel("Instructions");
		title.setFont(new Font("Sarif", 1, 25));
		t.add(title);
		t.setBackground(Color.WHITE);

		JPanel thx = new JPanel(new BorderLayout());
		thx.setBackground(Color.WHITE);
		JPanel text = new JPanel(new GridLayout(3, 1));
		text.setBackground(Color.WHITE);
		JLabel description = new JLabel(
				"     Become a virtual piano genius! Play your computer keyboard as if it were a piano. As you play, the notes you hit will be transcribed onto sheet music.");
		description.setFont(new Font("Sarif", 1, 17));
		text.add(description);
		JLabel how = new JLabel("      See the labelled letters for which keys correspond to which piano notes. ");
		how.setFont(new Font("Sarif", 1, 17));
		text.add(how);
		JLabel sharp = new JLabel("      The regular notes will show up on the sheet music in black. The sharp notes will be blue. Short notes will be a circle. Long, held notes will rectangles.");
		sharp.setFont(new Font("Sarif", 1, 17));
		text.add(sharp);
		thx.add(text, BorderLayout.NORTH);
		ImagePanel keyboard = new ImagePanel(new ImageIcon("Keyboard.png").getImage());
		thx.add(keyboard, BorderLayout.CENTER);
		JPanel empty = new JPanel();
		JLabel empt = new JLabel("                ");
		empty.setBackground(Color.WHITE);
		empty.add(empt);
		thx.add(empty, BorderLayout.WEST);
		
		add(t, BorderLayout.NORTH);
		add(thx, BorderLayout.CENTER);
		add(bp, BorderLayout.SOUTH);
		setVisible(true);
	}

	public void paintComponent(Graphics g) {

		super.paintComponents(g);
//
//		Graphics2D g2 = (Graphics2D) g;
//
//		int width = getWidth();
//		int height = getHeight();
//
//		double ratioX = (double) width / WIDTH;
//		double ratioY = (double) height / HEIGHT;
//
//		AffineTransform at = g2.getTransform();
//		g2.scale(ratioX, ratioY);
//
//		g2.setTransform(at);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menu) {
			m.changePanel("1");
		} else if (e.getSource() == play) {
			m.changePanel("2");
		}
	}

}
