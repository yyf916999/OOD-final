 
import java.util.*;

/**
 * Write a description of class StageTheme here.
 *
 * @Yufan Yang
 * @version (a version number or a date)
 */
public class StageTheme extends StageDecorator
{

    public StageTheme(Stage s){super(s);}
    Random r= new Random();
    public void makeStage(){
    super.makeStage();
    int c=r.nextInt(2);
    if(c==0){System.out.print(", Light Theme");}
    else{System.out.print(", Dark Theme");}
    }

}
