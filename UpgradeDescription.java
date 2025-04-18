import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeDescription here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeDescription extends Actor
{
    private GreenfootImage image;
    
    private TextLabel text;
    
    public UpgradeDescription(String descriptionText) {
        image = new GreenfootImage("description_box.png");
        image.scale((int)(image.getWidth()*0.1), (int)(image.getHeight()*0.1));
        setImage(image);
        
        text = new TextLabel(descriptionText, 20, Color.BLACK);
    }
    
    protected void addedToWorld(World w) {
        w.addObject(text, getX(), getY());
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void hide() {
        image.setTransparency(0);
        text.setColour(new Color(0, 0, 0, 0));
    }
    
    public void show() {
        image.setTransparency(255);
        text.setColour(Color.BLACK);
    }
}
