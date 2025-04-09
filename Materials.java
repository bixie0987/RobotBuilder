import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResearchPile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Materials extends Actor
{
    private SuperStatBar materialProgress; // progress bar
    /**
     * Act - do whatever the ResearchPile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Materials()
    {
        materialProgress = new SuperStatBar(100, 50, this, 60, 8, 30, Color.ORANGE, Color.DARK_GRAY);
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void addedToWorld(World w) 
    {
        super.addedToWorld(w);
        w.addObject(materialProgress, getX(), getY() + 30);
    }
}
