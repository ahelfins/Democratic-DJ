
import java.util.ArrayList;

public class Farm{
  private ArrayList<Animal> myFarm = new ArrayList<Animal>();

  public Farm(){
    myFarm.add(new Cow());
    myFarm.add(new Chick());
    myFarm.add(new Pig());
  }

  // This method prints out the result of each animal's toString() method to the command
  // line window.
  public void printAnimalSounds(){
    ...
  }

  // This method prints out the lyrics to OldMacDonald, including all animals in the farm.
  public void printOldMacDonaldSong() {
	...
  }
}
