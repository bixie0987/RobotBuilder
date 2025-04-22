import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    private GreenfootImage goodRobot;
    private GreenfootImage evilRobot;
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        GreenfootImage endscreen;
        if (winner.equals("good")) {
            endscreen = new GreenfootImage("endscreen1.PNG");
        } else {
            endscreen = new GreenfootImage("endscreen2.PNG");
        }
        
        setBackground(endscreen);
        endscreen.scale(1024, 800);
        Sounds.getInstance().playSounds(Sounds.WIN_SOUND);
    }
    
    public void act()
    {
        
    }
}
