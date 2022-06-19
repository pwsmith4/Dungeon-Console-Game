package game;

/**
 * A class that holds new Character information.
 *
 * @author pwsmith4 
 */
public class Characters {

  /** Returns Wizard Characters. */
  public Character characters1(int race) {
    Character[] characters = new Character[3];
    characters[0] = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    characters[1] = new Character("Orc Wizard", 80, 20, 5, 10, 1, 2);
    characters[2] = new Character("Human Wizard", 80, 15, 5, 10, 1, 3);

    final Character char1 = characters[race - 1];
    char1.setSkillName("Drain Spell");
    char1.setSkillCooldown(3);

    return char1;
  }

  /** Returns Fighter Characters. */
  public Character characters2(int race) {
    Character[] characters = new Character[3];
    characters[0] = new Character("Elf Fighter", 110, 15, 12, 13, 2, 1);
    characters[1] = new Character("Orc Fighter", 120, 15, 10, 8, 2, 2);
    characters[2] = new Character("Human Fighter", 105, 15, 10, 12, 2, 3);

    final Character char2 = characters[race - 1];
    char2.setSkillName("Guaranteed Crit Attack");
    char2.setSkillCooldown(4);

    return char2;
  }

  /** Returns Rogue Characters. */
  public Character characters3(int race) {
    Character[] characters = new Character[3];
    characters[0] = new Character("Elf Rogue", 75, 18, 9, 15, 3, 1);
    characters[1] = new Character("Orc Rogue", 80, 17, 8, 13, 3, 2);
    characters[2] = new Character("Human Rogue", 70, 18, 9, 14, 3, 3);

    final Character char3 = characters[race - 1];
    char3.setSkillName("Backstab Attack");
    char3.setSkillCooldown(4);

    return char3;
  }
}
