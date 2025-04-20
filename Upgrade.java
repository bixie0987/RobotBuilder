import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass of all upgrades. Creates hover-able icons (that display upgrade description when user's mouse hovers over the icon)
 * 
 * @author Julia 
 * @version April 19
 */
public abstract class Upgrade extends Actor
{
    // Variables SPECIFIC to each upgrade (these are instantiated in each upgrade subclass' constructor)
    protected String DESCRIPTION_TEXT;
    
    protected boolean ACTIVATED;
    
    // Related description to this upgrade
    private UpgradeDescription description;

    /**
     * Constructor for objects of class Upgrade
     */
    public Upgrade()
    {
        
    }
    
    protected void addedToWorld(World w) {
        description = new UpgradeDescription(DESCRIPTION_TEXT);
        w.addObject(description, getX()+100, getY()-100);
    }
    
    protected abstract void activate();
    
    public void act() {
        // If mouse is hovering over upgrade, show upgrade description. Otherwise, hide description.
        if(Greenfoot.getMouseInfo() != null) {
            if(isHovering()) {
                description.show();
            } else {
                description.hide();
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
