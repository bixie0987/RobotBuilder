import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The description box of each powerup icon
 * 
 * @author Julia
 * @version April 2025
 */
public class PowerupInfo extends Actor
{
    // Image of box behind the info text
    private GreenfootImage boxImage;
    
    // Info/description text
    // There are 5 lines of text per powerupinfo!!!!
    private TextLabel[] textLines = new TextLabel[5];
    
    /**
     * Set image for info box, and create info text
     * 
     * @param givenTexts    Text containing powerup's info. Each index is one line of text
     */
    public PowerupInfo(String[] givenTexts) {
        // Set image of box behind info text
        boxImage = new GreenfootImage("description_box.png");
        boxImage.scale((int)(boxImage.getWidth()*0.1), (int)(boxImage.getHeight()*0.1));
        setImage(boxImage);
        
        for(int i = 0; i < textLines.length; i++) {
            textLines[i] = new TextLabel(givenTexts[i], 15, Color.BLACK);
        }
    }
    
    protected void addedToWorld(World w) {
        // Add info text at center of box
        int y = -30; // y pos of the first line
        for(TextLabel t : textLines) {
            w.addObject(t, getX(), getY() + y);
            y += 13;
        }
    }
    
    public void act()
    {
        
    }
    
    /**
     * Hide info box from view (should be default)
     */
    public void hide() {
        boxImage.setTransparency(0);
        for(TextLabel t : textLines) {
            t.setColour(new Color(0, 0, 0, 0));
        }
    }
    
    /**
     * Show description (should activate when mouse hovers over upgrade icon)
     */
    public void show() {
        boxImage.setTransparency(255);
        for(TextLabel t : textLines) {
            t.setColour(Color.BLACK);
        }
    }
}
