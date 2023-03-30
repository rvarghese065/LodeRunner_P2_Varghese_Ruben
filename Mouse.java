import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.MouseInfo;

/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse extends Actor
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

    int run =0; 
    int leftRun =0; 
    Player player; 
    public Mouse(){
        leftRun1.mirrorHorizontally(); 
        leftRun2.mirrorHorizontally();
        leftRun3.mirrorHorizontally();
        leftRun4.mirrorHorizontally(); 

    } 
    public void act()
    {  
        if(!isTouching(Wall.class)){ 
            this.setRotation(90);
            move(2);
            this.setRotation(0); 
            setImage(fall);

        }
        MouseInfo mouse = Greenfoot.getMouseInfo(); 
        if(mouse != null){
            if(player.getX()<mouse.getX()){
                if(leftRun==0){
                    setImage(leftRun1); 
                }else if(run==1){
                    setImage(leftRun2);
                }else if(run==2){
                    setImage(leftRun3);
                }else{
                    setImage(leftRun4);
                }

            }else if(player.getX()>mouse.getX()){
                if(run ==0){ 
                    setImage(run1); 

                }else if(run==1){
                    setImage(run2); 
                }else if(run==2){
                    setImage(run3); 
                }else{
                    setImage(run4); 
                }

            } 
        }

    }
}
