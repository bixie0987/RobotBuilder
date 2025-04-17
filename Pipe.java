import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pipe extends Actor
{
    /**
     * Act - do whatever the Pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image;
    public Pipe (String imageName, double scale) {
        image = new GreenfootImage(imageName);
        image.scale((int)(image.getWidth()*scale), (int)(image.getHeight()*scale));
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
