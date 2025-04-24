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
    private int DEFAULT_TRANSPARENCY = 200; // default transparency of description box
    
    // Info/description text
    // There are 5 lines of text per powerupinfo!!!!
    private TextLabel[] textLines = new TextLabel[6];
    private Color TEXT_COLOUR = Color.WHITE;
    
    private int sideMargin = 25; // space between left side of boxImage and start x pos of text
    private int spacing = 15; // vertical spacing between each line of text
    
    /**
     * Set image for info box, and create info text
     * 
     * @param givenTexts    Text containing powerup's info. Each index is one line of text
     */
    public PowerupInfo(String[] givenTexts) {
        // Set image of box behind info text
        boxImage = new GreenfootImage("description_box.png");
        boxImage.scale((int)(boxImage.getWidth()*0.7), (int)(boxImage.getHeight()*0.5));
        setImage(boxImage);
        
        for(int i = 0; i < textLines.length; i++) {
            textLines[i] = new TextLabel(givenTexts[i], 15, TEXT_COLOUR);
        }
    }
    
    protected void addedToWorld(World w) {
        addTextLines();
    }
    
    /**
     * Adds TextLabel objects in textLines to world using addObject(), while positioning and spacing out each line
     */
    private void addTextLines() {
        // Add info text at center of box
        int yOffset = -30; // y pos of the first line
        for(TextLabel t : textLines) {
            int xOffset = - (boxImage.getWidth()/2) + sideMargin + (t.getTextWidth()/2);
            
            getWorld().addObject(t, getX() + xOffset, getY() + yOffset);
            
            yOffset += spacing;
        }
    }
    
    public void act()
    {
        
    }
    
    /**
     * Changes description text visually
     * 
     * @param newInfo    New text to change to. All lines are changed
     */
    public void updateInfo(String[] newInfo) {
        for(int i = 0; i < textLines.length; i++) {
            // Remove old TextLabels
            getWorld().removeObject(textLines[i]);
            
            // Replace indexes in arrays with new TextLabels
            textLines[i] = new TextLabel(newInfo[i], 15, TEXT_COLOUR);
            addTextLines();
        }
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
        boxImage.setTransparency(DEFAULT_TRANSPARENCY);
        for(TextLabel t : textLines) {
            t.setColour(TEXT_COLOUR);
        }
    }
}
