 

import java.util.*;
/**
 * Write a description of class Sword here.
 *
 * @Yufan Yang
 * @version (a version number or a date)
 */
public class Sword implements Minion
{
    // instance variables - replace the example below with your own
    private int attackRange;
    private int attack;
    private int health;
    /**
     * Constructor for objects of class Sword
     */
    public Sword()
    {
        // initialise instance variables
        attackRange=1;
        attack=25;
        health=20;
        
    }
    public int attacking(){
        Random r=new Random();
        int a=r.nextInt(attack+1);
        return a;}
    public boolean dropChance(){
        Random d=new Random();
        if(d.nextInt(100)<=50){return true;}
        return false;
    }
    public int enemyHealth(){return health;}
    public void displayStats(){ 
        System.out.println("Sword Minion");
        System.out.println("Attack: "+attack);
        System.out.println("Health: "+health);
    }
    public void attacked(int dmg){health-=dmg;}
}
