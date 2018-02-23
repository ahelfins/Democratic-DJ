
public class CircleBug extends BoxBug {

	private int steps;
    private int sideLength;

	
	public CircleBug(int length) {
		super(length);
		// TODO Auto-generated constructor stub
	}
	
	public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }

}
