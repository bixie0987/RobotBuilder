import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Controls robots' appearance, animation, and behaviour
 * 
 * @author Julia
 * @version April 2025
 */
public class Robot extends SuperSmoothMover
{
    private int stage = 0; // stage of material
    
    private GreenfootImage image;
    
    /**
     * Sets robot's image
     * 
     * @param type     "good" for viewer's robot (left), "evil" for opposing robot (right)
     * @param scale    Multiplier to scale the image to
     */
    public Robot(String type, double scale) {
        image = new GreenfootImage("robot_" + type + ".png");
        image.scale((int)(image.getWidth()*scale), (int)(image.getHeight()*scale));
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    /**
     * Prepares robot for next stage of material - play poof animation, change robot image UNFINISHED!!!
     */
    public void stageUp() {
        stage++;
        getWorld().addObject(new PoofAnimation(), getX(), getY());
    }
}
