import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
import java.util.List; 
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Multiplayer
{
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int direction =getCommand(); 
        //System.out.println(direction); 
    } 
    @Override
    public int getCommand(){
        List<Player> player; 
        player = getWorld().getObjects(Player.class); 
        if(player.get(0).getY()-getY()<0){
            return 1; 
        } 
        if(player.get(0).getX()-getX()>=0){
            return 2;
        }
        if(player.get(0).getY()-getY()>=0){
            return 3; 
        } 
        if(player.get(0).getX()-getX()<0){
             return 4; 
        }
        return 0; 
    }
}
