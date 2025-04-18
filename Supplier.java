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
        supplier = new GreenfootImage("supplier.png");
        setImage(supplier);
    }
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        setRotation(-90);
        if (getX() < 512) {
            move(speedLeft);
        }
        if (getX() > 512) {
            move(speedRight);
        }
        
        // determine which side is touched
        Materials touchedPile = (Materials) getOneIntersectingObject(Materials.class);
        if (getX() < 512) {
            if (touchedPile != null) {
                touchedPile.increaseProgress(world.supplierContributionLeft);  // Only the touched pile's bar increases
                getWorld().removeObject(this);
                //System.out.println("good " + world.supplierContributionLeft);
            }
        } else {
            if (touchedPile != null) {
                touchedPile.increaseProgress(world.supplierContributionRight);  // Only the touched pile's bar increases
                getWorld().removeObject(this);
                //System.out.println("bad " + world.supplierContributionRight);
            }
        }
    }
    public void boostSupplierLeft() {
        if (getX() < 512) {
            speedLeft *= 2;
        }
    }
    public void boostSupplierRight() {
        if (getX() > 512) {
            speedRight *= 2;
        }
    }
}
