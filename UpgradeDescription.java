import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeDescription here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeDescription extends Actor
{
    // Image of box behind the description text
    private GreenfootImage boxImage;
    
    // Description text
    private TextLabel text;
    
    /**
     * Set image for description's box, and create description's text
     * 
     * @param descriptionText    Text describing the upgrade
     */
    public UpgradeDescription(String descriptionText) {
        // Set image of box behind description
        boxImage = new GreenfootImage("description_box.png");
        boxImage.scale((int)(boxImage.getWidth()*0.1), (int)(boxImage.getHeight()*0.1));
        setImage(boxImage);
        
        text = new TextLabel(descriptionText, 20, Color.BLACK);
    }
    
    protected void addedToWorld(World w) {
        // Add description text at center of box
        w.addObject(text, getX(), getY());
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    /**
     * Hide description from view (default)
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
