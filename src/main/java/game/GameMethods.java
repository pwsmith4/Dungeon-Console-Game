package game;

import java.util.Random;

/**
 * This class is used to store narrative material.
 * 
 * @author pwsmith4
 **/
public class GameMethods {
  // Colors for dynamic and fun output.
  public static final String RESET = "\033[0m";  // Text Reset
  public static final String RED = "\033[0;31m";     // RED
  public static final String GREEN = "\033[0;32m";   // GREEN
  public static final String YELLOW = "\033[0;33m";  // YELLOW
  public static final String BLUE = "\033[0;34m";    // BLUE
  public static final String PURPLE = "\033[0;35m";  // PURPLE
  public static final String WHITE = "\033[0;37m";   // WHITE

  /**
   * Initial story and asks for team name.
   */
  public static void startGame() {
    System.out.println(WHITE + "Greetings, brave adventurer!"
        + "\nYou are about to embark on a quest to defeat the king."
        + "\nThis venture, however, is not for the faint of heart."
        + "\nIf you are brave enough to begin, please enter your name.\n");
    String teamName = "Brave Knight";
    System.out.println("\nGood luck, " + teamName + "." + RESET);
  }

  /** Resets Health and uses Experience at the top floor. */
  public static void topFloor(Character char1) {

    System.out.println(WHITE + "\nAt Top Floor. Character level was: " + char1.getLevel() );
    System.out.println(WHITE + "\nCharacter XP was: " + char1.getXp() );

    int xp = char1.getXp();
    int xpCap = char1.getXpCap();
    int currentLevel = char1.getLevel();
    int calcLevelCap = 10 * 2 * currentLevel + xpCap;
    Boolean strikeSkillUpgrade = false;

    System.out.println(WHITE + "\nXP needed to level up: " + calcLevelCap);

    while (calcLevelCap < xp) {
      char1.setLevel(currentLevel++);
      if (char1.getLevel() == 1) {
        char1.addStrikeSkill();
        char1.setStrikeSkillName("Strike");
        char1.setStrikeSkillCooldown(3);
        strikeSkillUpgrade = true;
      }
      if (char1.getLevel() == 3) {
        char1.addStrikeSkill();
        char1.setStrikeSkillName("Double Strike");
        char1.setStrikeSkillCooldown(4);
        strikeSkillUpgrade = true;
      }
      if (char1.getLevel() == 5) {
        char1.addStrikeSkill();
        char1.setStrikeSkillName("Triple Strike");
        char1.setStrikeSkillCooldown(5);
        strikeSkillUpgrade = true;
      }
      char1.setXpCap(calcLevelCap);
      char1.setXp(xp - calcLevelCap);
      calcLevelCap = 10 * 2 * currentLevel + xpCap;
    }

    char1.setHp(char1.getMaxHp());
    System.out.println(WHITE + "\nNew Character level is: " + char1.getLevel() );
    System.out.println(WHITE + "\nXP leftover: " + char1.getXp() + "\n");

    if (strikeSkillUpgrade) {
      System.out.println("You unlocked the special skill: " + char1.getStrikeSkillName());
      strikeSkillUpgrade = false;   
    }
  }

  /** Displays information for small Monsters. */
  public static void smallEncounter(Monster monster) {
    System.out.println(WHITE + "Your party has been journeying along the main road when "
        + " \nthey notice smoke over a nearby hill.");
    Utilities.enterPrompt();
    System.out.println(WHITE + "There is a group of " + GREEN + monster.getName() + WHITE 
        + " that have noticed you.\nBefore you can hide, they notice you and attack." + RESET);
    Utilities.enterPrompt();
  }

  /** Displays information for medium Monsters. */
  public static void mediumEncounter(Monster monster) {
    System.out.println(WHITE + "Your party runs into a checkpoint when "
        + " \nthey notice something is blocking their path.");
    Utilities.enterPrompt();
    System.out.println(WHITE + "There is a group of " + GREEN + monster.getName() 
        + WHITE + " that have noticed you."
        + " \nBefore you can hide, they notice you and attack." + RESET);
    Utilities.enterPrompt();
  }

  /** Displays information for big Monsters. */
  public static void bigEncounter(Monster monster) {
    System.out.println(WHITE + "Your party runs into a big castle when "
        + " \nthey notice something is waiting for them.");
    Utilities.enterPrompt();
    System.out.println(WHITE + "There is a group of " + GREEN + monster.getName() 
        + WHITE + " that have noticed you."
        + " \nBefore you can hide, they notice you and attack." + RESET);
    Utilities.enterPrompt();
  }

