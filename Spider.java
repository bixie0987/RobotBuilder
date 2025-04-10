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
    private boolean onLeft; //boolean for if it's on the left or right side
    /**
     * Spider constructor
     */
    public Spider(String team){
        setImage("spider.png");
        this.team = team;
        if(team.equals("Left")){
            onLeft = true;
        }
        else{
            onLeft = false;
        }
    }

    public void addedToWorld(World w){
        setRotation(90);
        if(team.equals("Right")){
            exitXCoord = w.getWidth()/2 - 100;
        }
        else{
            exitXCoord = w.getWidth()/2 + 100;
        }
        Sounds.getInstance().playSounds(Sounds.SPIDER_SPAWN);
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
    /**
     * Returns the side that the spider came from. Researches who come from the
     * same side should not attack spiders on the same side.
     */
    public boolean getSide(){
        return onLeft; 
    }

}
