 


/**
 * Write a description of class Normal here.
 *
 * @Yufan Yang
 * @version (a version number or a date)
 */
public class Normal implements PlayerState
{
    public String getState(){return "dying";}
    public PlayerState changeState(){return new Dying();}
}
