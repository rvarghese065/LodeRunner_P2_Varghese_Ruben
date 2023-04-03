import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
     GreenfootImage background;  
     Wall wall;  
     Ladder ladder; 
     Bar bar;
     Player player; 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 480, 1);  
        player = new Player(); 
        addObject(player, 155, 20);
        Mouse mouse = new Mouse(); 
        addObject(mouse, 90, 300);
        background = new GreenfootImage(600,480);  
        background.setColor(Color.BLACK);
        background.fillRect(0,0, 600, 480);  
        setBackground(background);  
        brickRows(0, 480-(24 *17), 6);  
        brickRows(24*5, 480-(24*10), 3); 
        brickRows(0, 480-(24*5), 12); 
        ladderColumns(155, 40, 7); 
        brickRect(0, 480 -(24*4), 3, 4);   
        brickRows(24*3, 480-24, 23);
        brickRect(600-(24*3), 480-(24*4), 3, 3); 
        
        ladderColumns(155, 200, 7); 
         ladderColumns(100, 200, 7); 
        barRows(getWidth()/2, getHeight()/2, 3);  
        ladderColumns(177, 40, 9);
    } 
    public void brickRows( int x, int y, int numWalls){
        for(int i=0; i<numWalls; i++){
            Wall wall = new Wall(); 
            addObject(wall,x+(( i * (wall.getImage().getWidth()))+ wall.getImage().getWidth()/2), y+ wall.getImage().getHeight()/2); 
            
        }
    } 
    public void brickRect (int x, int y, int numWalls, int rows){ 
        int firstX =x; 
        int secondY = y; 
        for( int i=0; i<rows; i++){
            for( int j=0; j<numWalls; j++){
                Wall wall = new Wall(); 
                addObject(wall,x+(( j * (wall.getImage().getWidth()))+ wall.getImage().getWidth()/2), (y+ wall.getImage().getHeight()/2)+(i*(wall.getImage().getHeight() +3 )));
                
                
            }
            
            x= firstX; 
            
        }
        
    } 
    public void ladderColumns(int x, int y, int numLadders ){ 
        
        for(int i=0; i<numLadders; i++){
            Ladder ladder = new Ladder(); 
            addObject(ladder, x, y+(ladder.getImage().getHeight())*i); 
         
            
            
        }
        
        
    } 
    public void barRows (int x, int y, int numBars){
        for (int i=0; i<numBars; i++){
            Bar bar = new Bar(); 
            addObject(bar, x+(bar.getImage().getWidth())*i, y); 
            
        }
        
    }
}
