 


/**
 * Write a description of class BossTwo here.
 *
 * @Yufan Yang
 * @version (a version number or a date)
 */
public class BossTwo extends Boss
{
    private static String name="Exilah";
    public BossTwo(){super(name,45,80);}
    public void buff(){
    	System.out.println("Boss used buff, gaining 10 attack damage");
    	attack+=10;}
    
}
