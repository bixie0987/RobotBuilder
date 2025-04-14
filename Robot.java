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
    private int NUM_STAGES = 5; // TO BE DETERMINED!!!!!
    
    private GreenfootImage image;
    
    // Material progress bars at the top (Array of SuperStatBars - each square is one stat bar)
    // TO BE CHANGED LATER!!!!! 5 IS TEMP. NUMBER OF STAGES
    private SuperStatBar[] matProgBars = new SuperStatBar[NUM_STAGES]; // matProgBars - 'material progress bars'
    
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
            w.addObject(matProgBars[i], this.getX()-150 + 80*i, 80);
        }
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    /**
     * Prepares robot for next stage of material - plays poof animation, changes robot image, updates material progress bar UNFINISHED!!!
     */
    public void stageUp() {
        // Play poof animation
        getWorld().addObject(new PoofAnimation(), getX(), getY());
        
        // Change appearance UNFINISHED!!!!
        
        // Update material progress bar
        matProgBars[stage].update(1); // change current stage box to be completed (set its currVal to 1)
        if(stage < NUM_STAGES-1) {
            stage++;
        } else {
            // Trigger endgame screen
            ((MyWorld)getWorld()).endGame(); // must cast getWorld(), which returns World, to MyWorld specifically, bc endGame() method is only found in MyWorld (which is a subclass of World))
        }
    }
    
    public int getStage() {
        return stage;
    }
}
