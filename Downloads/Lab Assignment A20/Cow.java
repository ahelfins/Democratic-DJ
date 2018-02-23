

public class Cow implements Animal{
  private String myType;
  private String mySound;

  Cow(){
    myType = "cow";
    mySound = "moo";
  }

  public String getSound() {
  	return mySound;
  }

  public String getType() {
 	return myType;
  }

  public String toString() {
	return "The " + getType() + " goes " + getSound();
  }

}
