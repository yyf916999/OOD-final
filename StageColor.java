 

import java.util.*;
/**
 * Write a description of class StageColor here.
 *
 * @Yufan Yang
 * @version (a version number or a date)
 */
public class StageColor extends StageDecorator
{
    public StageColor(Stage s){super(s);}
    Random r= new Random();
    public void makeStage(){
    super.makeStage();
    int c=r.nextInt(3);
    if(c==0){System.out.print(", Stage Color: Red");}
    else if(c==1){System.out.print(", Stage Color: Blue");}
    else{System.out.print(", Stage Color: Green");}
    }
}
