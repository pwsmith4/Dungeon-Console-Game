package game;

/**
 * Class that holds Boots information.
 * 
 * @author pwsmith4
 */
public class Boots {
  private int speed;
  private String name;
  private int cost;

  /** Initializes Boots. */
  public Boots() {
    speed = 0;
    cost = 0;
    name = "No Boots";
  }

  /** Determines which Boots based on rarity. */
  public void setBoots(int rarity) {
    if (rarity <= 50 && speed < 1) {
      name = "Worn Out Boots";
      speed = 1;
      cost = 2;
    } else if ( (rarity > 50 && rarity <= 80) && (speed < 2) ) {
      name = "Traveler's Shoes";
      speed = 2;
      cost = 4;
    } else if (rarity > 80 && speed < 3) {
      name = "Shiny Sprinting Shoes";
      speed = 3;
      cost = 6;
    }
  }

  /** Return speed.  */
  public int getSpeed() {
    return speed;
  }

  /** Return name. */
  public String getName() {
    return name;
  }

  /** Return cost. */
  public int getCost() {
    return cost;
  }
}
