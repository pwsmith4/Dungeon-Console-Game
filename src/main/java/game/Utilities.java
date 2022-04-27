package game;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that contains utility methods.
 * This is used to simplify methods and blocks of code.
 * 
 * @author pwsmith4
 **/
public class Utilities {

  /**
   * This method does a roll to simulate monster AI.
   **/
  public static int randomRoll() {
    Random rand = new Random();
    int rolledChoice = rand.nextInt(2);
    return rolledChoice;
  }

  /**
   * Prompts the user to continue.
   **/
  public static void enterPrompt() {
    System.out.println("<Press Enter to continue>");
    Scanner prompt = new Scanner(System.in);
    String throwAway = prompt.nextLine();
  }

  /**
   * Prompts a user to choose an action.
   **/
  public static int actionPrompt(String playerName) {
    Scanner prompt = new Scanner(System.in);
    System.out.println();
    System.out.println(playerName + ", action?\n");
    System.out.println("1. Attack | 2. Defend | 3. Heal"
        + " | 4. Special Skill | 5. Items \n");
    int choice = prompt.nextInt();
    return choice;
  }

  /**
   * Displays the user Special Skill Information.
   **/
  public static int skillPrompt(Character playerName) {
    System.out.println();
    System.out.println(playerName.getName() + ", Special Skill: ");
    System.out.print("1. " + playerName.getSkillName());
    if (playerName.currSkillCooldown() == 0) {
      System.out.println(" (Cooldown Timer: " + playerName.skillCooldown() + " Turns)");
    }
    if (playerName.currSkillCooldown() > 0) {
      System.out.println(" (On Cooldown! " + playerName.currSkillCooldown() + " Turns Remaining)");
    }

    System.out.print("2. " + playerName.getStrikeSkillName());
    if (playerName.currStrikeSkillCooldown() == 0) {
      System.out.println(" (Cooldown Timer: " + playerName.getStrikeSkillCooldown() + " Turns)");
    }
    if (playerName.currStrikeSkillCooldown() > 0) {
      System.out.println(" (On Cooldown! " 
          + playerName.currStrikeSkillCooldown() + " Turns Remaining)");
    }

    System.out.println("3. Back.");
    Scanner prompt = new Scanner(System.in);
    int choice = prompt.nextInt();
    return choice;
  }

  /**
   * Prompts a user to choose an item.
   **/
  public static int itemPrompt(Character playerName) {
    Scanner prompt = new Scanner(System.in);
    System.out.println();
    System.out.println(playerName.getName() + ", items:\n");
    System.out.println("1. Use Potion. Num Potions = (" + playerName.getPotions() + ")");
    System.out.println("2. Use Spell. Num spells = (" + playerName.getSpells() + ")");
    System.out.println("3. Back.");
    int choice = prompt.nextInt();
    return choice;
  }

