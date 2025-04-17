import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Supplier here.
 * 
 * @author Yuvia Liu, Jaclyn
 * @version April 2025
 */
public class Supplier extends Scientist
{
    private int supplierTimer;
    /**
     * Act - do whatever the Supplier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setRotation(-90);
        move(2);
        
        // determine which side is touched
        Materials touchedPile = (Materials) getOneIntersectingObject(Materials.class);
        if (touchedPile != null) {
            touchedPile.increaseProgress(10);  // Only the touched pile's bar increases
            getWorld().removeObject(this);
        }
    }
    
}
