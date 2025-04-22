import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Supplier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Supplier extends Scientist
{
    /**
     * Act - do whatever the Supplier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage supplier;
    public Supplier(){
        //set image for suppliers
        supplier = new GreenfootImage("supplier.png");
        setImage(supplier);
    }
    public void act()
    {
        setRotation(-90);
        move(2);
        
        // determine which side is touched
        Materials touchedPile = (Materials) getOneIntersectingObject(Materials.class);
        if (touchedPile != null) {
            touchedPile.increaseProgress(7);  // Only the touched pile's bar increases
            getWorld().removeObject(this);
        }
    }
    
}
