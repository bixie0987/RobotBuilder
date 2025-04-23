import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class textBubbles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBubbles extends Actor
{
    private GreenfootImage[] images;
    private int textCooldown = 300;
    private boolean set = false;
    private boolean switched = false;
    /**
     * Act - do whatever the textBubbles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TextBubbles() {
        images = new GreenfootImage[3];
        //adds images to the array
        images[0] = new GreenfootImage("firstText.png");
        images[1] = new GreenfootImage("secondText.png");
    }
    
    public void act()
    {
        if (set == false) {
            setImage(images[0]);
            set = true;
        }
        if (textCooldown > 0) {
            textCooldown--;
            return;
        } else {
            if (switched == false) {
                setImage(images[1]);
                switched = true;
            }
        }
        // Add your action code here.
    }
}
