import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass of all Powerup icons. Creates a hover-able icon (that displays powerup's info when user's mouse hovers over the icon)
 * 
 * @author Julia 
 * @version April 19
 */
public class PowerupIcon extends Actor
{
    // Variables SPECIFIC to each powerup icon
    private String INFO_TEXT = "test description"; // default powerup icon text
    private GreenfootImage image;
    
    // Related description to this powerup
    private PowerupInfo info;
    // offset x- and y-values for info
    private int infoX = 20;
    private int infoY = 90;
    
    // Whether or not info text box appears on hover
    private boolean isHoverable = true;

    /**
     * Constructor for objects of class Powerup
     */
    public PowerupIcon(String imageFile, double size)
    {
        // code for default icon image
        image = new GreenfootImage(imageFile);
        image.scale((int)(image.getWidth()*size), (int)(image.getHeight()*size));
        setImage(image);
    }
    
    public void addedToWorld(World w) {
        info = new PowerupInfo(INFO_TEXT);
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
