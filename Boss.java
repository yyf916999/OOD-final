 

import java.util.*;
/**
 * composite
 *
 * @Yufan Yang
 * @version (a version number or a date)
 */
public abstract class Boss
{
    public int attack;
    public int health;
    private String name;
    public Boss(String n, int d, int h)
    {   
    		name=n;
        attack=d;
        health=h;
    
    }
    public void attacked(int dmg){health-=dmg;}
    public int attacking(){
        Random r=new Random();
        int a=r.nextInt(attack+1);
        return a;}
    public String toString(){return "Boss "+ name+ " Has Appeared";}
    public void displayStats(){
        System.out.println("\t"+name);
        System.out.println("\tAttack: "+ attack);
        System.out.println("\tHealth: "+ health);
    }
    public int enemyHealth(){return health;}
    public void buff() throws WrongTypeException{
        throw new WrongTypeException("This boss does not have this ability");
    }
    public int growl()throws WrongTypeException{
        throw new WrongTypeException("This boss does not have this ability");
    }
}
