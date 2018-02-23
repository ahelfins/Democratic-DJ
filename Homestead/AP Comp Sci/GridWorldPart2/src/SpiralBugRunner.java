
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains spiral bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class SpiralBugRunner {
	
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        //SpiralBug dennis = new SpiralBug(6);
        //dennis.setColor(Color.ORANGE);
        SpiralBug tammy = new SpiralBug(1);
        //world.add(new Location(7, 8), dennis);
        world.add(new Location(5, 5), tammy);
        world.show();
    }
	
}