  /**
   * Method that displays monster information.
   **/
  public static void encounterInfo(Monster monster) {
    System.out.println(WHITE + "You will be fighting " + GREEN 
        + monster.getName() + WHITE + ".");
    System.out.println();
    System.out.println(WHITE + "HP: " + GREEN +  monster.getHp());
    System.out.println(WHITE + "Attack: " + GREEN + monster.getAtk());
    System.out.println(WHITE + "Defense: " + GREEN + monster.getDef());
    System.out.println(WHITE + "Speed: " + GREEN + monster.getSpeed() + RESET);
  }

  /**
   * This method is used for each monster encounter, running turns effectively.
   * Return false if Character was defeated,
   * and true if Character defeated the monster.
   **/
  public static boolean combatRun(Character char1, Monster monst1) {
    // Establishes parameters for loop runtime.
    boolean char1Alive = true;
    boolean monstAlive = true;
    int roundCount = 1;

    // This block initializes multiple used values.
    int char1Defense = 0;
    int monst1Defense = 0;
    int monsterDamage = 0;
    int damage = 0;
    int choice = 0;
    int itemChoice = 0;
    int skillChoice = 0;
    int charSpeed = 0;
    int monstSpeed = 0;
    boolean charTurn = false;
    boolean inItemChoice = false;
    boolean inSkillChoice = false;
    boolean determined = false;
    Random rand = new Random();

    // This block defaults healing and heal targets to none.
    int healing = 0;
    int oldHealth = 0;
    int newHealth = 0;

    //Compare speed to see who goes first
    charSpeed = char1.getSpeed();   //Ex. 20
    monstSpeed = monst1.getSpeed(); //Ex. 10

    // Loop for fight 1. TODONE: Finish loop implementation.
    while ((char1Alive == true) && monstAlive == true) {
      if (charSpeed >= monstSpeed) {
        charTurn = true;
      }
      if (char1Alive == true && monstAlive == true) {
        if (char1.getStatus() == 1 && char1.statusCooldown() != 0) {
          System.out.println("You were Paralyzed! " + char1.statusCooldown() 
              + " Turns remaining.");  
          char1.turnUsed();
          charTurn = false;
        } else if (char1.getStatus() == 2 && char1.statusCooldown() != 0) {
          System.out.println("You were Burned! You will take 3 extra damage. "
              + char1.statusCooldown() + " Turns remaining.");   
        } else if (char1.getStatus() == 3 && char1.statusCooldown() != 0) {
          System.out.println("You were Injured! You will do 3 less damage. " 
              + char1.statusCooldown() + " Turns remaining.");   
        }
        // turn 1 belongs to char1, 2 to char2 and so on.
        while (charTurn == true && char1.getHp() > 0) {

          choice = Utilities.actionPrompt(char1.getName());
          if (choice == 1) {
            // Rolls damage and subtracts it from monster health - defense.
            damage = Actions.attack(char1.getAtk());
            oldHealth = monst1.getHp();
            newHealth = Actions.dealDamage(damage, monst1.getHp(), monst1Defense, char1);

            if (oldHealth == newHealth) {
              System.out.println(WHITE + "\n" + char1.getName() + "'s attack missed!");
            } else {
              if (damage - monst1Defense < newHealth - oldHealth) {
                System.out.println("\nCritical Strike!\n");
              }
              if (char1.getStatus() == 3 && char1.statusCooldown() != 0) {
                damage -= 3;
                if (newHealth > 0) {
                  newHealth -= 3;
                }
                if (newHealth < 0) {
                  newHealth = 0;
                }
              }
              System.out.println(WHITE + "\nDid " + RED + damage 
                  + WHITE + " damage!\n" + RESET);                            
            }

            monst1.setHp(newHealth);

            charTurn = false;
          } else if (choice == 2) {
            // TODONE: Replace with new, better defend method.
            char1Defense = char1.getDef();
            System.out.println(WHITE + char1.getName() + " is defending!");
            charTurn = false;
          } else if (choice == 3) {
            // This should allow for healing.
            healing = Actions.healAmount(40);
            Actions.healTarget(char1, healing);
            System.out.println(WHITE + "\nHealed "
                + char1.getName() + " for " + healing + " points!\n" + RESET);
            charTurn = false;
          } else if (choice == 4) {
            inSkillChoice = true;
            while (inSkillChoice == true) {
              skillChoice = Utilities.skillPrompt(char1);
              if (skillChoice == 1) {
                if (char1.currSkillCooldown() == 0) {
                  char1.setCurrSkillCooldown();

                  if (char1.getRaceClass() == 1) {
                    damage = Actions.attack(char1.getAtk());
                    oldHealth = monst1.getHp();
                    newHealth = Actions.dealDamage(damage * 2 / 3,
                        monst1.getHp(), monst1Defense, char1);
                    if (oldHealth == newHealth) {
                      System.out.println(WHITE + "\n" + char1.getName() + "'s attack missed!");
                    } else {
                      if (damage * 2 / 3 - monst1Defense < newHealth - oldHealth) {
                        System.out.println("\nCritical Strike!\n");
                      }
                      if (char1.getStatus() == 3 && char1.statusCooldown() != 0) {
                        damage -= 3;
                        if (newHealth > 0) {
                          newHealth -= 3;
                        }
                        if (newHealth < 0) {
                          newHealth = 0;
                        }
                      }
                      System.out.println(WHITE + "\nDid " + RED + damage 
                          + WHITE + " damage!\n" + RESET);
                    }

                    monst1.setHp(newHealth);

                    healing = Actions.healAmount(30);
                    Actions.healTarget(char1, healing);
                    System.out.println(WHITE + "\nHealed "
                        + char1.getName() + " for " + healing + " points!\n" + RESET);
                    charTurn = false;
                    inSkillChoice = false;
                  }
                  if (char1.getRaceClass() == 2) {
                    damage = Actions.attack(char1.getAtk());
                    oldHealth = monst1.getHp();
                    newHealth = Actions.dealDamage(damage, monst1.getHp(), monst1Defense, char1);
                    if (oldHealth == newHealth) {
                      System.out.println(WHITE + "\n" + char1.getName() + "'s attack missed!");
                    } else {
                      if (damage - monst1Defense < newHealth - oldHealth) {
                        System.out.println("\nCritical Strike!\n");
                      }
                      if (char1.getStatus() == 3 && char1.statusCooldown() != 0) {
                        damage -= 3;
                        if (newHealth > 0) {
                          newHealth -= 3;
                        }
                        if (newHealth < 0) {
                          newHealth = 0;
                        }
                      }
                      System.out.println(WHITE + "\nDid " + RED + damage 
                          + WHITE + " damage!\n" + RESET);
                    }
                    charTurn = false;
                    monst1.setHp(newHealth);
                    inSkillChoice = false;
                  }
                  if (char1.getRaceClass() == 3) {
                    damage = Actions.attack(char1.getAtk());
                    oldHealth = monst1.getHp();
                    newHealth = Actions.dealDamage(damage * 2, monst1.getHp(),
                        monst1Defense, char1);
                    if (oldHealth == newHealth) {
                      System.out.println(WHITE + "\n" + char1.getName() + "'s attack missed!");
                    } else {
                      if (damage * 2 - monst1Defense < newHealth - oldHealth) {
                        System.out.println("\nCritical Strike!\n");
                      }
                      if (char1.getStatus() == 3 && char1.statusCooldown() != 0) {
                        damage -= 3;
                        if (newHealth > 0) {
                          newHealth -= 3;
                        }
                        if (newHealth < 0) {
                          newHealth = 0;
                        }
                      }
                      System.out.println("Double Damage from Backstab Attack!");
                      System.out.println(WHITE + "\nDid " + RED + damage 
                          + WHITE + " damage!\n" + RESET);
                    }
                    charTurn = false;
                    monst1.setHp(newHealth);
                    inSkillChoice = false;
                  }

                }
              } else if (skillChoice == 2) {

                if (char1.currStrikeSkillCooldown() == 0 && char1.getStrikeSkill() == 1) {
                  char1.resetStrikeSkillCooldown();
                  damage = Actions.attack(char1.getAtk());
                  oldHealth = monst1.getHp();
                  newHealth = Actions.dealDamage(damage * 3 / 2,
                      monst1.getHp(), monst1Defense, char1);
                  if (oldHealth == newHealth) {
                    System.out.println(WHITE + "\n" + char1.getName() + "'s attack missed!");
                  } else {
                    if (damage * 3 / 2 - monst1Defense < newHealth - oldHealth) {
                      System.out.println("\nCritical Strike!\n");
                    }
                    if (char1.getStatus() == 3 && char1.statusCooldown() != 0) {
                      damage -= 3;
                      if (newHealth > 0) {
                        newHealth -= 3;
                      }
                      if (newHealth < 0) {
                        newHealth = 0;
                      }
                    }
                    System.out.println(WHITE + "\nDid " + RED + damage
                          + WHITE + " damage!\n" + RESET);
                    System.out.println("Did Extra damage from using the strike skill!\n");
                  }

                  monst1.setHp(newHealth);

                  charTurn = false;
                  inSkillChoice = false;
                }
                if (char1.currStrikeSkillCooldown() == 0 && char1.getStrikeSkill() == 2) {
                  char1.resetStrikeSkillCooldown();

                  damage = Actions.attack(char1.getAtk());
                  oldHealth = monst1.getHp();
                  newHealth = Actions.dealDamage(damage * 3, monst1.getHp(), monst1Defense, char1);
                  if (oldHealth == newHealth) {
                    System.out.println(WHITE + "\n" + char1.getName() + "'s attack missed!");
                  } else {
                    if (damage * 3 - monst1Defense < newHealth - oldHealth) {
                      System.out.println("\nCritical Strike!\n");
                    }
                    if (char1.getStatus() == 3 && char1.statusCooldown() != 0) {
                      damage -= 3;
                      if (newHealth > 0) {
                        newHealth -= 3;
                      }
                      if (newHealth < 0) {
                        newHealth = 0;
                      }
                    }
                    System.out.println(WHITE + "\nDid " + RED + damage 
                          + WHITE + " damage!\n" + RESET);
                    System.out.println("Did Extra damage from using the Double Strike skill!\n");
                  }

                  monst1.setHp(newHealth);
                  charTurn = false;
                  inSkillChoice = false;
                }
                if (char1.currStrikeSkillCooldown() == 0 && char1.getStrikeSkill() == 3) {
                  char1.resetStrikeSkillCooldown();


                  damage = Actions.attack(char1.getAtk());
                  oldHealth = monst1.getHp();
                  newHealth = Actions.dealDamage(damage * 7 / 2,
                      monst1.getHp(), monst1Defense, char1);
                  if (oldHealth == newHealth) {
                    System.out.println(WHITE + "\n" + char1.getName() + "'s attack missed!");
                  } else {
                    if (damage * 7 / 2 - monst1Defense < newHealth - oldHealth) {
                      System.out.println("\nCritical Strike!\n");
                    }
                    if (char1.getStatus() == 3 && char1.statusCooldown() != 0) {
                      damage -= 3;
                      if (newHealth > 0) {
                        newHealth -= 3;
                      }
                      if (newHealth < 0) {
                        newHealth = 0;
                      }
                    }
                    System.out.println(WHITE + "\nDid " + RED + damage 
                          + WHITE + " damage!\n" + RESET);
                    System.out.println("Did Extra damage from using the Triple Strike skill!\n");
                  }

                  monst1.setHp(newHealth);
                  charTurn = false;
                  inSkillChoice = false;
                }
              } else if (skillChoice == 3) {
                inSkillChoice = false;
              } else {
                System.out.println(PURPLE + "Invalid entry...please choose again!" + RESET);
              }

            }
          } else if (choice == 5) {
            inItemChoice = true;
            while (inItemChoice == true) {
              itemChoice = Utilities.itemPrompt(char1);
              if (itemChoice == 1) {
                if (char1.getPotions() > 0) {
                  if (char1.getHp() >= char1.getMaxHp()) {
                    System.out.println(WHITE + "You are already at max HP!");
                  } else {
                    char1.setHp(char1.getMaxHp());
                    char1.removePotion();
                    Utilities.characterInfo(char1);
                    charTurn = false;
                    inItemChoice = false;
                  }
                } else {
                  System.out.println(WHITE + "You don't have any potions to use!");
                }
              } else if (itemChoice == 2) {
                if (char1.getSpells() > 0) {
                  // Spell does 50 damage to the monster
                  System.out.println(WHITE + "\nThe Spell did " + RED 
                        + "50 " + WHITE + "damage!\n" + RESET);
                  if (monst1.getHp() - 50 < 0) {
                    monst1.setHp(0);  
                  } else {
                    monst1.setHp(monst1.getHp() - 50);
                  }
                  char1.removeSpells();
                  charTurn = false;
                  inItemChoice = false;
                } else {
                  System.out.println(WHITE + "You don't have any spells to use!");
                }
              } else if (itemChoice == 3) {
                inItemChoice = false;
              } else {
                System.out.println(PURPLE + "Invalid entry...please choose again!" + RESET);
              }
            } 
          } else {
            System.out.println(PURPLE + "Invalid entry...please choose again!" + RESET);
          }
          if (rand.nextInt(100) < 5) {
            char1.setStatus(monst1.statusEffect());
            System.out.println("The " + monst1.getName() + "'s applied " 
                + char1.statusName() + " to " + char1.getName());
          }
          if (rand.nextInt(100) < 5 && determined == false) {
            determined = true;
            char1.setStatus(monst1.statusEffect());
            System.out.println("You became determined, gaining 10 Max HP and recovering all HP!");
            char1.setHp(char1.getMaxHp() + 10);
            System.out.println("You now have " + char1.getMaxHp() + " Max HP!");
          }
          charSpeed = charSpeed - char1.getSpeed();
          char1.turnUsed();
        }
        while (charTurn == false && monst1.getHp() > 0) {

          if (monst1.getHp() > (monst1.getHp() / 2)) {
            monsterDamage = Actions.attack(monst1.getAtk());

            oldHealth = char1.getHp();
            newHealth = Actions.dealDamage(monsterDamage, char1.getHp(), char1Defense, char1);
            if (oldHealth == newHealth) {
              System.out.println(GREEN + "\n" + monst1.getName() + WHITE + "'s attack missed!");
            } else {
              System.out.println("\n" + GREEN + monst1.getName() + WHITE + " did " + YELLOW
                  + monsterDamage + WHITE + " damage to each of your team member!\n" + RESET);
            }
            char1.setHp(newHealth);
            charTurn = true;
          } else if (monst1.getHp() <= 0) {
            System.out.println();
            System.out.println(GREEN + monst1.getName() + " has no more strength!\n" + RESET);
            charTurn = true;
          } else {
            int aiChoice = Utilities.randomRoll();
            if (aiChoice == 0) {
              monsterDamage = Actions.attack(monst1.getAtk());
              char1.setHp(Actions.dealDamage(monsterDamage, char1.getHp(), char1Defense, char1));
              System.out.println();
              System.out.println("\n" + GREEN + monst1.getName() + WHITE + " did " + YELLOW
                  + monsterDamage + WHITE + " damage to each of your team member!\n" + RESET);
              charTurn = true;
            } else if (aiChoice == 1) {
              monst1Defense = monst1.getDef();
              System.out.println();
              System.out.println(WHITE + monst1.getName() + "is defending!\n" + RESET);
              charTurn = true;
            } else if (aiChoice == 2) {
              System.out.println();
              System.out.println(WHITE + monst1.getName() + " healed for "
                  + healing + " points!\n" + RESET);
              charTurn = true;
            }
          }
          monstSpeed = monstSpeed - monst1.getSpeed();
        }

        if (char1.getStatus() == 2 && char1.statusCooldown() != 0) {
          char1.setHp(char1.getHp() - 3);
          System.out.println("Took 3 Damage from Burn!\n");
        }

        if (char1.getStatus() == 3 && char1.statusCooldown() != 0) {
          System.out.println("Did 3 Less Physical Damage from being injured!\n");
        }

        System.out.println(WHITE + "Here's how your party is doing: \n");
        Utilities.characterInfo(char1);
        System.out.println("\nHere's how your enemy is doing: \n");
        System.out.println();
        GameMethods.encounterInfo(monst1);

        if (char1.getHp() <= 0) {
          if (char1.getHp() <= 0) {
            char1Alive = false;
            System.out.println(WHITE + "Your party has been defeated!" + RESET);
            return false;
          } 
        } else if (monst1.getHp() <= 0) {
          monstAlive = false;

          System.out.println(WHITE + "\nWell done! " + monst1.getName() + " defeated!");
          if (char1.event() == 4) {
            System.out.println("\nYou Gained " + (monst1.getXp() + 5) + " XP!");
            System.out.println("You Gained 5 extra XP from the XP Event!");
            char1.addXp(monst1.getXp() + 5);
          } else {
            System.out.println("\nYou Gained " + monst1.getXp() + " XP!");
            char1.addXp(monst1.getXp());
          }
          if (char1.event() == 3) {
            char1.addGold(monst1.getGold() + 1);
            System.out.println("\nYou Gained " + (monst1.getGold() + 1) + " Gold!");
            System.out.println("You got 1 extra gold from the Gold Event!");
          } else {
            char1.addGold(monst1.getGold());
            System.out.println("\nYou Gained " + monst1.getGold() + " Gold!");
          }
          System.out.println("\nCharacter XP: " + char1.getXp() + " XP.");
          System.out.println("\nCharacter Gold: " + char1.getGold() + " Gold." + RESET);
        } else {
          System.out.println(WHITE + "Round " + roundCount + " finished!" + RESET);
          charTurn = true;
        }
        roundCount++;
      }
      monstSpeed = monstSpeed + monst1.getSpeed();
      charSpeed = charSpeed + char1.getSpeed();
    }
    return true;
  }
  
