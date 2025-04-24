import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Supplier here.
 * 
 * @author Yuvia Liu, Jaclyn, Chin-En Hu
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
        
        List<Materials> leftPileList = getWorld().getObjectsAt(455, 430, Materials.class);
        List<Materials> rightPileList = getWorld().getObjectsAt(545, 430, Materials.class);
        // determine which side is touched
        Materials touchedPileLeft = (leftPileList.isEmpty()) ? null : leftPileList.get(0);
        
        Materials touchedPileRight = (rightPileList.isEmpty()) ? null : rightPileList.get(0);

        if (getX() == 475 && getY() > 420 && getY() < 440 && touchedPileLeft != null) {
            touchedPileLeft.increaseProgress(world.supplierContributionLeft);  // Only the touched pile's bar increases
            getWorld().removeObject(this);
            return;
            //System.out.println("good " + world.supplierContributionLeft);
        }
        if (getX() == 535 && getY() > 420 && getY() < 440 && touchedPileRight != null) {        
            touchedPileRight.increaseProgress(world.supplierContributionRight);  // Only the touched pile's bar increases
            getWorld().removeObject(this);
            //System.out.println("bad " + world.supplierContributionRight);
        }
    }
}
