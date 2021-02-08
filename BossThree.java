 


/**
 * Write a description of class BossThree here.
 *
 * @Yufan Yang
 * @version (a version number or a date)
 */
public class BossThree extends Boss
{
    private static String name="Kulua";
    public BossThree(){super(name,50,90);}
    public void buff(){attack+=10; health+=10;}
    
    public int growl(){
    int d=70;
    return d;
    }
    
}
