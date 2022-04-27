package game;

/**
 * A class that contains the character object.
 *
 * @author pwsmith4
 */
public class Character {

  private String characterName; // character name.
  private String skillName; //character skill name.
  private int maxHp; //character max HP.
  private int hitPoints; // character HP.
  private int attack; // character attack.
  private int defense; // character defense.
  private int speed; // character speed.
  private int xp; // current character xp.
  private int experienceCap; // xp cap.
  private int level; // current character level.
  private Boots boots; // Boots Equipped.
  private Sword sword; // Sword Equipped.
  private Helmet helmet; // Helmet Equipped.
  private int potions; // Number of equipped potions.
  private int spells; // Number of equipped.
  private int gold; // Amount of gold character has.
  private int skillCooldown; //Skill cooldown .
  private int currSkillCooldown; //Current skill cooldown.
  private int charClass; // Character's class: 0 = null, 1 = Wizard type, 
  // 2 = Fighter type, 3 = Rogue type. 
  private int raceClass; // Character's class: 0 = null,
  // 1 = Elf, 2 = Orc, 3 = Human.
  private int strikeSkill; //Character's strike skill: 0 = none, 1 = Strike, 
  // 2 = Double Strike, 3 = Triple Strike.
  private String strikeSkillName; // Name of Strike Skill.
  private int strikeSkillCooldown; // Strike skill cooldown.
  private int currStrikeSkillCooldown; // Current strike skill cooldown.
  private int event; //What event are we on? 1 = Physical attacks deal 5 less damage,
  //2 = 5% higher miss chance, 3 = Gain extra money, 4 = Gain extra experience.
  private int status; // Current status applied to character. 1 = paralyze, 2 = burn, 3 = injured.
  private String statusName;
  private int statusEffectCooldown; 

  /**
   * Constructs a new character instance.
   */
  public Character(String name, int hp, int atk, int def, int sped, int charClas, int raceClas) {
    characterName = name;
    hitPoints = hp;
    maxHp = hp;
    attack = atk;
    defense = def;
    speed = sped;
    xp = 0;
    level = 0;
    experienceCap = 0;
    boots = new Boots();
    helmet = new Helmet();
    sword = new Sword();
    charClass = charClas;
    raceClass = raceClas;
    potions = 0;
    spells = 0;
    skillCooldown = 0;
    currSkillCooldown = 0;
    gold = 0;
    skillName = "";
    strikeSkill = 0;
    strikeSkillName = "";
    strikeSkillCooldown = 0;
    currStrikeSkillCooldown = 0;
    event = 0;
    status = 0;
    statusEffectCooldown = 0;
    statusName = "";
  }

  /** Returns the name of the character. */
  public String getName() {
    return characterName;
  }

  /** Returns the HP of the character. */
  public int getHp() {
    return hitPoints;
  }

  /** Returns the max HP of the character. */
  public int getMaxHp() {
    return maxHp;
  }

  /** Returns the attack points of the character. */
  public int getAtk() {
    return attack;
  }

  /** Returns the defense points of the character. */
  public int getDef() {
    return defense;
  }

  /** Returns the magic points of the character. */
  public int getSpeed() {
    return speed;
  }

  /** Return Xp of the character. */
  public int getXp() {
    return xp;
  }

  /** Set Xp. */
  public void setXp(int experience) {
    this.xp = experience;
  }

  /** Add XP to character.   */
  public int addXp(int xpAmount) {
    xp = xp + xpAmount;
    return xp;
  }

  /** Changes the HP. */
  public void setHp(int health) {
    this.hitPoints = health;
    if (health > maxHp) {
      this.hitPoints = maxHp;
    }
  }

  /** Returns XP Cap. */
  public int getXpCap() {
    return experienceCap;
  }

  /** Set XP Cap. */
  public void setXpCap(int experienceCap) {
    this.experienceCap = experienceCap;
  }

  /** Return current level. */
  public int getLevel() {
    return level;
  }

  /** Set level. */
  public void setLevel(int level) {
    this.level = level;
  }

  /** Set Helmet. */
  public void setHelmet(Helmet helm) {
    if (helm.getHp() > helmet.getHp()) {
      this.helmet = helm;
      maxHp = maxHp + helmet.getHp();
      hitPoints = hitPoints + helmet.getHp();
    }  
  }

  /** Return Helmet. */
  public Helmet getHelmet() {
    return helmet;
  }

