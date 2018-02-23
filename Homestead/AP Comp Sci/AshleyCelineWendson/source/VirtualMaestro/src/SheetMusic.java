import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
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

/**Represents the sheet music for a song and creates the visual and File versions of the notes
 * 
 * @author Ashley Helfinstein
 * @version 5/23/16
 *
 */
public class SheetMusic extends JPanel implements OutputableFile, ActionListener  {
	
	private BufferedImage staffSheet; 
	private ArrayList<Note> notes; 
	//an Array to hold the y coordinates of the lines on the sheet music (at spot 0 is the first line, etc) 
	//only for each group of 5 lines
	private int[] lines; 
	//represent the top left corner of the staff sheet and width and height
	private int x, y, width, height;
	private int noteHeight;
	//the x loc of the note on the line (current) and y loc of the top line in the (current) group of 5
	private int lineX, lineY;
	//whether the current note is sharp
	private boolean sharp;
	//whether the current note is empty (not a note on the keyboard)
	private boolean blank;
	JButton getSheetMusic;
	JButton getAudioRecording;
	private Instrument instrument; 
	private Audio aud; 
	
	
	
	/**Constructs a SheetMusic object with the given x, y, width and height, as well as an ArrayList and staff sheet image
	 * 
	 * @param x the x coordinate of the top left of the SheetMusic
	 * @param y the y coordinate of the top left of the SheetMusic
	 * @param width the width of the SheetMusic
	 * @param height the height of the SheetMusic
	 */
	public SheetMusic(int x, int y, int width, int height, Instrument instrument) {
		JPanel b = new JPanel();
		getSheetMusic = new JButton("Get Sheet Music!");
		getSheetMusic.addActionListener(this);
		getAudioRecording = new JButton("Get Audio Recording!");
		getAudioRecording.addActionListener(this);
		b.add(getSheetMusic);
		b.add(getAudioRecording);
		b.setBackground(Color.WHITE);
		
		notes=new ArrayList<Note>();
		lineX=x+60;
		lineY=y+10;
		lines=new int[11];
		addLines();
		sharp=false;
		blank=false;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		noteHeight=12;
		this.instrument=instrument;
		aud= new Audio(instrument, this);
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		add(b, BorderLayout.EAST);
		
		try {                
          staffSheet = ImageIO.read(new File("treblestaffsheet.gif"));
       } catch (IOException ex) {
            ex.printStackTrace();
       }
    }

	/**Adds the given Note to the SheetMusic ArrayList of Notes
	 * 
	 * @param n the Note to add to the ArrayList of Notes in SheetMusic
	 */
	public void addNote(Note n){
		notes.add(n);
	}

	/**Converts the given Note into a Shape to represent it (on Sheet Music)
	 * see java.awt.Shape for more information
	 * 
	 * @param n the Note to be converted
	 * @return Shape the Shape that represents the given Note
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
		//C is under the bottom line
		//D is between the C and the bottom line
		//EGBDF are on the lines (ascending)
		//FACE are between the lines (ascending--F above E, below G)
		//color of sharp is different
		
		/*key 'A' = C
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
		 * ';'=where the E of face is (higher E)
		 */
		if(pitch=='A'){
			sharp=false;
			blank=false;
			//if the key is quickly pressed
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[10], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[10], addLen, noteHeight);
				lineX+=addLen;
			}	
		}
		else if(pitch=='W'){
			sharp=true;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[10], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[10], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch=='S'){
			sharp=false;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[9], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[9], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch=='E'){
			sharp=true;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[9], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[9], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch=='D'){
			sharp=false;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[8], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[8], addLen, noteHeight);
				lineX+=addLen;
			}
			
		}
		else if(pitch=='F'){
			sharp=false;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[7], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[7], addLen, noteHeight);
				lineX+=addLen;
			}
		
		}
		else if(pitch=='T'){
			sharp=true;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[7], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[7], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch=='G'){
			sharp=false;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[6], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[6], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch=='Y'){
			sharp=true;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[6], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[6], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch=='H'){
			sharp=false;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[5], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[5], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch=='U'){
			sharp=true;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[5], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[5], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch=='J'){
			sharp=false;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[4], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[4], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch=='L'){
			sharp=false;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[2], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[2], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch=='P'){
			sharp=true;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[2], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[2], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch=='K'){
			sharp=false;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[3], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[3], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch=='O'){
			sharp=true;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[3], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[3], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else if(pitch==';'){
			sharp=false;
			blank=false;
			if(n.getLength()<100){
				toDraw=new Ellipse2D.Double(lineX, lines[1], noteHeight, noteHeight);
				lineX+=noteHeight;
			}
			else{
				toDraw=new Rectangle2D.Double(lineX, lines[1], addLen, noteHeight);
				lineX+=addLen;
			}
		}
		else{
			sharp=false;
			blank=true;
			if(n.getLength()<100){
				toDraw=new Rectangle2D.Double(x-2, lines[0], 1, 12);
			}
			else{
				toDraw=new Rectangle2D.Double(x-2, lines[0], 1, 12);
			}
		}
		return toDraw;
		
	}
	
	/**Writes the image File with the Sheet Music
	 * 
	 * @return boolean whether the File wrote correctly
	 */
	public boolean writeFile() {
		String s = System.getProperty("file.separator");
		File f = new File(".."+s+"SheetMusic.jpg");
		Component c = this; 
		try{
			Dimension d = c.getSize();
			BufferedImage capture = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = capture.createGraphics();
	        c.paint(g2);
			ImageIO.write(capture, "bmp", f);
			return true;
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
	
	public ArrayList<Note> getNotes(){
		return notes;
	}
	
	//to update the x coordinate as notes are added
	//returns boolean whether to call convertNote again
	//(you need to call it again if you update the LineX and LineY to get a correct Shape for the Note)
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
        for(Note n: notes){
        	Shape s = convertNote(n);
        	if(updateLineY()){
        		s=convertNote(n);
        	}
        	if(sharp)
        		g.setColor(Color.CYAN);
        	else if(blank){
        		g.setColor(Color.WHITE);
        	}
        	else
        		g.setColor(Color.BLACK);
        	((Graphics2D) g).fill(s);
        	((Graphics2D) g).draw(s);
        }
        
    }

    /**
     * Resets the variable for the x location of the Notes
     */
    public void resetLineX(){
    	lineX=x+60;
    }
    /**
     * Resets the variable for the y location of the Notes
     */
    public void resetLineY(){
    	lineY=y+10;
    	addLines();
    }
    
    /**Returns whether the given note is blank
     * 
     * @param n the Note to check for blankness
     * @return boolean whether current state isBlank
     */
    public boolean isBlank(Note n){
    	convertNote(n);
    	return blank;
    }
    
	/**
	 * Checks when an action is performed in this ActionListener
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getSheetMusic){
			resetLineX();
			resetLineY();
			writeFile();
		}
		else if(e.getSource() == getAudioRecording){
			aud.writeFile();
		}

	}

	
	
}
