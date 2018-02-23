import java.awt.AWTError;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Represents the sheet music for a song and creates the visual and File versions of the notes
 * @author Ashley Helfinstein
 * @version 5/22/16
 *
 */
public class SheetMusic extends JPanel implements OutputableFile, ActionListener {
	
	private BufferedImage output;
	private BufferedImage staffSheet; 
	private ArrayList<Note> notes; 
	private int listLoc; 
	//an Array to hold the y coordinates of the lines on the sheet music (at spot 0 is the first line, etc) 
	//only for each group of 5 lines
	private int[] lines; 
	//represent the top left corner of the staff sheet and width and height
	private int x, y, width, height; 
	//the x loc of the note on the line (current) and y loc of the top line in the (current) group of 5
	private int lineX, lineY;
	//whether the current note is sharp
	private boolean sharp;
	JButton getSheetMusic;
	
	/**
	 * creates a SheetMusic object with the StaffSheet and Notes ArrayList set
	 */
	public SheetMusic(int x, int y, int width, int height) {
		JPanel b = new JPanel();
		getSheetMusic = new JButton("Get Sheet Music!");
		b.add(getSheetMusic);
		b.setBackground(Color.WHITE);
		
		notes=new ArrayList<Note>();
		lineX=x+60;
		lineY=y+10;
		lines=new int[11];
		addLines();
		sharp=false;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		add(b, BorderLayout.EAST);
		
		try {                
          staffSheet = ImageIO.read(new File("treblestaffsheet.gif"));
       } catch (IOException ex) {
            ex.printStackTrace();
       }
    }

	/**
	 * adds the given Note to the SheetMusic ArrayList of Notes
	 * @param n the Note to add to the ArrayList of Notes in SheetMusic
	 */
	public void addNote(Note n){
		notes.add(n);
	}

