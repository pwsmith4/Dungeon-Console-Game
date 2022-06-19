package game;

/**
 * A class that contains the monster object.
 *
 * @author Parker Smith 
 */

public class Monster {

  private String monsterName; // monster name
  private int hitPoints; // monster HP
  private int attack; // monster attack
  private int defense; // monster defense
  private int gold; // gold for killing monster
  private int xp; // xp for killing monster
  private int speed; //speed of the monster
  private int statusEffect; // status effect monster can use. 1 = paralyze, 2 = burn, 3 = injured

  /**
   * Constructs a new monster instance.
   * @param name        the name of the character.
   * @param hp          the hit points of the character.
   * @param atk         the attack points of the character.
   * @param def         the defense points of the character.
   * @param sped         the magic points of the character.
   */
  public Monster(String name, int hp, int atk, int def, int sped, int gld,
      int monstxp, int status) {
    monsterName = name;
    hitPoints = hp;
    attack = atk;
    defense = def;
    gold = gld;
    xp = monstxp;
    speed = sped;
    statusEffect = status;
  }

  /** Returns the name of the character. */
  public String getName() {
    return monsterName;
  }

  /** Returns the HP of the character. */
  public int getHp() {
    return hitPoints;
  }

  /** Changes the HP to reflect attack damage. */
  public void dealDamage(int damage) {
    this.hitPoints -= (damage - defense);
  }

  /** Returns the attack points of the character. */
  public int getAtk() {
    return attack;
  }

  /** Returns the defense points of the character. */
  public int getDef() {
    return defense;
  }

  /** Returns the speed of the character. */
  public int getSpeed() {
    return speed;
  }

  /** Changes the HP. */
  public void setHp(int health) {
    this.hitPoints = health;
  }

  /** Gets XP for killing monster. */
  public int getXp() {
    return xp;
  }

  /** Gets Gold for killing monster. */
  public int getGold() {
    return gold;
  }

  /** Return Status Effect. */
  public int statusEffect() {
    return statusEffect;
  }
}
