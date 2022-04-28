package game;

/**
 * Class that holds sword information.
 * 
 * @author pwsmith4
 */
public class Sword implements EquipmentType {

  private int damage;
  private String name;
  private int cost;

  /** Initializes Sword. */
  public Sword() {
    damage = 0;
    cost = 0;
    name = "No Sword";
  }

  /** Determines which sword based on rarity. */
  public void setSword(int rarity) {
    if (rarity <= 50 && damage < 1) {
      name = "Broken Sword";
      damage = 1;
      cost = 2;
    } else if ( (rarity > 50 && rarity <= 80) && (damage < 2) ) {
      name = "Used Longsword";
      damage = 2;
      cost = 4;
    } else if (rarity > 80 && damage < 3) {
      name = "Shiny Knight's Sword";
      damage = 3;
      cost = 6;
    }
  }

  /** Return Sword Damage. */
  public int getDamage() {
    return damage;
  }

  /** Return Sword name. */
  public String getName() {
    return name;
  }

  /** Return cost. */
  public int getCost() {
    return cost;
  }
}
