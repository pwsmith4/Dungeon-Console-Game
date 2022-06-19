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
    assertTrue(character.getHp() < 76);
  }
  
  @Test
  public void testElfWizard() {
    Characters char1 = new Characters();
    Character testChar = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    Character thisChar = char1.characters1(1);
    assertEquals(thisChar.getAtk(), testChar.getAtk());    
  }
  
  @Test
  public void testChar() {
    Character testChar = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    assertEquals(testChar.getName(), "Elf Wizard");
    testChar.addGold(1);
    assertEquals(testChar.getGold(), 1);
    testChar.removeGold(1);
    assertEquals(testChar.getGold(), 0);
    testChar.addPotion();
    assertEquals(testChar.getPotions(), 1);
    testChar.addSpell();
    assertEquals(testChar.getSpells(), 1);
    testChar.setSkillName("Name");
    assertEquals(testChar.getSkillName(), "Name");
    testChar.setSkillCooldown(3);
    assertEquals(testChar.skillCooldown(), 3);
    testChar.setCurrSkillCooldown();
    assertEquals(testChar.currSkillCooldown(), 3);
    testChar.addStrikeSkill();
    assertEquals(testChar.getStrikeSkill(), 1);
    testChar.setStrikeSkillName("Strike");
    assertEquals(testChar.getStrikeSkillName(), "Strike");
    testChar.setStrikeSkillCooldown(3);
    testChar.resetStrikeSkillCooldown();
    assertEquals(testChar.getStrikeSkillCooldown(), 3);
    testChar.turnUsed();
    assertEquals(testChar.currSkillCooldown(), 2);
    assertEquals(testChar.currStrikeSkillCooldown(), 2);
  }
  
  @Test 
  public void testStatus() {
    Character testChar = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    testChar.setStatus(1);
    assertEquals(testChar.getStatus(), 1);
    assertEquals(testChar.statusCooldown(), 1);
    assertEquals(testChar.statusName(), "Paralyzed");
    testChar.setStatus(2);
    assertEquals(testChar.statusCooldown(), 3);
    assertEquals(testChar.statusName(), "Burn");
    testChar.setStatus(3);
    assertEquals(testChar.statusCooldown(), 2);
    assertEquals(testChar.statusName(), "Injured");
    testChar.turnUsed();
    assertEquals(testChar.statusCooldown(), 1);
  }
  
  @Test
  public void testHp() {
    Character testChar = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    assertEquals(testChar.getMaxHp(), 80);
  }
  
  @Test
  public void testXp() {
    Character testChar = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    assertEquals(testChar.getXp(), 0);
  }
  
  @Test
  public void testAddXp() {
    Character testChar = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    testChar.addXp(5);
    assertEquals(testChar.getXp(), 5);
  }
  
  @Test
  public void testSetXp() {
    Character testChar = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    testChar.setXp(15);
    assertEquals(testChar.getXp(), 15);
  }
  
  @Test
  public void testXpCap() {
    Character testChar = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    testChar.setXpCap(100);
    assertEquals(testChar.getXpCap(), 100);
  }
  
  @Test
  public void testLevel() {
    Character testChar = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    testChar.setLevel(5);
    assertEquals(testChar.getLevel(), 5);
  }
  
  @Test
  public void testHelmet() {
    Character testChar = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    Equipment equip = new Equipment();
    Helmet helm = new Helmet();
    helm = equip.getNewHelmet();
    testChar.setHelmet(helm);
    assertEquals(helm.getHp(), testChar.getHelmet().getHp());
    assertEquals(helm.getCost(), testChar.getHelmet().getCost());
    assertEquals(helm.getName(), testChar.getHelmet().getName());
    assertEquals(equip.getHelmetName(), testChar.getHelmet().getName());
  }

  @Test
  public void testSword() {
    Character testChar = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    Equipment equip = new Equipment();
    Sword sword = new Sword();
    sword = equip.getNewSword();
    testChar.setSword(sword);
    assertEquals(sword.getDamage(), testChar.getSword().getDamage());
    assertEquals(sword.getCost(), testChar.getSword().getCost());
    assertEquals(sword.getName(), testChar.getSword().getName());
    assertEquals(equip.getSwordName(), testChar.getSword().getName());
  }
  
  @Test
  public void testBoots() {
    Character testChar = new Character("Elf Wizard", 80, 15, 5, 10, 1, 1);
    Equipment equip = new Equipment();
    Boots boots = new Boots();
    boots = equip.getNewBoots();
    testChar.setBoots(boots);
    assertEquals(boots.getSpeed(), testChar.getBoots().getSpeed());
    assertEquals(boots.getCost(), testChar.getBoots().getCost());
    assertEquals(boots.getName(), testChar.getBoots().getName());
    assertEquals(equip.getBootsName(), testChar.getBoots().getName());
  }
  
  @Test
  public void testBootsRarity() {
    Boots boots = new Boots();
    boots.setBoots(1);
    assertEquals(boots.getSpeed(), 1);
    boots.setBoots(60);
    assertEquals(boots.getSpeed(), 2);
    boots.setBoots(90);
    assertEquals(boots.getSpeed(), 3);
  }
  
  @Test
  public void testHelmetRarity() {
    Helmet helmet = new Helmet();
    helmet.setHelmet(1);
    assertEquals(helmet.getHp(), 1);
    helmet.setHelmet(60);
    assertEquals(helmet.getHp(), 2);
    helmet.setHelmet(90);
    assertEquals(helmet.getHp(), 3);
  }
  
  @Test
  public void testSwordRarity() {
    Sword sword = new Sword();
    sword.setSword(1);
    assertEquals(sword.getDamage(), 1);
    sword.setSword(60);
    assertEquals(sword.getDamage(), 2);
    sword.setSword(90);
    assertEquals(sword.getDamage(), 3);
  }
  
  @Test
  public void testOrcFighter() {
    Characters char1 = new Characters();
    Character testChar = new Character("Orc Fighter", 120, 15, 10, 8, 2, 2);
    Character thisChar = char1.characters2(2);
    assertEquals(thisChar.getAtk(), testChar.getAtk());
  }
  
  @Test
  public void testHumanRogue() {
    Characters char1 = new Characters();
    Character testChar = new Character("Human Rogue", 70, 18, 9, 14, 3, 3);
    Character thisChar = char1.characters3(3);
    assertEquals(thisChar.getAtk(), testChar.getAtk());
  }
  
  @Test
  public void testMonsterDealExtraDamageMethod() {
    Character character = new Character("Elf Rogue", 5, 18, 9, 15, 3, 1);
    Monster monster = new Monster("Knights", 130, 100, 20, 15, 10, 50, 1);
    int monsterDamage = Actions.attack(monster.getAtk());
    character.setHp(Actions.dealDamage(monsterDamage,
        character.getHp(), character.getDef(), character));
    assertEquals(character.getHp(), 0);
  }
  
  @Test
  public void testRogueDealEventDamageMethod() {
    Character character = new Character("Elf Rogue", 75, 18, 9, 15, 3, 1);
    Monster monster = new Monster("Knights", 130, 30, 20, 15, 10, 50, 1);
    character.setEvent(2);
    int monsterDamage = Actions.attack(monster.getAtk());
    character.setHp(Actions.dealDamage(monsterDamage,
        character.getHp(), character.getDef(), character));
    assertTrue(character.getHp() < 75);
  }
  
  @Test
  public void testMonsterDealMinimumDamageMethod() {
    Character character = new Character("Elf Rogue", 15, 18, 100, 15, 3, 1);
    Monster monster = new Monster("Knights", 130, 30, 20, 15, 10, 50, 1);
    int monsterDamage = Actions.attack(monster.getAtk());
    character.setHp(Actions.dealDamage(monsterDamage,
        character.getHp(), character.getDef(), character));
    assertEquals(character.getHp(), 14);
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
  
  @Test
  public void testMain() {
    RunningRounds main = new RunningRounds();
    main.setCharacter(1, 1);
    main.main(null);
  }
}
