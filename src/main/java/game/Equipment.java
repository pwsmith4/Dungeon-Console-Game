package game;

import java.util.Random;

/** Class that picks a random equipment. 
 * 
 * @author pwsmith4
 **/ 

public class Equipment {
  Helmet helm = new Helmet();
  Boots boots = new Boots();
  Sword sword = new Sword();

  /** Sets new Helmet. Automatically picks the best helmet and equips it. */
  public Helmet getNewHelmet() {
    Random rand = new Random();
    int randomHelmet = rand.nextInt(100);
    helm.setHelmet(randomHelmet);
    return helm;
  }

  /** Sets new Boots. Automatically picks the best pair of boots and equips it. */
  public Boots getNewBoots() {
    Random rand = new Random();
    int randomBoots = rand.nextInt(100);
    boots.setBoots(randomBoots);
    return boots;
  }

  /** Sets new Sword. Automatically picks the best sword and equips it. */
  public Sword getNewSword() {
    Random rand = new Random();
    int randomSword = rand.nextInt(100);
    sword.setSword(randomSword);
    return sword;
  }

  /** Return Helmet Name. */
  public String getHelmetName() {
    return helm.getName();
  }

  /** Return Boots Name. */
  public String getBootsName() {
    return boots.getName();
  }
  
  /** Return Sword Name. */
  public String getSwordName() {
    return sword.getName();
  }

}
