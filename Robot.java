import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Controls robots' appearance, animation, and behaviour
 * 
 * @author Julia
 * @version April 2025
 */
public class Robot extends SuperSmoothMover
{
    private int robotPart = 0; // From 0 to 6 (for 6 total parts of robot)
    private int stage = 0; // each stage is one type of material. First stage is 0!!
    private int NUM_STAGES = 3; // total number of stages (materials)
    private SuperStatBar[] matProgBars = new SuperStatBar[NUM_STAGES]; // progress squares at the top - represents material stage
    
    private GreenfootImage baseImage;
    
    private String type; // "good" for left robot, "evil" for right robot
    
    /**
     * Sets robot's image
     * 
     * @param type     "good" for viewer's robot (left), "evil" for opposing robot (right)
     * @param scale    Multiplier to scale the image to
     */
    public Robot(String type) {
        this.type = type;
        
        // Robot starts with a transparent base image (just a transparent rectangle shape)
        // As parts are unlocked, the part images are drawn on top of the base image.
        baseImage = new GreenfootImage(300, 380);
        baseImage.setColor(new Color(0, 0, 0, 0)); // transparent
        baseImage.fill(); // apply the transparent colour
        setImage(baseImage);
    }
    
    public void addedToWorld(World w) {
        // Create material progress bars
        for(int i = 0; i < matProgBars.length; i++) {
            matProgBars[i] = new SuperStatBar(1, 0, null, 30, 30, 0, new Color(166, 255, 255), new Color(30, 70, 136)); // each progress 'box' is a superstatbar, but with maxVal 1 (unfinished stages: currVal = 0; finished stages: currVal = 1)
            // btw the matProgBars colours are taken from SettingsScreen's parameter bar colours
            
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
        // Reset part counter
        robotPart = 0;
        
        // Play poof animation
        getWorld().addObject(new PoofAnimation(), getX(), getY());
        
        // Update material progress bar
        matProgBars[stage].update(1); // change current stage box to be completed (set its currVal to 1)
        if(stage < NUM_STAGES-1) {
            stage++;
        } else {
            // Trigger endgame screen
            ((MyWorld)getWorld()).endGame(type); // must cast getWorld(), which returns World, to MyWorld specifically, bc endGame() method is only found in MyWorld (which is a subclass of World))
        }
    }
    
    /**
     * Draw the next robot part. If all parts of current stage are unlocked, move on to the next stage (material).
     */
    public void unlockPart() {
        // If all parts are unlocked (robotPart = 6), move on to the next stage/material
        if(robotPart < 6) {
            robotPart++;
            
            // Create partImage
            // sample image file location: robot_parts_evil/stage0/part1.png
            GreenfootImage partImage = new GreenfootImage("robot_parts_" + type + "/stage" + stage + "/part" + robotPart + ".png");
            partImage.scale((int)(partImage.getWidth()*0.49), (int)(partImage.getHeight()*0.49));
            
            // Center partImage on baseImage
            // Calculate top-left position to center the part on the base
            int x = (baseImage.getWidth() - partImage.getWidth()) / 2;
            int y = (baseImage.getHeight() - partImage.getHeight()) / 2;
            
            // Draw partImage on baseImage
            baseImage.drawImage(partImage, x, y);
            setImage(baseImage);
        } else {
            stageUp();
        }
    }
}
