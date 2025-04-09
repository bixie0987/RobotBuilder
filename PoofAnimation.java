import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Plays 'poof' animation - a pleasant-looking explosion.
 * 
 * @author Julia
 * @version April 2025
 */
public class PoofAnimation extends Actor
{
    private GreenfootImage[] images = new GreenfootImage[15]; // 15 frames instead of original 30 - to reduce lag/improve performance
    private int frameCount = 0; // counter of frame number
    private int curFrame = 0; // to slow down animation
    
    /**
     * Stores animation frames as images in an array. Only uses every other frame to reduce fps (30fps --> 15fps) to reduce lag
    */
    public PoofAnimation() {
        // store image of each frame in array. First frame is index 0
        for(int i = 0; i < images.length; i++) {
            images[i] = new GreenfootImage("poof_anim/tile" + (i*2) + ".png");  // 2 multiplier - halve the number of frames
        }
        setImage(images[0]); // set first frame as default image
    }
    
    public void act()
    {
        // play animaton frames
        if(curFrame % 2 == 0) { // slow down fps by half
            if(frameCount < images.length) {
                setImage(images[frameCount]);
                frameCount++;
            } else {
                getWorld().removeObject(this);
            }
        }
        curFrame++;
    }
}
