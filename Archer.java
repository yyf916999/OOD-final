 

import java.util.*;
/**
 * Write a description of class Archer here.
 *
 * @Yufan Yang
 * @version (a version number or a date)
 */
public class Archer implements Minion
{
    // instance variables - replace the example below with your own
    private int attackRange;
    private int attack;
    private int health;
    /**
     * Constructor for objects of class Archer
     */
    public Archer()
    {
        // initialise instance variables
        attackRange=3;
        attack=15;
        health=15;
    }
    public int attacking(){
        Random r=new Random();
        int a=r.nextInt(attack+1);
        return a;}
    public boolean dropChance(){
        Random d=new Random();
        if(d.nextInt(100)<=70){return true;}
        return false;
        
    }
    public void displayStats(){ 
        System.out.println("Archer Minion");
        System.out.println("Attack: "+attack);
        System.out.println("Health: "+health);
    }
    public int enemyHealth(){return health;}
    public void attacked(int dmg){health-=dmg;}
}
