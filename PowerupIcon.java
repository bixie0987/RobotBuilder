import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass of all Powerup icons. Creates a hover-able icon (that displays powerup's info when user's mouse hovers over the icon)
 * 
 * @author Julia 
 * @version April 19
 */
public class PowerupIcon extends Actor
{
    // Variables SPECIFIC to each powerup icon (these are instantiated in each PowerupIcon subclass' constructor)
    protected String INFO_TEXT = "test description"; // default powerup icon text
    protected GreenfootImage image = new GreenfootImage("powerup_icon.png"); // default icon image
    
    // Whether or not this icon's related powerup has just been activated
    protected boolean ACTIVATED;
    
    // Related description to this powerup
    private PowerupInfo info;
    // offset x- and y-values for info
    private int infoX = 100;
    private int infoY = 100;

    /**
     * Constructor for objects of class Powerup
     */
    public PowerupIcon()
    {
        // code for default icon image
        image.scale((int)(image.getWidth()*0.08), (int)(image.getHeight()*0.08));
        setImage(image);
    }
    
    protected void addedToWorld(World w) {
        info = new PowerupInfo(INFO_TEXT);
        w.addObject(info, getX()+infoX, getY()-infoY);
    }
    
    public void act() {
        // If mouse is hovering over upgrade, show upgrade description. Otherwise, hide description.
        if(Greenfoot.getMouseInfo() != null) {
            if(isHovering()) {
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
    
    public boolean getActivated() {
        return ACTIVATED;
    }
}
