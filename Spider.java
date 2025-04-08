import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spider extends SuperSmoothMover
{
    private String team;
    /**chance of spawn should be an integer set by the user. chance of spawn
     * will be an integer from 0-100 that sets how often a spider spawns
     * per 10 seconds
     * team should either be left or right. the team will be who the spider
     * sabotages.
     * 
     */
    public Spider(){
        setImage("spider.png");
    }
    /**
     * Act - do whatever the Spider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public void sabotage(String team){
        
    }
}
