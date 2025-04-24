import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResearchPile here.
 * 
 * @author Yuvia Liu 
 * @version April 2025
 */
public class Materials extends Actor
{
    private GreenfootImage piles;
    
    // Progress bar for piles
    private SuperStatBar progressBar;
    
    // link to its Robot object
    private Robot robot;
    
    // Pile count to track and update pile images    
    /**
     * Create materials pile. Each materials pile has its own progress bar and linked robot.
     * 
     * @param robot    The robot linked to this materials pile.
     */
    public Materials(Robot robot) {        
        this.robot = robot;
        piles = new GreenfootImage("pile0.png");
        piles.scale(90, 70);
        setImage(piles);
        
        // Initiate progress bar
        progressBar = new SuperStatBar(100, 0, null, 60, 8, 0, Color.ORANGE, Color.DARK_GRAY);
    }
    
    public void addedToWorld(World w) {
        // Add progress bar
        w.addObject(progressBar, getX(), getY() - 70);
    }
    
    public void increaseProgress(int amount) { 
        if (progressBar != null) {
            int newVal = Math.min(100, progressBar.getCurrentValue() + amount);
            progressBar.update(newVal); // make sure that the two sides are independent
        }

        // Check if robot should add new part
        checkRobotPart();
    }
    
    /**
     * Checks progress bar - if progress bar is full, robot unlocks a new part, and progress bar resets.
     */
    public void checkRobotPart() {
        if(progressBar.getCurrentValue() >= 100) {
            robot.unlockPart();
            
            // Reset the progress bar back to 0
            progressBar.update(0);                    
        }
    }
    
    /**
     * Getter for linked robot.
     * 
     * @return Robot    The robot that's linked to this materials pile
     */
    public Robot getRobot() {
        return robot;
    }
    

    public void updatePileImage(int stage) {
        piles = new GreenfootImage("pile" + stage + ".png");
        piles.scale(90, 70);
        setImage(piles);
    }
}
