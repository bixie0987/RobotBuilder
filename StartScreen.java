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
    
    private int delay = 120;
    private boolean researcher = false;
    private boolean supplier = false;
    private int countdown1 = 300;
    private int countdown2 = 300;
    
    private ResearcherText researcherText;
    private SupplierText supplierText;
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
        if (delay > 0) {
            delay--;
            return;
        }
        spawn();
    }
    
    public void spawn() {
        if (!researcher) {
            addObject(researcherText, 512, 400);
            researcher = true;
        }
        if (countdown1 > 0) {
            countdown1--;
            return;
        }
        if (researcherText != null) {
            removeObject(researcherText); // remove researcherText after countdown
            researcherText = null;
        }
        if (!supplier) {
            addObject(supplierText, 512, 400);
            supplier = true;
        }
        if (countdown2 > 0) {
            countdown2--;
            return;
        }
        if (supplierText != null) {
            removeObject(supplierText); // remove supplierText after countdown
            supplierText = null;
        }
    }
}
