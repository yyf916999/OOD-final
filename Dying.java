 


/**
 * Write a description of class Dying here.
 *
 * @Yufan
 * @version (a version number or a date)
 */
public class Dying implements PlayerState
{   public Dying(){System.out.println("Player is now enraged, gaining 20 attack dmg for this fight");}
    public String getState(){return "dying";}
    public PlayerState changeState(){return new Normal();}
}
