import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Upgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Upgrade extends Actor
{
    private GreenfootImage image;
    
    // Related description to this upgrade
    private UpgradeDescription description;

    /**
     * Constructor for objects of class Upgrade
     */
    public Upgrade()
    {
        image = new GreenfootImage("upgrade_icon.png");
        image.scale((int)(image.getWidth()*0.1), (int)(image.getHeight()*0.1));
        setImage(image);
        
        
    }
    
    protected void addedToWorld(World w) {
        description = new UpgradeDescription();
        w.addObject(description, getX()+100, getY()-100);
    }
    
    public void act() {
        // If mouse is hovering over upgrade, show upgrade description. Otherwise, hide description.
        if(isHovering()) {
            description.show();
        } else {
            description.hide();
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
}
