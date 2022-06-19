package game;

import java.util.Random;
import java.util.Scanner;
 
public class RunningRounds {

  /**
   * This is the main entry point to game.
   * This class will establish characters and monsters.
   * and will use other classes to run the game.
   * Character selection will be run in this method as well.
   *
   * @author Parker Smith
   *
   */
  private static int raceType = 0;
  private static int classType = 0;
  
  /** Sets the kind of character. */
  public static Character setCharacter(int raceT, int classT) {

    // Opens game and takes team name.
    GameMethods.startGame();

    // Character selection in three brackets of character professions.
    Boolean errorGiven = false;
    Characters players = new Characters();
    Character char1 = new Character(null, 0, 0, 0, 0, 0, 0);

    System.out.println("What kind of Class do you want to play as?"
        + " \n1. Wizard\n2. Fighter\n3. Rogue");
    System.out.println("Wizard has a Drain Spell, Fighter has"
        + " a guaranteed crit hit, and Rogue has a backstab attack.\n");
    classType = classT;
    Boolean classChosen = false;
      
    while (!classChosen) {
      if (classType == 1) {
        classChosen = true;
      } else if (classType == 2) {
        classChosen = true;
      } else if (classType == 3) {
        classChosen = true;
      } else {
        if (!errorGiven) {
          System.out.println("Please choose a number between "
              + "1 and 3 to choose a class.");
          errorGiven = true;
        }
      }
    }

    System.out.println("What kind of Race do you want to play as?"
        + " \n1. Elf\n2. Orc\n3. Human");
    System.out.println("Elf has chance to craft spells, "
        + "Orc has a higher crit chance, and Human has a higher dodge chance\n");
    Boolean raceChosen = false;

    while (!raceChosen) {
      raceType = raceT;
      if (raceType == 1) {
        if (classType == 1) {
          char1 = players.characters1(raceType);
        } else if (classType == 2) {
          char1 = players.characters2(raceType);
        } else {
          char1 = players.characters3(raceType);
        }
        raceChosen = true;
      } else if (raceType == 2) {
        if (classType == 1) {
          char1 = players.characters1(raceType);
        } else if (classType == 2) {
          char1 = players.characters2(raceType);
        } else {
          char1 = players.characters3(raceType);
        }
        raceChosen = true;
      } else if (raceType == 3) {
        if (classType == 1) {
          char1 = players.characters1(raceType);
        } else if (classType == 2) {
          char1 = players.characters2(raceType);
        } else {
          char1 = players.characters3(raceType);
        }
        raceChosen = true;
      } else {
        if (!errorGiven) {
          System.out.println("Please choose a number between 1 and 3 to choose a race.");
          errorGiven = true;
        }
      }
    }

    char1.setStrikeSkillName("No Strike Skill Yet...");
    char1.setStrikeSkillCooldown(0);
    return char1;
  }
  
  /** Runs the beginning of the program. */
  public static void main(String[] args) {
    Random rand = new Random();
    raceType = rand.nextInt(3) + 1;
    classType = rand.nextInt(3) + 1;
    Character char1 = setCharacter(raceType, classType);
    int floorsPassed = 0;
    int eventNumber = 1;

    boolean char1Alive = true;
    
    // Tells player their party and stats.
    System.out.println();
    System.out.println("YOUR PARTY:");
    // Refer to LegacyCode.md for original implementation.
    Utilities.characterInfo(char1);

    // Sets up narrative using input name and characters.
    // Actions.startGame needs to be fixed otherwise name value is lost.
    int floorLevel = 1;
    Monsters monster = new Monsters();

    while (char1.getHp() != 0) {
      if (floorLevel == 11) {
        System.out.println("You Got to the top. Congrats!");
        return;
      }
      if (char1.getMaxHp() * .15 > char1.getHp()) {
        GameMethods.topFloor(char1);
        floorLevel = 1;
      }
      System.out.println("\nFloor Level: " + floorLevel + "\n");
      if (eventNumber == 1 && floorsPassed == 0) {
        char1.setEvent(1);
        System.out.println("EVENT: 5 Less physical damage. Will last for 4 levels!\n");
      }
      if (eventNumber == 2 && floorsPassed == 0) {
        char1.setEvent(2);
        System.out.println("EVENT: 5% higher miss chance. Will last for 4 levels!\n");
      }
      if (eventNumber == 3 && floorsPassed == 0) {
        char1.setEvent(3);
        System.out.println("EVENT: Gain extra gold after "
            + "defeating an enemy. Will last for 4 levels!\n");
      }
      if (eventNumber == 4 && floorsPassed == 0) {
        char1.setEvent(4);
        System.out.println("EVENT: Gain extra XP after defeating an enemy!\n");
      }

      if (floorLevel % 5 != 0) {
        Monster smallMonster = monster.smallMonsters();
        GameMethods.smallEncounter(smallMonster);  
        Utilities.characterInfo(char1);
        GameMethods.encounterInfo(smallMonster);
        char1Alive = GameMethods.combatRun(char1, smallMonster);
      }

      if (floorLevel % 5 == 0 && floorLevel % 10 != 0) {
        Monster medMonster = monster.medMonsters();
        GameMethods.mediumEncounter(medMonster);
        Utilities.characterInfo(char1);
        GameMethods.encounterInfo(medMonster);
        char1Alive = GameMethods.combatRun(char1, medMonster);
      }
      if (floorLevel % 5 == 0 && floorLevel % 10 == 0) {
        Monster bigMonster = monster.bigMonsters();
        GameMethods.bigEncounter(bigMonster);
        Utilities.characterInfo(char1);
        GameMethods.encounterInfo(bigMonster);
        char1Alive = GameMethods.combatRun(char1, bigMonster);
      }
      floorLevel++;

      /** 20% Chance that a chest with an Item is found
       * after finishing a level and another 20% chance
       * you make a spell if you are a wizard class
       */
      if (char1Alive) {
        int chance = rand.nextInt(100) + 1;
        if (rand.nextInt(100) <= 20) {
          GameMethods.chest(char1);
        } else if (chance < 40) {
          GameMethods.shop(char1);
        } else if (char1.getRaceType() == 1) {
          if (chance < 60) {
            System.out.println("As an Elf, you crafted a new Spell!");
            System.out.println("New Amount of Spells: " + char1.getSpells());
            char1.addSpell();
          }
        }
      }
      if (char1Alive == false) {
        System.out.println("You lost " + char1.getGold() / 2 + " Gold...");
        char1.removeGold((int) Math.floor(char1.getGold()) / 2);
        System.out.println("You're current gold is now: " + char1.getGold());

        GameMethods.topFloor(char1);
        floorLevel = 1;
      }
      if (floorsPassed == 4) {
        floorsPassed = 0;
        if (eventNumber == 4) {
          eventNumber = 1;
        } else {
          eventNumber++;
        }
      } else {
        floorsPassed++;
      }
    }
  }
}
