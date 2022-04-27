package game;

import java.util.Random;

/**
 * A class that holds new Monster Information.
 * 
 * @author pwsmith4
 **/

public class Monsters {

  /** Returns small Monsters. */
  public Monster smallMonsters() {
    Monster[] smallMonsters = new Monster[3];
    smallMonsters[0] = new Monster("Bandits", 30, 10, 10, 10, 1, 10, 2);
    smallMonsters[1] = new Monster("Scary Bears", 40, 20, 0, 10, 1, 15, 1);
    smallMonsters[2] = new Monster("Angry Owls", 45, 5, 5, 10, 1, 15, 3);

    Random rand = new Random();
    final Monster smallMonster = smallMonsters[rand.nextInt(3)];
    return smallMonster;
  }
  
  /** Returns medium Monsters. */
  public Monster medMonsters() {
    Monster[] mediumMonsters = new Monster[3];
    mediumMonsters[0] = new Monster("Archers", 60, 30, 10, 13, 3, 30, 2);
    mediumMonsters[1] = new Monster("Armored Bandits", 65, 20, 20, 12, 3, 35, 1);
    mediumMonsters[2] = new Monster("Wizard Apprentices", 70, 15, 5, 12, 3, 30, 3);

    Random rand = new Random();
    final Monster mediumMonster = mediumMonsters[rand.nextInt(3)];
    return mediumMonster;
  }
  
  /** Returns big Monsters. */
  public Monster bigMonsters() {
    Monster[] bigMonsters = new Monster[3];
    bigMonsters[0] = new Monster("Knights", 130, 30, 20, 15, 10, 50, 1);
    bigMonsters[1] = new Monster("Wizards", 140, 10, 10, 16, 10, 45, 3);
    bigMonsters[2] = new Monster("Fat Armored Tanks", 200, 10, 30, 16, 10, 60, 2);

    Random rand = new Random();
    final Monster bigMonster = bigMonsters[rand.nextInt(3)];
    return bigMonster;
  }
}
