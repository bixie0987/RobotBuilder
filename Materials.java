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
    /**
     * Act - do whatever the ResearchPile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Materials()
    {
        piles = new GreenfootImage("woodpiles.png"); 
        piles.scale(90, 90);                          
        setImage(piles);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