  /** Set Sword. */
  public void setSword(Sword swrd) {
    if (swrd.getDamage() > sword.getDamage()) {
      this.sword = swrd;
      attack = attack + sword.getDamage();
    }  
  }

  /** Return Sword. */
  public Sword getSword() {
    return sword;
  }

  /** Set Boots. */
  public void setBoots(Boots boot) {
    if (boot.getSpeed() > boots.getSpeed()) {
      this.boots = boot;
      speed = speed + boots.getSpeed();
    }  
  }

  /** Return Boots. */
  public Boots getBoots() {
    return boots;
  }

  /** Return Number of Potions. */
  public int getPotions() {
    return potions;
  }

  /** Add a set number of Potions. */
  public void addPotion() {
    potions++;
  }

  /** Remove a Potion. */
  public void removePotion() {
    potions--;
  }

  /** Return Amount of Spells.   */
  public int getSpells() {
    return spells;
  }

  /** Adds a Spell. */
  public void addSpell() {
    spells++;
  }

  /** Remove a Spell. */
  public void removeSpells() {
    spells--;
  }

  /** Add a set number of Gold. */
  public void addGold(int goldEarned) {
    gold = gold + goldEarned;
  }

  /** Removes a set amount of Gold. */
  public void removeGold(int goldTaken) {
    gold = gold - goldTaken;
  }

  /** Returns Gold. */
  public int getGold() {
    return gold;
  }

  /** Returns Class Type. */
  public int getRaceClass() {
    return charClass;
  }

  /** Returns Race Type. */
  public int getRaceType() {
    return raceClass;
  }

  /** Sets skill name. */
  public void setSkillName(String skill) {
    skillName = skill;
  }

  /** Return special skill name. */
  public String getSkillName() {
    return skillName;
  }

  /** Sets skill cooldown. */
  public void setSkillCooldown(int skill) {
    skillCooldown = skill;
  }

  /** Return skill cooldown. */
  public int skillCooldown() {
    return skillCooldown;
  }

  /** Sets current skill cooldown. */
  public void setCurrSkillCooldown() {
    currSkillCooldown = skillCooldown;
  }

  /** Removes a turn from cooldown. */
  public void turnUsed() {
    if (currSkillCooldown != 0) {
      currSkillCooldown--;
    }
    if (currStrikeSkillCooldown != 0) {
      currStrikeSkillCooldown--;
    }
    if (statusEffectCooldown != 0) {
      statusEffectCooldown--;
    }
  }

  /** Return current skill cooldown. */
  public int currSkillCooldown() {
    return currSkillCooldown;
  }

  /** Add 1 to strikeSkill. */
  public void addStrikeSkill() {
    strikeSkill++;
  }

  /** Return strikeSkill. */
  public int getStrikeSkill() {
    return strikeSkill;
  }

  /** Sets Strike Skill Name. */
  public void setStrikeSkillName(String strikeName) {
    strikeSkillName = strikeName;
  }

  /** Gets Strike Skill Name. */
  public String getStrikeSkillName() {
    return strikeSkillName;
  }

  /** Reset strike skill cooldown. */
  public void resetStrikeSkillCooldown() {
    currStrikeSkillCooldown = strikeSkillCooldown;
  }

  /** Sets strike skill cooldown. */ 
  public void setStrikeSkillCooldown(int strikeCooldown) {
    strikeSkillCooldown = strikeCooldown;
  }

  /** Return current strike skill cooldown. */ 
  public int currStrikeSkillCooldown() {
    return currStrikeSkillCooldown;
  }

  /** Return strike skill cooldown. */
  public int getStrikeSkillCooldown() {
    return strikeSkillCooldown;
  }

  /** Set event. */
  public void setEvent(int eventNumber) {
    event = eventNumber;
  }

  /** Return event number. */
  public int event() {
    return event;
  }

  /** Set Status. */
  public void setStatus(int stats) {
    status = stats;
    if (status == 1) {
      statusEffectCooldown = 1;
      statusName = "Paralyzed";
    }
    if (status == 2) {
      statusEffectCooldown = 3;
      statusName = "Burn";
    }
    if (status == 3) {
      statusEffectCooldown = 2;
      statusName = "Injured";
    }
  }

  /** Return status. */
  public int getStatus() {
    return status;
  }

  /** Return status effect cooldown. */
  public int statusCooldown() {
    return statusEffectCooldown;
  }

  /** Return status effect name. */
  public String statusName() {
    return statusName;
  }
}
