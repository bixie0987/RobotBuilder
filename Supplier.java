import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Supplier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        if(this.isTouching(Materials.class)){
            MyWorld world = (MyWorld) getWorld();
            world.increaseProgress(5);  // increase by 2 every time it touches
            getWorld().removeObject(this);
        }
    }
    
}
