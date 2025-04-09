import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends SuperSmoothMover
{
    private int stage = 0;
    
    private GreenfootImage image;
    
    public Robot(String type, double scale) {
        image = new GreenfootImage("robot_" + type + ".png");
        image.scale((int)(image.getWidth()*scale), (int)(image.getHeight()*scale));
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
