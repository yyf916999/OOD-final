 

import java.util.*;
/**
 * Player class
 *
 * @Yufan Yang
 * @version (a version number or a date)Builder
 */
public class Player
{
    private PlayerState state;
    private String name;
    private int armor;
    private int health;
    private int attack;
    private int healthpot;
    private String top;
    private String bot;
    private String hat;
    private int maxHealth;
    private int level;
    
    public static class Builder{
    private String name;
    private int armor;
    private int health;
    private int attack;
    private int healthpot;
    private String top;
    private String bot;
    private String hat;
    private PlayerState state;
    private int maxHealth;
    private int level;
    
    public Builder (String n){
    state= new Normal();
    name=n;
    armor=50;
    health=100;
    maxHealth=health;
    attack=25;
    healthpot=2;
    level=1;
    }
    public Builder head(String h){hat=h; return this;}
    public Builder shirt(String t){top=t; return this;}
    public Builder pants(String b){bot=b; return this;}
    
    public Player build(){return new Player(this);}
    }
    public Player(Builder b)
    {
        // initialise instance variables
        name=b.name;
        armor=b.armor;
        attack=b.attack;
        health=b.health;
        healthpot=b.healthpot;
        top=b.top;
        bot=b.bot;
        hat=b.hat;
        maxHealth=b.maxHealth;
        level=b.level;
        state=b.state;
    }
   
    
    public void armorAttacked(int dmg){armor-=(int)(dmg*0.7);}
    public void attackUpgrade(){attack+=5;}
    public void healthUpgrade(){maxHealth+=10;}
    public void armorUpgrade(){armor+=10;}
    
    public void useHealthPot(){
        if(healthpot<=0){System.out.println("no more potion available");}
        else{health+=50;healthpot-=1;
        if(health>maxHealth){health=maxHealth;}
        }
    }
    public void attacked(int dmg){health-=dmg;}
    public void getHealthPot(){healthpot+=1; System.out.println("Gained a healthpot!"); System.out.println();}
    public void resetState(){state=state.changeState(); attack-=20;}
    public void levelUp(){
    		System.out.println("Player Leveled Up!");
    		System.out.println();
        level+=1;
        healthUpgrade(); 
        attackUpgrade();
        armorUpgrade(); 
        health=maxHealth;
        displayStats();
    }
    public void enraged(){state=state.changeState();
        attack+=20;}
    public int attacking(){
        Random r=new Random();
        int a=r.nextInt(attack+1);
        return a;}
    public int getHealth(){return health;}
    public void displayStats(){
        System.out.println();
        System.out.println("Player Stats:");
        System.out.println("Level: "+ level);
        System.out.println("Attack: "+attack);
        System.out.println("Health: "+health);
        System.out.println("MaxHealth: "+ maxHealth);
        System.out.println("Armor: "+armor);
        System.out.println("Healthpot: "+healthpot);
    }    
    public void endGame(){
    System.out.println("You have reached your limit...");
    System.out.println("Better luck next time");
    }
    public String toString(){return "Top "+top+", Bottom: "+bot+ ", Hat: "+ hat;}
}
