package game;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import game.Actions;
import game.Character;
import game.Monster;
import game.RunningRounds;
import game.Utilities;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * A JUnit test suite for the game.
 *
 * @author pwsmith4
 */

public class TestGame {

  @Test
    public void testCharacterAttackRoll() {
    Character character = new Character("Orc Wizard", 80, 20, 5, 10, 1, 2);
    int damage = Actions.attack(character.getAtk());
    assertTrue(damage >= 20);
  }

  @Test
    public void testMonsterAttackRoll() {
    Monster monster = new Monster("Angry Owls", 45, 5, 5, 10, 1, 15, 3);
    int damage = Actions.attack(monster.getAtk());
    assertTrue(damage >= 5);
  }

  @Test
  public void testHpSetterCharacter() {
    Character character = new Character("Elf Fighter", 110, 15, 12, 13, 2, 1);
    Monster monster = new Monster("Archers", 60, 30, 10, 13, 3, 30, 2);
    int damage = Actions.attack(monster.getAtk());
    character.setHp(damage);
    assertEquals(character.getHp(), damage); 
  }

  @Test
  public void testHpSetterMonster() {
    Character character = new Character("Orc Fighter", 120, 15, 10, 8, 2, 2);
    Monster monster = new Monster("Wizard Apprentices", 70, 15, 5, 12, 3, 30, 3);
    int damage = Actions.attack(character.getAtk());
    monster.setHp(damage);
    assertEquals(monster.getHp(), damage); 
  }

  @Test
  public void testCharacterHealMethod() {
    Character character1 = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    int healing = Actions.healAmount(40);
    Actions.healTarget(character1, healing);
    assertTrue(character1.getHp() > 40);
  }

  @Test
  public void testCharacterDealDamageMethod() {
    Character character = new Character("Human Fighter", 105, 15, 10, 12, 2, 3);
    Monster monster = new Monster("Wizard Apprentices", 70, 15, 5, 12, 3, 30, 3);
    int charDamage = Actions.attack(character.getAtk());
    monster.setHp(Actions.dealDamage(charDamage, monster.getHp(), monster.getDef(), character));
    assertTrue(monster.getHp() < 70);
  }

  @Test
  public void testMonsterDealDamageMethod() {
    Character character = new Character("Elf Rogue", 75, 18, 9, 15, 3, 1);
    Monster monster = new Monster("Knights", 130, 30, 20, 15, 10, 50, 1);
    int monsterDamage = Actions.attack(monster.getAtk());
    character.setHp(Actions.dealDamage(monsterDamage,
        character.getHp(), character.getDef(), character));
    assertTrue(character.getHp() < 70);
  }

  @Test
  public void testCharacterGetSpeedMethod() {
    Character character = new Character("Orc Rogue", 80, 17, 8, 13, 3, 2);
    int characterMag = character.getSpeed();
    assertEquals(characterMag, 13);
  }

  @Test
  public void testMonsterGetSpeedMethod() {
    Monster monster = new Monster("Knights", 130, 30, 20, 15, 10, 50, 1);
    int monsterMag = monster.getSpeed();
    assertEquals(monsterMag, 15);
  }
}
