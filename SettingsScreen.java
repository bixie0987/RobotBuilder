import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Julia
 * @version April 2025
 */
public class SettingsScreen extends World
{
    private Parameter param1, param2, numResearchers;
    
    private Button finishButton; // button to exit SettingsScreen, save parameters and start simulation
    
    /**
     * Constructor for objects of class SettingsScreen.
     */
    public SettingsScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        
        // Create parameters (including their corresponding buttons/bars)
        param1 = new Parameter("Parameter 1", 100, 100, this, 10);
        param2 = new Parameter("Parameter 2", 100, 200, this, 10);
        numResearchers = new Parameter("Number of researchers", 100, 300, this, 4);
        
        // Create 'Finish' button
        finishButton = new Button("finish.png", 0.5);
        addObject(finishButton, 500, 500);
    }
    
    public void act() {
        // Update parameter bars
        param1.update();
        param2.update();
        numResearchers.update();
    }
}
