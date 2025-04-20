import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerupInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerupInfo extends Actor
{
    // Image of box behind the info text
    private GreenfootImage boxImage;
    
    // Info/description text
    private TextLabel text;
    
    /**
     * Set image for info box, and create info text
     * 
     * @param infoText    Text containing powerup's info
     */
    public PowerupInfo(String infoText) {
        // Set image of box behind info text
        boxImage = new GreenfootImage("description_box.png");
        boxImage.scale((int)(boxImage.getWidth()*0.1), (int)(boxImage.getHeight()*0.1));
        setImage(boxImage);
        
        text = new TextLabel(infoText, 20, Color.BLACK);
    }
    
    protected void addedToWorld(World w) {
        // Add info text at center of box
        w.addObject(text, getX(), getY());
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    /**
     * Hide info box from view (default)
     */
    public void hide() {
        boxImage.setTransparency(0);
        text.setColour(new Color(0, 0, 0, 0));
    }
    
    /**
     * Show description (should activate when mouse hovers over upgrade icon)
     */
    public void show() {
        boxImage.setTransparency(255);
        text.setColour(Color.BLACK);
    }
}
