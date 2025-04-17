import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResearchPile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computer extends Actor
{
    private SuperStatBar researchBar;
    private boolean morality;
    
    public Computer() {
        setImage("researcherComputer.png");
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 20, img.getHeight() / 20);
        setImage(img);
        researchBar = new SuperStatBar(100, 0, null, 60, 8, 0, Color.ORANGE, Color.DARK_GRAY);
    }
    /**
     * Act - do whatever the ResearchPile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (getX() == 250) {
            morality = true;
        } else {
            morality = false;
        }
        // Add your action code here.
    }
}
