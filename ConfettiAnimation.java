import greenfoot.*;

/**
 * FireworkConfetti simulates a "pop" or explosion by zooming in and fading out.
 * It starts small, quickly grows (zooms), then fades out and disappears.
 * 
 * @author Yuvia Liu
 * @version April 2025
 */
public class ConfettiAnimation extends Effects
{
    private GreenfootImage baseImage;  // Confetti image
    private int age = 0;               // Tracks how many frames this confetti has existed
    private final int lifespan = 15;   // Total number of frames before the confetti disappears
    private final double maxScale = 1.5; // Final scale factor (starts from 0.5)

    
    /**
     * Constructor: initializes the confetti image and scales it down initially.
     */
    public ConfettiAnimation() {
        // initiate confetti image
        baseImage = new GreenfootImage("confetti.png");
        baseImage.scale(baseImage.getWidth()/3, baseImage.getHeight()/3); 
        setImage(new GreenfootImage(baseImage));
    }

    public void act()
    {
        age++;    // Increment the age counter each frame
        double scaleFactor;
        if (age <= 6) {
            scaleFactor = 0.5 + 0.1 * age;  // zoom-in effect: 0.5 → 1.1
        } else {
            scaleFactor = maxScale;         // stay at max scale
        }

        int newWidth = (int)(baseImage.getWidth() * scaleFactor);
        int newHeight = (int)(baseImage.getHeight() * scaleFactor);

        GreenfootImage frame = new GreenfootImage(baseImage);
        frame.scale(newWidth, newHeight);

        // Fade out gradually after halfway through lifespan
        int alpha = 255;
        if (age > lifespan / 2) {
            // After halfway point, start fading out
            double fadeProgress = (double)(age - lifespan / 2) / (lifespan / 2);
            alpha = (int)(255 * (1 - fadeProgress));
        }
        frame.setTransparency(Math.max(0, alpha));

        setImage(frame);

        // Remove once the animation completes
        if (age >= lifespan) {
            getWorld().removeObject(this);
        }
    }
}
