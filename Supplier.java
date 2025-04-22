import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Supplier here.
 * 
 * @author Yuvia Liu, Jaclyn
 * @version April 2025
 */
public class Supplier extends Scientist
{
    /**
     * Act - do whatever the Supplier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage supplier;
    private int speedLeft = 2;
    private int speedRight = 2;
    public Supplier(){
        //set image for suppliers
        supplier = new GreenfootImage("supplier.png");
        setImage(supplier);
    }
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        setRotation(-90);
        if (getX() < 512) {
            move(world.speedLeft);
        }
        if (getX() > 512) {
            move(world.speedRight);
        }
        
        // determine which side is touched
        Materials touchedPile = (Materials) getOneIntersectingObject(Materials.class);
       

        if (getX() < 512) {
            if (touchedPile != null) {
                touchedPile.increaseProgress(world.supplierContributionLeft);  // Only the touched pile's bar increases
                getWorld().removeObject(this);
                return;
                //System.out.println("good " + world.supplierContributionLeft);
            }
        }
        if (getX() > 512) {
            if (touchedPile != null) {
                touchedPile.increaseProgress(world.supplierContributionRight);  // Only the touched pile's bar increases
                getWorld().removeObject(this);
                //System.out.println("bad " + world.supplierContributionRight);
            }
        }
    }
}
