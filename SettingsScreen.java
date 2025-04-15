import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Julia
 * @version April 2025
 */
public class SettingsScreen extends World
{
    private Parameter param1, param2, numResearchers, spiderSpawnChance;

    private Button startButton; // button to exit SettingsScreen, save parameters and start simulation
    
    /**
     * Constructor for objects of class SettingsScreen.
     */
    public SettingsScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        
        // Create parameters (including their corresponding buttons/bars)
        param1 = new Parameter("Parameter 1", 200, 100, this, 10, 0);
        param2 = new Parameter("Parameter 2", 200, 200, this, 10, 0);
        numResearchers = new Parameter("Number of researchers", 200, 300, this, 4, 1);
        
        // Create 'start' button
        startButton = new Button("startBUTT.png", 0.5);
        addObject(startButton, 500, 500);
        spiderSpawnChance = new Parameter("Spider spawn chance", 200, 350, this, 10, 1);
       
    }
    
    public void act() {
        // Update parameter bars
        param1.update();
        param2.update();
        numResearchers.update();
        // Check if 'start' button is pressed

        spiderSpawnChance.update();
        
        // Check if 'Finish' button is pressed
        if(startButton.getPressed()) {
            // Save parameters
            ParamStorage.setNumResearchers(numResearchers.getParamValue());
            ParamStorage.setSpiderSpawnChance(spiderSpawnChance.getParamValue());
            
            // Exit SettingsScreen and switch to simulation screen (MyWorld)
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
