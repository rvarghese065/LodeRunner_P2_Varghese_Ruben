import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    Wall wall;  
    Ladder ladder; 
    Bar bar; 
    GreenfootImage run1 = new GreenfootImage("player_run_00.png");  
    GreenfootImage leftRun1 = new GreenfootImage("player_run_00.png");
    GreenfootImage run2 = new GreenfootImage("player_run_01.png");  
    GreenfootImage leftRun2 = new GreenfootImage("player_run_01.png"); 
    GreenfootImage run3 = new GreenfootImage("player_run_02.png"); 
    GreenfootImage leftRun3 = new GreenfootImage("player_run_02.png"); 
    GreenfootImage run4 = new GreenfootImage("player_run_03.png");   
    GreenfootImage leftRun4 = new GreenfootImage("player_run_03.png");  
    GreenfootImage stand = new GreenfootImage("player_stand.png"); 
    GreenfootImage fall = new GreenfootImage("player_fall.png");  
    GreenfootImage ladder1 = new GreenfootImage("player_climb_ladder.png");
    GreenfootImage ladder2 = new GreenfootImage("player_on_ladder_bottom.png"); 
    
    boolean touchingBelowLadder = false;   
    boolean touchingAboveLadder =false;  
    boolean touchingBar = false; 
    boolean onLadder =false; 
    int ladderClimb =0; 
    int run = 0; 
    int runLeft = 0;  
    public Player(){
        leftRun1.mirrorHorizontally();
        leftRun2.mirrorHorizontally(); 
        leftRun3.mirrorHorizontally(); 
        leftRun4.mirrorHorizontally(); 
        
        
    }
    public void act()
    { 
         
        
        if(isTouching(Ladder.class)&& getOneObjectAtOffset(0, -8, Ladder.class) ==ladder){
            touchingBelowLadder =true;  
            
        } 
        if(isTouching(Ladder.class) && getOneObjectAtOffset(0,8, Ladder.class) ==ladder){
            touchingAboveLadder = true; 
        }
        if(!touchingBelowLadder && (!isTouching(Wall.class)) && !(isTouching(Bar.class))){
            this.setRotation(90); 
            move(2); 
            this.setRotation(0);  
            setImage(fall);
        }
          
        if(Greenfoot.isKeyDown("left") == true &&( isTouching(Wall.class) || isTouching(Ladder.class))&& getOneObjectAtOffset(-2, 0, Wall.class) == wall){
            this.setRotation(180);  
            if(runLeft ==0){
                setImage(leftRun1); 
                runLeft++; 
            }else if(runLeft==1){
                
                setImage(leftRun2);
                
                runLeft++; 
            }else if(runLeft==2){
                
                setImage(leftRun3); 
                
                runLeft++; 
                
                
            }else{
                
                setImage(leftRun4); 
                
                runLeft=0; 
                
            }
            move(2); 
            this.setRotation(0); 
            
        }  
        if(Greenfoot.isKeyDown("right") == true && (isTouching(Wall.class) || isTouching(Ladder.class)) && getOneObjectAtOffset(2, 0, Wall.class) == wall){
            move(2);  
            if(run==0){
                setImage(run1);  
                run++; 
            }else if(run==1){
                setImage(run2); 
                run++; 
            }else if(run ==2){
                setImage(run3); 
                run++; 
            }else{
                setImage(run4); 
                run=0;
            }

        }  
        if(touchingBelowLadder && Greenfoot.isKeyDown("down") && onLadder ==false ){
            Ladder ladder = (Ladder)getOneObjectAtOffset(0,-8, Ladder.class); 
            int x = getOneIntersectingObject(Ladder.class).getX(); 
            System.out.println(ladder);
            if( getOneObjectAtOffset(0,-2, Ladder.class) != null){ 
                setLocation(x, ladder.getY());
            }
            onLadder=true; 
        }else if(touchingBelowLadder && !isTouching(Ladder.class) && getOneObjectAtOffset(0, -2, Ladder.class) ==null){
            touchingBelowLadder =false; 
            onLadder=false;
            
        }
        if(onLadder ==true && Greenfoot.isKeyDown("down") && isTouching(Ladder.class)){ 
            this.setRotation(90); 
            
            if(ladderClimb == 0){
                setImage(ladder1); 
                ladderClimb++; 
            }else{
                setImage(ladder2); 
                ladderClimb =0; 
            } 
            if(!isTouching(Wall.class)){
                move(2); 
            }
            this.setRotation(0);
            
        }else if (onLadder ==true && !isTouching(Ladder.class)){
            onLadder =false; 
            touchingBelowLadder =false;
        }  
        if(touchingAboveLadder && Greenfoot.isKeyDown("up") && onLadder ==false){
            Ladder ladder = (Ladder)getOneObjectAtOffset(0,8, Ladder.class);  
            if( getOneObjectAtOffset(0,2, Ladder.class) != null){ 
            setLocation(ladder.getX(), ladder.getY()); 
        }
            onLadder =true; 
            
        }else if( touchingAboveLadder && !isTouching(Ladder.class)){
            onLadder =false;
            touchingAboveLadder =false; 
        }
        if(onLadder ==true && Greenfoot.isKeyDown("up") && isTouching(Ladder.class)){
            this.setRotation(270); 
            if(ladderClimb ==0){
                setImage(ladder1); 
                ladderClimb++;
            }else{
                setImage(ladder2); 
                ladderClimb=0;
            } 
            if(isTouching(Wall.class)==false){
            move(2); 
          }
            this.setRotation(0);
        }else if(onLadder ==true && !isTouching(Ladder.class)){
            onLadder =false; 
            touchingAboveLadder =false;
            touchingBelowLadder =false; 
        } 
        
        if(isTouching(Bar.class)  && getOneObjectAtOffset(0,-4, Bar.class) == bar){
            Bar bar = (Bar)getOneObjectAtOffset(0,-4, Bar.class);   
             
            if(bar !=null){
            System.out.println("touching bar");
            setLocation(bar.getX(), bar.getY()); 
        }
        }
        if(isTouching(Bar.class)  && getOneObjectAtOffset(0,4, Bar.class) == bar){
        
        }
        if(isTouching(Bar.class)  && getOneObjectAtOffset(-4,0, Bar.class) == bar){
        
        }
        if(isTouching(Bar.class)  && getOneObjectAtOffset(4,0, Bar.class) == bar){
            
        }
    } 
    
    
}
