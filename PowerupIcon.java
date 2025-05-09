import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a hover-able icon for powerups (that displays powerup's info when user's mouse hovers over the icon).
 * 
 * @author Julia 
 * @version April 19
 */
public class PowerupIcon extends Actor
{
    // Info text. Each item in the array is one line of text
    // There are max 5 lines of text!!!
    private String[] textLines = new String[6];
    
    private GreenfootImage image;
    
    // Related description to this powerup
    private PowerupInfo info;
    // offset x- and y-values for info
    private int infoX = 0;
    private int infoY = 90;
    
    // Whether or not info text box appears on hover
    private boolean isHoverable = true;

    /**
     * Creates powerup icon image and description text
     * 
     * @param imageFile         Name of icon's image file
     * @param size              Size multiplier to scale icon's image to
     * @param givenTextLines    Text for the powerup info/description; each item in the array is one line of text. There must be 5 items/lines of text for each powerup! To have a blank line, leave an empty string (i.e. "")
     */
    public PowerupIcon(String imageFile, double size, String[] givenTextLines)
    {
        // code for default icon image
        image = new GreenfootImage(imageFile);
        image.scale((int)(image.getWidth()*size), (int)(image.getHeight()*size));
        setImage(image);
        
        // set text. Each index is one line
        for(int i = 0; i < textLines.length; i++) {
            textLines[i]  = givenTextLines[i];
        }
    }
    
    public void addedToWorld(World w) {
        // create info text box
        info = new PowerupInfo(textLines);
        w.addObject(info, getX()+infoX, getY()-infoY);
    }
    
    public void act() {
        // If mouse is hovering over upgrade, show upgrade description. Otherwise, hide description.
        if(Greenfoot.getMouseInfo() != null) {
            if(isHovering() && isHoverable) {
                info.show();
            } else {
                info.hide();
            }
        }
    }
    
    public boolean isHovering() {
        int mouseX = Greenfoot.getMouseInfo().getX();
        int mouseY = Greenfoot.getMouseInfo().getY();
        int x = getX();
        int y = getY();
        int halfWidth = getImage().getWidth()/2;
        int halfHeight = getImage().getHeight()/2;
        
        // all 4 edges of the upgrade icon's image
        int leftSide = x - halfWidth;
        int rightSide = x + halfWidth;
        int top = y - halfHeight;
        int bottom = y + halfHeight;
        
        if(mouseX > leftSide && mouseX < rightSide && mouseY > top && mouseY < bottom) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Updates powerup icon's info text description
     * 
     * @param newText    New text to change to; must include all lines of info box, even the unchanged ones
     */
    public void updateInfoText(String[] newText) {
        // Update the values of all the textLines
        for(int i = 0; i < textLines.length; i++) {
            textLines[i] = newText[i];
        }
        
        // Visually update the info text
        info.updateInfo(textLines);
    }
    
    public void hide() {
        image.setTransparency(0);
        info.hide();
        isHoverable = false; // disable hovering feature
    }
    
    public void show() {
        image.setTransparency(255);
        info.show();
        isHoverable = true;
    }
}
