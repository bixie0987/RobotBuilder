import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author Yuvia Liu 
 * @version April 2025
 */
public class EndScreen extends World
{
    private int confettiTimer = 0;
    private int confettiSpawned = 0;
    private final int MAX_CONFETTI = 5;       // Total confetti to spawn
    private final int MAX_FRAMES = 60;         // Spread across ~1 seconds
    private GreenfootImage endscreen;
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen(String winner)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1);
        GreenfootImage endscreen;
        if (winner.equals("good")) {
            endscreen = new GreenfootImage("endscreen1.PNG");
        } else {
            endscreen = new GreenfootImage("endscreen2.PNG");
        }
        
        setBackground(endscreen);
        endscreen.scale(1024, 800);
      
    }
    
    public void act()
    {
        if (confettiSpawned < MAX_CONFETTI) {
            confettiTimer++;
    
        // About 25% chance per frame, stops once 10 are spawned
            if (Greenfoot.getRandomNumber(MAX_FRAMES) < 2) {
                int x = Greenfoot.getRandomNumber(getWidth());
                int y = Greenfoot.getRandomNumber(getHeight());
                addObject(new ConfettiAnimation(), x, y);
                confettiSpawned++;
            }
        }

    }
}