  /**
   * This method has a small chance of being used
   * after a won battle to give the player a random item.
   */
  public static void chest(Character char1) {
    int goldFound = 0;
    Random rand = new Random();
    Equipment equip = new Equipment();
    int random = rand.nextInt(100);
    System.out.println(WHITE + "\nYou found a Chest!");
    if (random >= 0 && random < 15) {
      Helmet newHelmet = equip.getNewHelmet();
      if (newHelmet.getHp() > char1.getHelmet().getHp()) {
        System.out.println(WHITE + "\nYou found a better Helmet: '" + newHelmet.getName() + "'");
        System.out.println(WHITE + "\nOld Character Max HP: '" + char1.getMaxHp() + "'");
        char1.setHelmet(newHelmet);
        System.out.println(WHITE + "\nNew Character Max HP: '" + char1.getMaxHp() + "'");
      } else {
        System.out.println(WHITE + "\nYou already had a better Helmet..");
      }
    }    
    if (random >= 15 && random < 30) {
      Boots newBoots = equip.getNewBoots();
      if (newBoots.getSpeed() > char1.getBoots().getSpeed()) {
        System.out.println(WHITE + "\nYou found a better pair of Boots: '" 
            + newBoots.getName() + "'");
        System.out.println(WHITE + "\nOld Character Speed: '" + char1.getSpeed() + "'");
        char1.setBoots(newBoots);
        System.out.println(WHITE + "\nNew Character Speed: '" + char1.getSpeed() + "'");
      } else {
        System.out.println(WHITE + "\nYou already had a better pair of Boots..");
      }

    }    
    if (random >= 30 && random < 45) {
      Sword newSword = equip.getNewSword();
      if (newSword.getDamage() > char1.getSword().getDamage()) {
        System.out.println(WHITE + "\nYou found a better Sword: '" + newSword.getName() + "'");
        System.out.println(WHITE + "\nOld Character Attack Damage: '" + char1.getAtk() + "'");
        char1.setSword(newSword);
        System.out.println(WHITE + "\nNew Character Attack Damage: '" + char1.getAtk() + "'");
      } else {
        System.out.println(WHITE + "\nYou already had a better Sword..");
      }

    } else if (random >= 45 && random < 60) {
      System.out.println(WHITE + "\nYou found a Potion!");
      char1.addPotion();
      System.out.println(WHITE + "\nTotal Potions: " + char1.getPotions());
    } else if (random >= 60 && random < 75) {
      System.out.println(WHITE + "\nYou found a Spell!");
      char1.addSpell();
      System.out.println(WHITE + "\nTotal Spells: " + char1.getSpells());
    } else if (random >= 75 ) {
      goldFound = rand.nextInt(3) + 1;
      System.out.println(WHITE + "\nYou found " + goldFound + " Gold!");
      char1.addGold(goldFound);
      System.out.println(WHITE + "\nTotal Gold: " + char1.getGold());
    }
  }

  /**
   * This method has a small chance of being used after,
   * a won battle to give the player chance to buy items.
   */
  public static void shop(Character char1) {
    System.out.println(WHITE + "\nYou found a Shop!");
    System.out.println(WHITE + "Marvin, the Shopkeeper, "
        + "welcomes you in and gladly accepts gold.");       
    System.out.println(WHITE + "\n");
    Utilities.shopInfo(char1);
  }
}
