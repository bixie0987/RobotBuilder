import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instruction here.
 * 
 * @author Chin-En Hu
 * @version April 2025
 */
public class Instruction extends Actor
{
    private boolean pressed = false;
    
    private GreenfootImage image;

    /**
     * Act - do whatever the Instruction wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Instruction() {
        image = new GreenfootImage("instructions.png");
        setImage(image);
    }
    public void act()
    {
        if(Greenfoot.mousePressed(this)) {
            Sounds.getInstance().playSounds(Sounds.MOUSE_CLICK);
            pressed = true;
        } else {
            pressed = false;
        }
        // Add your action code here.
    }
    public boolean getPressed() {
        return pressed;
    }
}