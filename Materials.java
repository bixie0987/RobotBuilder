import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResearchPile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Materials extends Actor
{
    private GreenfootImage piles;
    private SuperStatBar linkedProgress;
    private String side;  // "left" or "right"

    /**
     * Act - do whatever the ResearchPile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Materials(SuperStatBar progressBar, String side) {
        this.side = side;
        this.linkedProgress = progressBar;
        piles = new GreenfootImage("woodpiles.png"); // set up images
        piles.scale(90, 90);                          
        setImage(piles);
    }
    
    public void increaseProgress(int amount) { 
        if (linkedProgress != null) {
            int newVal = Math.min(100, linkedProgress.getCurrentValue() + amount);
            linkedProgress.update(newVal); // make sure that the two sides are independent
        }
        
        if ("left".equals(side)) {
            MyWorld world = (MyWorld) getWorld();
            world.checkAndUnlockLeftPart();
        }
                
        if ("right".equals(side)) {
            MyWorld world = (MyWorld) getWorld();
            world.checkAndUnlockRightPart();
        }
    }
    
    public String getSide() {
        return side; // getter
    }
    
}
