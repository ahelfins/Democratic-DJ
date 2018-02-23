import info.gridworld.actor.Bug;

/**
 * A <code>ZBug</code> traces out a letter Z of a given side length. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug {
	
		private int side;
	    private int steps;
	    private int sideLength;

	    /**
	     * Constructs a box bug that traces a square of a given side length
	     * @param length the side length
	     */
	    public ZBug(int length)
	    {
	    	side = 1;
	        steps = 0;
	        sideLength = length;
	    }

	    /**
	     * Moves to the next location of the Z.
	     */
	    public void act()
	    {
	    	if (!canMove())
	    		return;
	    	else if(side==1){
	    		if (getDirection()==90){
	    			 if(steps < sideLength){
	    				 move();
	    				 steps++;
	    			 }
	    			 else
	    			 {
	    				 turn();
	    				 turn();
	    				 turn();
	    				 steps = 0;
	    				 side++;
	    			 }
	    		}
	    		else{
	    			setDirection(90);
	    		}
	    	}
	    	else if(side==2){
	    		if(steps<sideLength){
	    			move();
	    			steps++;
	    		}
	    		else{
	    			turn();
	    			turn();
	    			turn();
	    			turn();
	    			turn();
	    			steps = 0;
	    			side = 3;
	    		}
	    	}
	    	else if(side==3){
	    		if(steps<sideLength){
	    			move();
	    			steps++;
	    		}
	    		else{
	    			return;
	    		}
	    	}
	    	
	    }
	

}
