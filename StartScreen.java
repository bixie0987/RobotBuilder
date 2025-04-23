import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    private GreenfootImage background;
    
    private int sirenDelay = 120;
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        background = new GreenfootImage("blackBackground.png");
        setBackground(background);
    }
    
    public void act() {
        if (sirenDelay > 0) {
            sirenDelay--;
            return;
        }
        spawn();
    }
    
    public void spawn() {
        addObject(new TextBubbles(), 512, 400);
    }
}
