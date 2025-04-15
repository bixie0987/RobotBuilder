import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Julia
 * @version April 2025
 */
public class SettingsScreen extends World
{
    private GreenfootImage background;
    
    private Parameter param1, param2, numResearchers, spiderSpawnChance;
    
    private Button finishButton; // button to exit SettingsScreen, save parameters and start simulation
    
    /**
     * Constructor for objects of class SettingsScreen.
     */
    public SettingsScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        background = new GreenfootImage("settingsScreen.png");
        background.scale((int)(background.getWidth()*0.885), (int)(background.getHeight()*0.885));
        setBackground(background);
        
        // Create title text, 'Settings'
        TextLabel title = new TextLabel("Settings", 40, Color.WHITE);
        addObject(title, getWidth()/2, 40);
        
        // Create parameters (including their corresponding buttons/bars)
        int paramX = 100;
        numResearchers = new Parameter("Number of researchers", paramX, 300, this, 4, 1);
        spiderSpawnChance = new Parameter("Spider spawn chance", paramX, 350, this, 10, 1);
        
        // Create 'Finish' button
        finishButton = new Button("finish.png", 0.3);
        addObject(finishButton, 500, 600);
    }
    
    public void act() {
        // Update parameter bars
        param1.update();
        param2.update();
        numResearchers.update();
        spiderSpawnChance.update();
        
        // Check if 'Finish' button is pressed
        if(finishButton.getPressed()) {
            // Save parameters
            ParamStorage.setNumResearchers(numResearchers.getParamValue());
            ParamStorage.setSpiderSpawnChance(spiderSpawnChance.getParamValue());
            
            // Exit SettingsScreen and switch to simulation screen (MyWorld)
            Greenfoot.setWorld(new MyWorld());
            ParamStorage.printAll();
        }
    }
}
