import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Controls robots' appearance, animation, and behaviour
 * 
 * @author Julia
 * @version April 2025
 */
public class Robot extends SuperSmoothMover
{
    private int stage = 0; // stage of material. First stage is 0!!
    private int NUM_STAGES = 3;
    
    private GreenfootImage image;
    
    private SuperStatBar[] matProgBars = new SuperStatBar[NUM_STAGES];
    
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

    public void addedToWorld(World w) {
        // Create material progress bars
        for(int i = 0; i < matProgBars.length; i++) {
            matProgBars[i] = new SuperStatBar(1, 0, null, 30, 30, 0); // each progress 'box' is a superstatbar, but with maxVal 1 (unfinished stages: currVal = 0; finished stages: currVal = 1)
            w.addObject(matProgBars[i], this.getX()-150 + 160*i, 80);
        }
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
