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
    
    private int delay = 198;
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
        
        researcherText = new ResearcherText();
        supplierText = new SupplierText();
    }
    
    public void act() {
        if (!sound) {
            Greenfoot.playSound("police_siren.wav");
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
