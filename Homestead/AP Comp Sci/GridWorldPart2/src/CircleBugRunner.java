import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains circle bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class CircleBugRunner {
	
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        CircleBug mark = new CircleBug(6);
        mark.setColor(Color.ORANGE);
        CircleBug lucy = new CircleBug(3);
        world.add(new Location(7, 8), mark);
        world.add(new Location(5, 5), lucy);
        world.show();
    }
	
}
