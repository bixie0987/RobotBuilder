import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen for user to set the settings/parameters of simulation.
 * 
 * @author Julia
 * @version April 2025
 */
public class SettingsScreen extends World
{
    private GreenfootImage background;
    
    private Parameter numResearchersGood, spiderSpawnChanceGood;
    private Parameter numResearchersEvil, spiderSpawnChanceEvil;

    private Button startButton; // button to exit SettingsScreen, save parameters and start simulation  
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
        addObject(title, getWidth()/2, 70);
        
        // Create parameters (including their corresponding buttons/bars)
        // Good robot params
        int paramX = 80;
        numResearchersGood = new Parameter("Number of researchers", paramX, 300, this, 4, 1);
        spiderSpawnChanceGood = new Parameter("Spider spawn chance", paramX, 350, this, 10, 1);
        // Evil robot params
        paramX = 540;
        numResearchersEvil = new Parameter("Number of researchers (evil)", paramX, 300, this, 4, 1);
        spiderSpawnChanceEvil = new Parameter("Spider spawn chance (evil)", paramX, 350, this, 10, 1);
        
        // Create 'start' button
        startButton = new Button("startBUTT.png", 0.5);
        addObject(startButton, 500, 500);
    }
    
    public void act() {
        // Update parameter bars
        numResearchersGood.update();
        spiderSpawnChanceGood.update();
        numResearchersEvil.update();
        spiderSpawnChanceEvil.update();
        
        // Check if 'Start' button is pressed
        if(startButton.getPressed()) {
            // Save parameters
            ParamStorage.setNumResearchersGood(numResearchersGood.getParamValue());
            ParamStorage.setSpiderSpawnChanceGood(spiderSpawnChanceGood.getParamValue());
            ParamStorage.setNumResearchersEvil(numResearchersEvil.getParamValue());
            ParamStorage.setSpiderSpawnChanceEvil(spiderSpawnChanceEvil.getParamValue());
            
            // Exit SettingsScreen and switch to simulation screen (MyWorld)
            Greenfoot.setWorld(new MyWorld());
            ParamStorage.printAll();
        }
    }
}
