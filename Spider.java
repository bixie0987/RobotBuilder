import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spider extends SuperSmoothMover
{
    private String team; //team for where the spider is spawned
    private int exitXCoord;
    /**
     * 
     */
    public Spider(String team){
        setImage("spider.png");
        this.team = team;
    }

    public void addedToWorld(World w){
        setRotation(90);
        if(team.equals("Right")){
            exitXCoord = w.getWidth()/2 - 100;
        }
        else{
            exitXCoord = w.getWidth()/2 + 100;
        }
    }

    /**
     * Act - do whatever the Spider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(1);
        if(getY()==750){ //if reached the coordinates of tubes
            setLocation(exitXCoord, getY());
            setRotation(-90);
        }
    }
}