  /**
   * Prints out shop options.
   */
  public static void shopInfo(Character playerName) {
    Random rand = new Random();
    Equipment equip = new Equipment();
    Boots boots = new Boots();
    Helmet helmet = new Helmet();
    Sword sword = new Sword();
    Boolean ifBoots = false;
    Boolean ifSword = false;
    Boolean ifHelmet = false;
    Boolean ifPotion = false;
    Boolean ifSpell = false;

    int threeItems = 0;
    int random = 0;
    while (threeItems < 3) {
      random = rand.nextInt(100);
      if (random <= 20 && ifBoots == false) {
        boots = equip.getNewBoots();
        threeItems++;
        ifBoots = true;
      }
      if (random > 20 && random <= 40 && ifHelmet == false) {
        helmet = equip.getNewHelmet();
        threeItems++;
        ifHelmet = true;
      }
      if (random > 40 && random <= 60 && ifSword == false) {
        sword = equip.getNewSword();
        threeItems++;
        ifSword = true;
      }
      if (random > 80 && random <= 80 && ifPotion == false) {
        ifPotion = true;
        threeItems++;
      }
      if (random > 80 && ifSpell == false) {
        ifSpell = true;
        threeItems++;
      }
    }
    int itemNumber = 1;

    int item1 = 0; // 1 for Boots, 2 for Sword, 3 for Helmet, 4 for Potion, 5 for Spell
    int item2 = 0;
    int item3 = 0;
    Boolean printed2 = false;
    Boolean printed3 = false;
    String playerGold = "\n" + playerName.getName()
        + ", Gold: " + playerName.getGold() + "\n";
    String printItem1 = "";
    String printItem2 = "";
    String printItem3 = "";

    Scanner prompt = new Scanner(System.in);

    /** Shop Options. */
    System.out.println(playerGold);
    System.out.print("1. ");

    if (ifBoots) {
      printItem1 = boots.getName() + ". Cost = " + boots.getCost() 
          + ". (Current Player Boots = " + playerName.getBoots().getName() + ")";
      System.out.println(printItem1);
      itemNumber++;
      item1 = 1;
    }
    if (itemNumber == 2) {
      System.out.print("2. ");
      printed2 = true;
    }
    if (itemNumber == 3) {
      System.out.print("3. ");
      printed3 = true;
    }
    if (ifSword) {
      itemNumber++;
      if (item1 == 1) {
        item2 = 2;
        printItem2 = sword.getName() + ". Cost = " + sword.getCost()
            + ". (Current Player Sword = " + playerName.getSword().getName() + ")";
        System.out.println(printItem2);
      } else {
        item1 = 2;
        printItem1 = sword.getName() + ". Cost = " + sword.getCost() 
            + ". (Current Player Sword = " + playerName.getSword().getName() + ")";
        System.out.println(printItem1);
      }
    }
    if (itemNumber == 2 && printed2 == false) {
      System.out.print("2. ");
      printed2 = true;
    }
    if (itemNumber == 3 && printed3 == false) {
      System.out.print("3. ");
      printed3 = true;
    }
    if (ifHelmet) {
      itemNumber++;
      if (item1 != 0) {
        if (item2 != 0) {
          item3 = 3;
          printItem3 = helmet.getName() + ". Cost = " + helmet.getCost() 
              + ". (Current Player Helmet = " + playerName.getHelmet().getName() + ")";
          System.out.println(printItem3);
        } else {
          item2 = 3;
          printItem2 = helmet.getName() + ". Cost = " + helmet.getCost() 
              + ". (Current Player Helmet = " + playerName.getHelmet().getName() + ")";
          System.out.println(printItem2);
        }
      } else {
        item1 = 3;
        printItem1 = helmet.getName() + ". Cost = " + helmet.getCost() 
            + ". (Current Player Helmet = " + playerName.getHelmet().getName() + ")";
        System.out.println(printItem1);
      }
    }
    if (itemNumber == 2 && printed2 == false) {
      System.out.print("2. ");
      printed2 = true;
    }
    if (itemNumber == 3 && printed3 == false) {
      System.out.print("3. ");
      printed3 = true;
    }
    if (ifPotion) {
      itemNumber++;
      if (item1 != 0) {
        if (item2 != 0) {
          printItem3 = "Health Potion. Cost = 2. "
              + "(Current Number of Potions = " + playerName.getPotions() + ")";
          System.out.println(printItem3);
          item3 = 4;
        } else {
          printItem2 = "Health Potion. Cost = 2. "
              + "(Current Number of Potions = " + playerName.getPotions() + ")";
          System.out.println(printItem2);
          item2 = 4;
        }
      } else {
        printItem1 = "Health Potion. Cost = 2."
              + " (Current Number of Potions = " + playerName.getPotions() + ")";
        System.out.println(printItem1);
        item1 = 4;
      }
    }
    if (itemNumber == 2 && printed2 == false) {
      System.out.print("2. ");
      printed2 = true;
    }
    if (itemNumber == 3 && printed3 == false) {
      System.out.print("3. ");
      printed3 = true;
    }
    if (ifSpell) {
      itemNumber++;
      if (item1 != 0) {
        if (item2 != 0) {
          printItem3 = "Damage Spell. Cost = 3."
              + " (Current Number of Spells = " + playerName.getSpells() + ")";
          System.out.println(printItem3);
          item3 = 5;
        } else {
          printItem2 = "Damage Spell. Cost = 3. "
              + "(Current Number of Spells = " + playerName.getSpells() + ")";
          System.out.println(printItem2);
          item2 = 5;
        }
      } else {
        printItem1 = "Damage Spell. Cost = 3. "
            + "(Current Number of Spells = " + playerName.getSpells() + ")";
        System.out.println(printItem1);
        item1 = 5;
      }
    }
    
    String leaveShop = "Leave Shop.";

    System.out.println("4. " + leaveShop + "\n");
    String totalShop = ("1. " + printItem1 + "\n2. " 
        + printItem2 + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

    int choice = 0;
    Boolean exit = false;

    while (exit == false) {
      choice = prompt.nextInt();

      //Choice for Boots
      if (choice == 1 && item1 == 1) {
        if (playerName.getGold() < boots.getCost()) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          if (playerName.getBoots().getSpeed() >= boots.getSpeed()) {
            System.out.println("These new Boots aren't"
                + " better than what you already have!\n");
            System.out.println(totalShop);
          } else {
            playerName.removeGold(boots.getCost());
            playerName.setBoots(boots);
            System.out.println("New Boots Added.");
            System.out.println("New Character Gold: " + playerName.getGold() + "\n");
            printItem1 = boots.getName() + ". Cost = " + boots.getCost()
                + ". (Current Player Boots = " + playerName.getBoots().getName() + ")";
            totalShop = ("1. " + printItem1 + "\n2. " + printItem2
                + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");
            System.out.println(totalShop);
          }
        }
      }
      //Choice for Sword
      if (choice == 1 && item1 == 2) {
        if (playerName.getGold() < sword.getCost()) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          if (playerName.getSword().getDamage() >= sword.getDamage()) {
            System.out.println("This new Sword isn't better than what you already have!\n");
            System.out.println(totalShop);
          } else {
            playerName.setSword(sword);
            playerName.removeGold(sword.getCost());
            System.out.println("New Sword Added.");
            System.out.println("New Character Gold: " + playerName.getGold() + "\n");
            printItem1 = sword.getName() + ". Cost = " + sword.getCost()
                + ". (Current Player Sword = " + playerName.getSword().getName() + ")";
            totalShop = ("1. " + printItem1 + "\n2. " + printItem2 
                + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

            System.out.println(totalShop);
          }
        }
      }
      //Choice for Helmet
      if (choice == 1 && item1 == 3) {
        if (playerName.getGold() < helmet.getCost()) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          if (playerName.getHelmet().getHp() >= helmet.getHp()) {
            System.out.println("This new Helmet isn't better than what you already have!\n");
            System.out.println(totalShop);
          } else {
            playerName.setHelmet(helmet);
            playerName.removeGold(helmet.getCost());
            System.out.println("New Helmet Added.");
            System.out.println("New Character Gold: " + playerName.getGold() + "\n");
            printItem1 = helmet.getName() + ". Cost = " + helmet.getCost() 
                + ". (Current Player Helmet = " + playerName.getHelmet().getName() + ")";
            totalShop = ("1. " + printItem1 + "\n2. " + printItem2
                + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

            System.out.println(totalShop);
          }
        }
      }
      //Choice for Potion
      if (choice == 1 && item1 == 4) {
        if (playerName.getGold() < 2) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          playerName.addPotion();
          System.out.println("New Number of Character Potions: " + playerName.getPotions());
          playerName.removeGold(2);
          System.out.println("New Character Gold: " + playerName.getGold() + "\n");
          printItem1 = "Health Potion. Cost = 2."
              + " (Current Number of Potions = " + playerName.getPotions() + ")";
          totalShop = ("1. " + printItem1 + "\n2. " 
              + printItem2 + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

          System.out.println(totalShop);
        }
      }

      //Choice for Spell
      if (choice == 1 && item1 == 5) {
        if (playerName.getGold() < 3) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          playerName.addSpell();
          System.out.println("New Number of Character Spells: " + playerName.getPotions());
          playerName.removeGold(3);
          System.out.println("New Character Gold: " + playerName.getGold() + "\n");
          printItem1 = "Damage Spell. Cost = 3. "
              + "(Current Number of Spells = " + playerName.getSpells() + ")";
          totalShop = ("1. " + printItem1 + "\n2. "
              + printItem2 + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

          System.out.println(totalShop);
        }
      }
      //Choice for Boots
      if (choice == 2 && item2 == 1) {
        if (playerName.getGold() < boots.getCost()) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          if (playerName.getBoots().getSpeed() >= boots.getSpeed()) {
            System.out.println("These new Boots aren't better than what you already have!\n");
            System.out.println(totalShop);
          } else {
            playerName.setBoots(boots);
            playerName.removeGold(boots.getCost());
            System.out.println("New Boots Added.");
            System.out.println("New Character Gold: " + playerName.getGold() + "\n");
            printItem2 = boots.getName() + ". Cost = " + boots.getCost()
                + ". (Current Player Boots = " + playerName.getBoots().getName() + ")";
            totalShop = ("1. " + printItem1 + "\n2. " + printItem2 
                + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

            System.out.println(totalShop);
          }
        }
      }
      //Choice for Sword
      if (choice == 2 && item2 == 2) {
        if (playerName.getGold() < sword.getCost()) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          if (playerName.getSword().getDamage() >= sword.getDamage()) {
            System.out.println("This new Sword isn't better than what you already have!\n");
            System.out.println(totalShop);
          } else {
            playerName.setSword(sword);
            playerName.removeGold(sword.getCost());
            System.out.println("New Sword Added.");
            System.out.println("New Character Gold: " + playerName.getGold() + "\n");
            printItem2 = sword.getName() + ". Cost = " + sword.getCost()
                + ". (Current Player Sword = " + playerName.getSword().getName() + ")";
            totalShop = ("1. " + printItem1 + "\n2. "
                + printItem2 + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

            System.out.println(totalShop);
          }
        }
      }

      //Choice for Helmet
      if (choice == 2 && item2 == 3) {
        if (playerName.getGold() < helmet.getCost()) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          if (playerName.getHelmet().getHp() >= helmet.getHp()) {
            System.out.println("This new Helmet isn't better than what you already have!\n");
            System.out.println(totalShop);
          } else {
            playerName.setHelmet(helmet);
            playerName.removeGold(helmet.getCost());
            System.out.println("New Helmet Added.");
            System.out.println("New Character Gold: " + playerName.getGold() + "\n");
            printItem2 = helmet.getName() + ". Cost = " + helmet.getCost()
                + ". (Current Player Helmet = " + playerName.getHelmet().getName() + ")";
            totalShop = ("1. " + printItem1 + "\n2. " + printItem2 
                + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

            System.out.println(totalShop);
          }
        }
      }

      //Choice for Potion
      if (choice == 2 && item2 == 4) {
        if (playerName.getGold() < 2) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          playerName.addPotion();
          System.out.println("New Number of Character Potions: " + playerName.getPotions());
          playerName.removeGold(2);
          System.out.println("New Character Gold: " + playerName.getGold() + "\n");
          printItem2 = "Health Potion. Cost = 2. "
              + "(Current Number of Potions = " + playerName.getPotions() + ")";
          totalShop = ("1. " + printItem1 + "\n2. " 
              + printItem2 + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

          System.out.println(totalShop);
        }
      }

      //Choice for Spell
      if (choice == 2 && item2 == 5) {
        if (playerName.getGold() < 3) {
          System.out.println("You don't have enough gold!");
          System.out.println(totalShop);
        } else {
          playerName.addSpell();
          System.out.println("New Number of Character Spells: " + playerName.getSpells());
          playerName.removeGold(3);
          System.out.println("New Character Gold: " + playerName.getGold() + "\n");
          printItem2 = "Damage Spell. Cost = 3. "
              + "(Current Number of Spells = " + playerName.getSpells() + ")";
          totalShop = ("1. " + printItem1 + "\n2. " 
              + printItem2 + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

          System.out.println(totalShop);
        }
      }

      //Choice for Boots
      if (choice == 3 && item3 == 1) {
        if (playerName.getGold() < boots.getCost()) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          if (playerName.getBoots().getSpeed() >= boots.getSpeed()) {
            System.out.println("These new Boots aren't better than what you already have!\n");
            System.out.println(totalShop);
          } else {
            playerName.setBoots(boots);
            playerName.removeGold(boots.getCost());
            System.out.println("New Boots Added.");
            System.out.println("New Character Gold: " + playerName.getGold() + "\n");
            printItem3 = boots.getName() + ". Cost = " + boots.getCost()
                + ". (Current Player Boots = " + playerName.getBoots().getName() + ")";
            totalShop = ("1. " + printItem1 + "\n2. " + printItem2
                + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

            System.out.println(totalShop);
          }
        }
      }

      //Choice for Sword
      if (choice == 3 && item3 == 2) {
        if (playerName.getGold() < sword.getCost()) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          if (playerName.getSword().getDamage() >= sword.getDamage()) {
            System.out.println("This new Sword isn't better than what you already have!\n");
            System.out.println(totalShop);
          } else {
            playerName.setSword(sword);
            playerName.removeGold(sword.getCost());
            System.out.println("New Sword Added.");
            System.out.println("New Character Gold: " + playerName.getGold() + "\n");
            printItem3 = sword.getName() + ". Cost = " + sword.getCost()
                + ". (Current Player Sword = " + playerName.getSword().getName() + ")";
            totalShop = ("1. " + printItem1 + "\n2. " + printItem2 
                + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

            System.out.println(totalShop);
          }
        }
      }

      //Choice for Helmet
      if (choice == 3 && item3 == 3) {
        if (playerName.getGold() < helmet.getCost()) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          if (playerName.getHelmet().getHp() >= helmet.getHp()) {
            System.out.println("This new Helmet isn't better than what you already have!\n");
            System.out.println(totalShop);
          } else {
            playerName.setHelmet(helmet);
            playerName.removeGold(helmet.getCost());
            System.out.println("New Helmet Added.");
            System.out.println("New Character Gold: " + playerName.getGold() + "\n");
            printItem3 = helmet.getName() + ". Cost = " + helmet.getCost() 
                + ". (Current Player Helmet = " + playerName.getHelmet().getName() + ")";
            totalShop = ("1. " + printItem1 + "\n2. " + printItem2 
                + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

            System.out.println(totalShop);
          }
        }
      }

      //Choice for Potion
      if (choice == 3 && item3 == 4) {
        if (playerName.getGold() < 2) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          playerName.addPotion();
          System.out.println("New Number of Character Potions: " + playerName.getPotions());
          playerName.removeGold(2);
          System.out.println("New Character Gold: " + playerName.getGold() + "\n");
          printItem3 = "Health Potion. Cost = 2. "
              + "(Current Number of Potions = " + playerName.getPotions() + ")";
          totalShop = ("1. " + printItem1 + "\n2. " + printItem2 
              + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

          System.out.println(totalShop);
        }
      }

      //Choice for Spell
      if (choice == 3 && item3 == 5) {
        if (playerName.getGold() < 3) {
          System.out.println("You don't have enough gold!\n");
          System.out.println(totalShop);
        } else {
          playerName.addSpell();
          System.out.println("New Number of Character Spells: " + playerName.getSpells());
          playerName.removeGold(3);
          System.out.println("New Character Gold: " + playerName.getGold() + "\n");
          printItem3 = "Damage Spell. Cost = 3."
              + " (Current Number of Spells = " + playerName.getSpells() + ")";
          totalShop = ("1. " + printItem1 + "\n2. " + printItem2 
              + "\n3. " + printItem3 + "\n4. " + leaveShop + "\n");

          System.out.println(totalShop);
        }
      }

      //Leave Shop
      if (choice == 4) {
        exit = true;
        return;
      }
    }


    return;
  }

  /**
   * Method to print out character Statistics.
   **/
  public static void characterInfo(Character character) {
    System.out.println("\nParty member: " + character.getName() + "."
        + "\n HP: " + character.getHp()
        + "\n Attack: " + character.getAtk()
        + "\n Defense: " + character.getDef()
        + "\n Speed: " + character.getSpeed());
    System.out.println();
  }

  /**
   * Method to print out Monster statistics.
   **/
  public static void monsterInfo(Monster monster) {
    System.out.println("\n" + monster.getName() + "."
        + "\n HP: " + monster.getHp()
        + "\n Attack: " + monster.getAtk()
        + "\n Defense: " + monster.getDef()
        + "\n Speed: " + monster.getSpeed());
    System.out.println();
  }

  /**
   * This class contains usable changes to text color and style.
   *
   * @author pwsmith4
   *
   **/
  public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
  }
}