	/**Converts the given note into a shape to represent it (on sheet music)
	 * 
	 * @param Note the note to be converted
	 * @return Shape the shape that represents the given note
	 */
	public Shape convertNote(Note n) {
		// TODO Auto-generated method stub
		Shape toDraw=null;
		char pitch = n.getPitch();
		int addLen=0;
		for(int i=0; i<n.getLength(); i+=10){
			addLen+=2;
		}
		if(n.getLength()>4025){
			addLen=805;
		}
		//c is under the bottom line
		//d is between the c and the bottom line
		//EGBDF are on the lines (ascending)
		//FACE are between the lines (ascending--F above E, below G)
		//color of sharp is different
		
		/*button 'A' = C
		 * 'W'=C#
		 * 'S'=D
		 * 'E'=D#
		 * 'D'=E
		 * 'F'=F
		 * 'T'=F#
		 * 'G'=G
		 * 'Y'=G#
		 * 'H'=A
		 * 'U'=A#
		 * 'J'=B
		 * 'K'=where the C of face is (higher C)
		 * 'O'=# of previous
		 * 'L'=where D of EGBDF is
		 * 'P'=# of previous
		 */
		if(pitch=='A'){
			sharp=false;
			//if the key is quickly pressed
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[10], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[10], addLen, 16);
				lineX+=addLen;
			}	
		}
		else if(pitch=='W'){
			sharp=true;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[10], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[10], addLen, 16);
				lineX+=addLen;
			}
		}
		else if(pitch=='S'){
			sharp=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[9], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[9], addLen, 16);
				lineX+=addLen;
			}
		}
		else if(pitch=='E'){
			sharp=true;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[9], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[9], addLen, 16);
				lineX+=addLen;
			}
		}
		else if(pitch=='D'){
			sharp=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[8], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[8], addLen, 16);
				lineX+=addLen;
			}
			
		}
		else if(pitch=='F'){
			sharp=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[0], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[0], addLen, 16);
				lineX+=addLen;
			}
		
		}
		else if(pitch=='T'){
			sharp=true;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[0], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[0], addLen, 16);
				lineX+=addLen;
			}
		}
		else if(pitch=='G'){
			sharp=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[6], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[6], addLen, 16);
				lineX+=addLen;
			}
		}
		else if(pitch=='Y'){
			sharp=true;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[6], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[6], addLen, 16);
				lineX+=addLen;
			}
		}
		else if(pitch=='H'){
			sharp=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[9], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[9], addLen, 16);
				lineX+=addLen;
			}
		}
		else if(pitch=='U'){
			sharp=true;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[9], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[9], addLen, 16);
				lineX+=addLen;
			}
		}
		else if(pitch=='J'){
			sharp=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[4], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[4], addLen, 16);
				lineX+=addLen;
			}
		}
		else if(pitch=='L'){
			sharp=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[2], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[2], addLen, 16);
				lineX+=addLen;
			}
		}
		else if(pitch=='P'){
			sharp=true;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[2], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[2], addLen, 16);
				lineX+=addLen;
			}
		}
		else if(pitch=='K'){
			sharp=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[3], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[3], addLen, 16);
				lineX+=addLen;
			}
		}
		else if(pitch=='O'){
			sharp=true;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[3], 16, 16);
				lineX+=16;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[3], addLen, 16);
				lineX+=addLen;
			}
		}
		return toDraw;
		
	}
	
	/**Writes the image file with the sheet music 
	 * 
	 * @return boolean whether the file wrote correctly
	 */
	public boolean writeFile() {
		File f = new File("OutputSheetMusic.jpg");
		try{
			Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
			int xPos, yPos;
			if(d.getWidth()<1500){
				xPos=0;
			}
			else if(d.getWidth()<1600){
				xPos=(int)(160-d.getWidth());
			}
			else{
				xPos=100;
			}
			if(d.getHeight()<800){
				yPos=0;
			}
			else if(d.getHeight()<900){
				yPos=(int)(900-d.getHeight());
			}
			else{
				yPos=100;
			}
			Rectangle screenRect = new Rectangle(xPos+x, yPos+y, width, height);
			BufferedImage capture = new Robot().createScreenCapture(screenRect);
			ImageIO.write(capture, "bmp", f);
			return true;
		}
		catch(AWTException ex){
			ex.printStackTrace();
			return false;
		}
		catch(AWTError er){
			er.printStackTrace();
			return false;
		}
		catch(IllegalArgumentException ex){
			ex.printStackTrace();
			return false;
		}
		catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	//adds y coordinates of lines to array field
	//even indices are actual lines (odd are in between) 
	private void addLines(){
		//line 1
		lines[0]=lineY;
		//between first and second line
		//line 1.5
		lines[1]=lines[0]+6;
		//line 2
		lines[2]=lines[1]+6;
		//line 2.5
		lines[3]=lines[2]+6;
		//line 3
		lines[4]=lines[3]+6;
		//line 3.5
		lines[5]=lines[4]+6;
		//line 4
		lines[6]=lines[5]+6;
		//line 4.5
		lines[7]=lines[6]+6;
		//line 5
		lines[8]=lines[7]+6;
		//"line" 5.5
		lines[9]=lines[8]+6;
		//"line" 6
		lines[10]=lines[9]+6;
	}
	
	//to update the x coordinate as notes are added (eventually need if statements for whether to go to next group
	//if next group change lineY and re-call addLines)
	//spaces between are based on time between presses
	//returns boolean whether to call convertNote again
	private boolean updateLineY(){
		if(lineX>(x+width-32)){
			lineY+=95;
			lineX=x+60; 
			addLines();
			return true;
		}
		return false;
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(staffSheet, x, y, width, height, null); 
        addNote(new Note('A', 10, 300));
        addNote(new Note('G', 40, 8000));
        addNote(new Note('A', 20, 30));
        addNote(new Note('F', 40, 100));
        addNote(new Note('T', 10, 600));
        addNote(new Note('E', 20, 10));
        for(Note n: notes){
        	Shape s = convertNote(n);
        	if(updateLineY()){
        		s=convertNote(n);
        	}
        	if(sharp)
        		g.setColor(Color.CYAN);
        	((Graphics2D) g).fill(s);
        	((Graphics2D) g).draw(s);
        	//where do I put this? it should be a button!
        	writeFile();
        }
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
