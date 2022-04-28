package game;

/**
 * Class that holds Helmet information.
 * 
 * @author pwsmith4
 */
public class Helmet implements EquipmentType {
  private int hp;
  private String name;
  private int cost;

  /** Initializes Helmet. */
  public Helmet() {
    hp = 0;
    cost = 0;
    name = "No Helmet";
  }

  /** Determines which Helmet based on rarity. */
  public void setHelmet(int rarity) {
    if (rarity <= 50 && hp < 1) {
      name = "Broken Helmet";
      hp = 1;
      cost = 2;
    } else if ( (rarity > 50 && rarity <= 80) && (hp < 2) ) {
      name = "Old Helmet";
      hp = 2;
      cost = 4;
    } else if (rarity > 80 && hp < 3) {
      name = "New Helmet";
      hp = 3;
      cost = 6;
    }
  }

  /** Return Helmet HP. */
  public int getHp() {
    return hp;
  }

  /** Return Helmet Name. */
  public String getName() {
    return name;
  }

  /** Return cost. */
  public int getCost() {
    return cost;
  }
}
