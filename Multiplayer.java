import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Multiplayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Multiplayer extends Actor
{
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
    int leftRun = 0;  
    /**
     * Act - do whatever the Multiplayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       
    }
    public void isTouchingBelowLadder(){
    if(isTouching(Ladder.class)&& getOneObjectAtOffset(0, -8, Ladder.class) ==ladder){
            touchingBelowLadder =true;  

        }
    }
    public void isTouchingAboveLadder(){
        if(isTouching(Ladder.class) && getOneObjectAtOffset(0,8, Ladder.class) ==ladder){
            touchingAboveLadder = true; 
            
        }
    }
    public int getCommand(){
        return 3; 
    }
}
