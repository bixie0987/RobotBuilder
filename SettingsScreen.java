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
    
    private Parameter numResearchersGood, spiderSpawnChanceGood;
    private Parameter numResearchersEvil, spiderSpawnChanceEvil;
    
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
        // Good robot params
        int paramX = 80;
        numResearchersGood = new Parameter("Number of researchers", paramX, 300, this, 4, 1);
        spiderSpawnChanceGood = new Parameter("Spider spawn chance", paramX, 350, this, 10, 1);
        // Evil robot params
        paramX = 540;
        numResearchersEvil = new Parameter("Number of researchers (evil)", paramX, 300, this, 4, 1);
        spiderSpawnChanceEvil = new Parameter("Spider spawn chance (evil)", paramX, 350, this, 10, 1);
        
        // Create 'Finish' button
        finishButton = new Button("finish.png", 0.3);
        addObject(finishButton, 500, 600);
    }
    
    public void act() {
        // Update parameter bars
        numResearchersGood.update();
        spiderSpawnChanceGood.update();
        numResearchersEvil.update();
        spiderSpawnChanceEvil.update();
        
        // Check if 'Finish' button is pressed
        if(finishButton.getPressed()) {
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
