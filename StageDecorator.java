 


/**
 * Abstract class StageDecorator - write a description of the class here
 *
 * @Yufan Yang
 * @version (version number or date here)
 */
public abstract class StageDecorator implements Stage
{
    private Stage stage;
    public StageDecorator(Stage s){stage=s;}
    
    public void makeStage(){stage.makeStage();}
}


