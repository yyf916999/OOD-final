 

import java.util.*;
/**
 * Write a description of class Game here.
 *
 * @Yufan Yang
 * @version (a version number or a date)
 */
public class Game
{
    // instance variables - replace the example below with your own

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);       
        System.out.println("Welcome to the World of Xynoka!");
        System.out.println("--Type in Player Name--");
        String name=in.nextLine();
        System.out.println("Welcome, "+ name + "!");
        String top,bot,hat;
        System.out.println("--Choose Character Hats: --");
        System.out.println("0: no hats. 1: bucket hat. 2: snapback.");
        int h=in.nextInt();
        if(h==0){hat="no hats";}
        else if (h==1){hat="bucket hat";}
        else{ hat="snapback";}
        System.out.println("--Choose Character Top: --");
        System.out.println("0: default(white shirt). 1: Hoodie. 2: Uniform");
        int t=in.nextInt();
        if(t==0){top="white shirt";}
        else if(t==1){top="Hoodie";}
        else{top="Uniform";}
        
        System.out.println("--Choose Character Bottom:--");
        
        System.out.println("0: default(Camo Cargo). 1: Sweatpants. 2: Jeans");
        int b=in.nextInt();
        if(b==0){bot="Camo Cargo";}
        else if(b==1){ bot= "Sweatpants";}
        else{ bot="Jeans";}
        
        Player p1= new Player.Builder(name).head(hat).shirt(top).pants(bot).build();
        System.out.println(p1);
        System.out.println("--Fighting Stage Decoration:--");
        Stage stage;
        System.out.println("Press 1 if you want to color the stage with a random color, press 0 otherwise");
        int c=in.nextInt();
        System.out.println("Press 1 if you want a random stage theme, 0 otherwise");
        int l=in.nextInt();
        if(c==1 && l==1){stage=  new StageColor(new StageTheme(new MainStage()));}
        else if(c==1 && l==0){stage= new StageColor(new MainStage());}
        else if(l==1 && c==0){stage= new StageTheme(new MainStage());}
        else{stage= new MainStage();}
        stage.makeStage();
        System.out.println();
        
        System.out.println("For every 3 minions you fight, you will encounter a boss. If you beat three bosses, then you have succesfully complete the Dungeon");
        System.out.println("--The Dungeon Begin!--");
        System.out.println("Good Luck!");
        System.out.println();
        int minionCount=0;
        boolean enrage=false;
        boolean run=true;
        Random r= new Random();
        while(run){
        int m= r.nextInt(2);
        if(m==0){
            Minion s= new Sword();
            System.out.println("A Sword Minion Has Appeared");
            while(s.enemyHealth()>0){
            s.displayStats();
            p1.displayStats();
            if(p1.getHealth()<=30){p1.enraged(); enrage=true;}
            System.out.println("Your options are:");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Use HelathPotion");
            int a= in.nextInt();
            if(a==1){s.attacked(p1.attacking());}
            else{p1.useHealthPot();}
            p1.attacked(s.attacking());
            if(p1.getHealth()<=0){p1.endGame(); System.exit(0);}
            }
        if(s.dropChance()){p1.getHealthPot();}
        if(enrage){enrage=false;p1.resetState();}
        minionCount+=1;
        if(minionCount==2|| minionCount==6|| minionCount==11){p1.levelUp();}
        System.out.println("you have defeated the sword minion");
        System.out.println("------------------------");
        System.out.println();
        System.out.println();
        System.out.println();    
    
        }   
        
        
        else if(m==1){
            Minion a=new Archer();
            System.out.println("An Archer Minion Has Appeared");
            System.out.println("Archer has attack range 3, so you have to close the distance between you two to 1 before you are able to attack");
            int distance=3;
            while(a.enemyHealth()>0){
            a.displayStats();
            p1.displayStats();
            System.out.println("Distance: "+ distance);
            if(p1.getHealth()<=30 && enrage==false){p1.enraged(); enrage=true;}
            System.out.println("Your options are:");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Use Health Potion");
            System.out.println("\t3. Close the Distance by One");
            int o= in.nextInt();
            if(o==1){
                if(distance<2){a.attacked(p1.attacking());}
                else{System.out.println("Enemy out of range");}
            }
            else if(o==2){p1.useHealthPot();}
            else{distance-=1;}
            p1.attacked(a.attacking());
            if(p1.getHealth()<=0){p1.endGame(); System.exit(0);}
            }
            if(a.dropChance()){p1.getHealthPot();}
            minionCount+=1;
            if(enrage){enrage=false;p1.resetState();}
            if(minionCount==2|| minionCount==6|| minionCount==11){p1.levelUp();}
            System.out.println("you have defeated the archer minion");
            System.out.println("------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
        }   
        if(minionCount==3){
            Boss bossOne= new BossOne();
            System.out.println(bossOne);
            
            while(bossOne.enemyHealth()>0){
            bossOne.displayStats();
            p1.displayStats();    
            if(p1.getHealth()<=30){p1.enraged(); enrage=true;}
            System.out.println("Your options are:");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Use HealthPotion");
            int a= in.nextInt();
            if(a==1){bossOne.attacked(p1.attacking());}
            else{p1.useHealthPot();}
            p1.attacked(bossOne.attacking());
            if(p1.getHealth()<=0){p1.endGame(); System.exit(0);}
            }
            if(enrage){enrage=false;p1.resetState();}
            p1.levelUp();
            minionCount+=1;
            System.out.println("You have defeated Xyk");
            System.out.println("------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
            }
            
            
         if(minionCount==7){
            Boss bossTwo=new BossTwo();
            System.out.println(bossTwo);
            
            while(bossTwo.enemyHealth()>0){
            bossTwo.displayStats();
            p1.displayStats();    
            if(p1.getHealth()<=30){p1.enraged(); enrage=true;}
            System.out.println("Your options are:");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Use HealthPotion");
            int a= in.nextInt();
            if(a==1){bossTwo.attacked(p1.attacking());}
            else{p1.useHealthPot();}
            int bossOp=r.nextInt(2);
            if(bossOp==0){
                try{
                    bossTwo.buff();}
                    catch(WrongTypeException e){
                        System.out.println(e.getMessage());
                    }
                }
            else{p1.attacked(bossTwo.attacking());}
            if(p1.getHealth()<=0){p1.endGame(); System.exit(0);}
            }
            if(enrage){enrage=false;p1.resetState();}
            p1.levelUp();
            minionCount+=1;
            System.out.println("You have defeated Exilah");
            System.out.println("------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
            }
        if(minionCount==11){
            Boss bossThree=new BossThree();
            System.out.println(bossThree);
            boolean g=true;
            while(bossThree.enemyHealth()>0){
            bossThree.displayStats();
            p1.displayStats();    
            if(p1.getHealth()<=30){p1.enraged(); enrage=true;}
            System.out.println("Your options are:");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Use HealthPotion");
            int a= in.nextInt();
            if(a==1){bossThree.attacked(p1.attacking());}
            else{p1.useHealthPot();}
            if(g){try{
            	System.out.println("Kulua growled, dealing massive damage");
               p1.attacked(bossThree.growl());; 
            }catch(WrongTypeException e){
                System.out.println(e.getMessage());
            }
            g=false;
            }
            else{int bossOp=r.nextInt(2);
            if(bossOp==0){
                try{
                    bossThree.buff();}
                    catch(WrongTypeException e){
                        System.out.println(e.getMessage());
                    }
                }
            else{p1.attacked(bossThree.attacking());}
            }
            if(p1.getHealth()<=0){p1.endGame(); System.exit(0);}
            }
            if(enrage){enrage=false;p1.resetState();}
            p1.levelUp();
            minionCount+=1;
            System.out.println("You have defeated Exilah");
            System.out.println("------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
        
        
            System.out.println("Congratulation! You Have Completed the Dungeon!");
            System.exit(0);
        }
            
        }//the while loop
   }
} 

