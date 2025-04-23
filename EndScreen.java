import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * EndScreen displays the victory screen for the game.
 * It shows either the good or evil team's victory image and plays a confetti animation.
 * 
 * @author Yuvia Liu 
 * @version April 2025
 */
public class EndScreen extends World
{
    private int confettiTimer = 0;            // Timer to track the frames passed since entering EndScreen

    private int confettiSpawned = 0;
    private final int MAX_CONFETTI = 5;       // Total confetti to spawn
    private final int MAX_FRAMES = 60;         // Spread across ~1 seconds
    private GreenfootImage endscreen;
    /**
     * Constructor for objects of class EndScreen.
     * 
     * @param winner  A string indicating the winner ("good" or "evil") 
     */
    public EndScreen(String winner){   
        super(1024, 800, 1);
        GreenfootImage endscreen;
        if (winner.equals("good")) {
            endscreen = new GreenfootImage("endscreen1.PNG");
        } else {
            endscreen = new GreenfootImage("endscreen2.PNG");
        }
        
        setBackground(endscreen);
        endscreen.scale(1024, 800);
        Sounds.getInstance().playSounds(Sounds.WIN_SOUND);
    }
    public void act()
    {
        // Continue spawning confetti until the maximum number is reached
        if (confettiSpawned < MAX_CONFETTI) {
            confettiTimer++;
    
        // About 25% chance per frame, stops once 10 are spawned
            if (Greenfoot.getRandomNumber(MAX_FRAMES) < 2) {
                int x = Greenfoot.getRandomNumber(getWidth());
                int y = Greenfoot.getRandomNumber(getHeight());
                addObject(new ConfettiAnimation(), x, y);   // Add confetti burst at that location
                confettiSpawned++;
            }
        }

    }
}
