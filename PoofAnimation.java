import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Plays 'poof' animtion - a pleasant-looking explosion.
 * 
 * @author Julia
 * @version April 2025
 */
public class PoofAnimation extends Effects
{
    private GreenfootImage[] images = new GreenfootImage[30];
    private int frameCount = 0; // counter of frame number
    
    /**
     * Stores animation frames as images in an array. Only uses every other frame to reduce fps (30 fps --> 15 fps) to reduce lag
     */
    public PoofAnimation() {
        // store image of each frame in array. First frame is index 0
        for(int i = 0; i < images.length; i++) {
            images[i] = new GreenfootImage("poof_anim/tile" + i + ".png");
            images[i].scale(images[i].getWidth()*2, images[i].getHeight()*2);
        }
        setImage(images[0]); // set first frame as default image
    }
    
    public void act()
    {
        // Play animation frames
        if(frameCount < images.length) {
            setImage(images[frameCount]);
            frameCount++;
        } else {
            getWorld().removeObject(this);
        }
    }
}
