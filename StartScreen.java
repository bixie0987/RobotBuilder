import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author Chin-En Hu
 * @version April 2025
 */
public class StartScreen extends World
{
    private GreenfootImage background;
    
    private int delay = 198;
    
    //booleans to ensure it doesn't spawn objects more than once
    private boolean sound = false;
    private boolean researcher = false;
    private boolean supplier = false;
    private boolean removed = false;
    private boolean added = false;
    private int countdown1 = 300;
    private int countdown2 = 300;
    
    private Instruction instructions;
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
        if (!sound) {
            Greenfoot.playSound("police_siren.mp3");
            sound = true;
        }
        if (delay > 0) {
            delay--;
            return;
        }
        spawn();
    }
    
    public void spawn() {
        if (!researcher) {
            addObject(new ResearcherText(), 256, 300);
            researcher = true;
        }
        if (countdown1 > 0) {
            countdown1--;
            return;
        }
        if (!supplier) {
            addObject(new SupplierText(), 768, 500);
            supplier = true;
        }
        if (countdown2 > 0) {
            countdown2--;
            return;
        }
        if (!removed) {
            for (Object obj : getObjects(Actor.class)) {
                Actor scientist = (Actor) obj;
                removeObject(scientist);
            }
            removed = true;
        }
        if (!added) {
            instructions = new Instruction();
            addObject(instructions, 512, 400);
            added = true;
        }
        if(instructions.getPressed()) {
            // Exit StartScreen and switch to setting screen (SettingScreen)
            Greenfoot.setWorld(new SettingsScreen());
        }
    }
}
