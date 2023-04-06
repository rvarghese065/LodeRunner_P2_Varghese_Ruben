import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.MouseInfo;

/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse extends Multiplayer
{
    GreenfootImage run1 = new GreenfootImage("player_run_00.png");  
    GreenfootImage leftRun1 = new GreenfootImage("player_run_00.png");
    GreenfootImage run2 = new GreenfootImage("player_run_01.png");  
    GreenfootImage leftRun2 = new GreenfootImage("player_run_01.png"); 
    GreenfootImage run3 = new GreenfootImage("player_run_02.png"); 
    GreenfootImage leftRun3 = new GreenfootImage("player_run_02.png"); 
    GreenfootImage run4 = new GreenfootImage("player_run_03.png");   
    GreenfootImage leftRun4 = new GreenfootImage("player_run_03.png"); 
    GreenfootImage fall = new GreenfootImage("player_fall.png");  
    GreenfootImage ladder1 = new GreenfootImage("player_climb_ladder.png");
    GreenfootImage ladder2 = new GreenfootImage("player_on_ladder_bottom.png"); 
    int run =0; 
    int leftRun =0; 
    boolean touchingBelowLadder = false;   
    boolean touchingAboveLadder =false;  
    boolean touchingBar = false; 
    boolean onLadder =false; 
    int ladderClimb =0; 
    Ladder ladder; 
    Wall wall; 
    public Mouse(){
        leftRun1.mirrorHorizontally(); 
        leftRun2.mirrorHorizontally();
        leftRun3.mirrorHorizontally();
        leftRun4.mirrorHorizontally(); 

    } 

    public void act()
    {   
        MouseInfo mouse = Greenfoot.getMouseInfo(); 
        isTouchingBelowLadder(); 
        isTouchingAboveLadder(); 

        if(!isTouching(Wall.class) && !isTouching(Ladder.class)){ 
            this.setRotation(90);
            move(2);
            this.setRotation(0); 
            setImage(fall);

        }else if(Greenfoot.getMouseInfo() != null){ 
            if(getY()>Greenfoot.getMouseInfo().getY() && touchingAboveLadder && onLadder ==false){
                Ladder ladder = (Ladder)getOneObjectAtOffset(0,8, Ladder.class);  
                if( getOneObjectAtOffset(0,8, Ladder.class) != null){ 
                    setLocation(ladder.getX(), ladder.getY()); 
                }
                onLadder =true; 
            }else if( touchingAboveLadder && !isTouching(Ladder.class)){ 
                onLadder =false;
                touchingAboveLadder =false; 
            } 
            if(getY()>Greenfoot.getMouseInfo().getY() && isTouching(Ladder.class) && onLadder ==true){
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
            if(onLadder ==true && getY()<Greenfoot.getMouseInfo().getY() && isTouching(Ladder.class)){ 
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
            if(touchingAboveLadder && getY()<Greenfoot.getMouseInfo().getY() && onLadder ==false){
                Ladder ladder = (Ladder)getOneObjectAtOffset(0,8, Ladder.class);  
                if( getOneObjectAtOffset(0,2, Ladder.class) != null){ 
                    setLocation(ladder.getX(), ladder.getY()); 
                }
                onLadder =true; 

            }else if( touchingAboveLadder && !isTouching(Ladder.class)){
                onLadder =false;
                touchingAboveLadder =false; 
            }
            if(getX()>Greenfoot.getMouseInfo().getX() && onLadder ==false && getOneObjectAtOffset(-8, 0, Wall.class) == wall){
                this.setRotation(180);
                if(leftRun==0){
                    setImage(leftRun1);
                    leftRun++;
                }else if(run==1){
                    setImage(leftRun2);
                    leftRun++; 
                }else if(run==2){
                    setImage(leftRun3);
                    leftRun++;
                }else{
                    setImage(leftRun4);
                    leftRun =0; 
                } 
                
                    move(2); 
                
                this.setRotation(0); 
            }else if(onLadder==true && getY()==Greenfoot.getMouseInfo().getY() && getX()>Greenfoot.getMouseInfo().getX()){
                this.setRotation(180);
                if(leftRun==0){
                    setImage(leftRun1);
                    leftRun++;
                }else if(run==1){
                    setImage(leftRun2);
                    leftRun++; 
                }else if(run==2){
                    setImage(leftRun3);
                    leftRun++;
                }else{
                    setImage(leftRun4);
                    leftRun =0; 
                } 
                move(2);  
                this.setRotation(0); 
            }
            if(getX()<Greenfoot.getMouseInfo().getX() && onLadder==false&& getOneObjectAtOffset(8, 0, Wall.class) == wall ){ 

                if(run ==0){ 
                    setImage(run1); 
                    run++;
                }else if(run==1){
                    setImage(run2); 
                    run++;
                }else if(run==2){
                    setImage(run3); 
                    run++; 
                }else{
                    setImage(run4); 
                    run=0;
                }
                move(2); 
                this.setRotation(0); 
            }else if(onLadder==true && getY()==Greenfoot.getMouseInfo().getY() && getX()<Greenfoot.getMouseInfo().getX()){
                if(run ==0){ 
                    setImage(run1); 
                    run++;
                }else if(run==1){
                    setImage(run2); 
                    run++;
                }else if(run==2){
                    setImage(run3); 
                    run++; 
                }else{
                    setImage(run4); 
                    run=0;
                }
                move(2); 
                this.setRotation(0); 

            }
        }

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
}
 


