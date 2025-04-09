import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The screen on which the player adjusts their parameters before starting the simulation. Consists of a scale for each parameter and buttons
 * to control them. This class creates the Parameter objects and updates them.
 * 
 * @author Julia
 * @version April 2025
 */
public class SettingsScreen extends World
{
    private Parameter param1, param2;
    
    /**
     * Constructor for objects of class SettingsScreen.
     */
    public SettingsScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        
        param1 = new Parameter("Parameter 1", 100, 100, this);
        param2 = new Parameter("Parameter 2", 100, 200, this);
        
        
    }
    
    public void act() {
        param1.update();
        param2.update();
    }
}
