import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeSupplierSpeed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeSupplierSpeed extends Upgrade
{
    private GreenfootImage image;
    
    public UpgradeSupplierSpeed() {
        image = new GreenfootImage("upgrade_icon.png");
        image.scale((int)(image.getWidth()*0.1), (int)(image.getHeight()*0.1));
        setImage(image);
    }
}
