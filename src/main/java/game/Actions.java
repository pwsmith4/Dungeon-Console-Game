package game;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that contains action methods.
 *
 * @author pwsmith4
 */
public class Actions {

  /**
   * Randomly generates a number and the given max number (inclusive).
   */
  public static int roll(int maxValue) {
    Random rand = new Random();
    int randomNumber = rand.nextInt(maxValue + 1);
    return randomNumber;
  }

  /**
   * Simplified damage dealing method.
   * This is used to deal damage.
   **/
  public static int dealDamage(int damage, int hitPoints, int defense, Character char1) {
    int damageDone = 0;
    damageDone = damage - defense;
    if (damage - defense <= 0) {
      damageDone = 1;
    }
    Random rand = new Random();
    int random = rand.nextInt(100) + 1;

    //5 percent chance any attack will miss
    //15 percent dodge chance if you are a Human
    // 5 percent higher miss chance for second event
    if (char1.getRaceType() == 3 && char1.event() == 2) {
      if (random <= 20) {
        damageDone = 0;
      }
    } else if (char1.getRaceType() == 3) {
      if (random <= 15) {
        damageDone = 0;
      }
    } else if (random <= 5) {
      damageDone = 0;
    }

    // 10 percent chance to critically strike if you are an Orc
    if (char1.getRaceClass() == 2 && (char1.currSkillCooldown() == char1.skillCooldown())) {
      if (char1.event() == 1) {
        damageDone = damageDone * 2 - 5;
      } else {
        damageDone = damageDone * 2;
      }
      System.out.println("\nCritical Strike using Guaranteed Crit Chance!");
    } else if (char1.getRaceType() == 2) {
      if (random > 5 && random <= 15) {
        if (char1.event() == 1) {
          damageDone = damageDone * 2 - 5;
        } else {
          damageDone = damageDone * 2;
        }
        System.out.println("\nCritical Strike!");
      }
    } else {
      //5 percent chance to critically strike if you are not an Orc
      if (random > 5 && random <= 10) {
        if (char1.event() == 1) {
          damageDone = damageDone * 2 - 5;
        } else {
          damageDone = damageDone * 2;
        }
        System.out.println("\nCritical Strike!");
      }
    }
    hitPoints -= (damageDone);
    if (hitPoints <= 0) {
      hitPoints = 0;
    }
    return hitPoints;
  }

  /**
   * Heals a desired target.
   **/
  public static void healTarget(Character player, int healing) {
    int targetHp = player.getHp();
    targetHp += healing;
    player.setHp(targetHp);

  }

  /**
   * Returns the attack value.
   */
  public static int attack(int attValue) {
    int attFinal = attValue + roll(20);
    return attFinal;
  }

  /**
   * Returns the heal value.
   */
  public static int healAmount(int healValue) {
    int healFinal = healValue / 2 + roll(8); // Testing for rounded div.
    return healFinal;
  }

}
