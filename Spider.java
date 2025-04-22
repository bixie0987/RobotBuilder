import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manages spider's behaviour and image
 * 
 * @Elise Liu
 * @version April 2025
 */
public class Spider extends SuperSmoothMover
{
    private String team; //team for where the spider is spawned
    private int exitXCoord;
    /**
     * Sets the spider's image
     * 
     * @param team  The team side the spider should spawn from. "Left" for left side, "Right" for right side.
     */
    public Spider(String team){
        setImage("spider.png");
        this.team = team;
    }

    /**
     * Sets the rotation of the spider and sets where it'll appear after going
     * into the tubes. Also plays a sound effect upon spawning.
     * 
     * @param w     The world that the spider is added in.
     */
    public void addedToWorld(World w){
        setRotation(90);
        if(team.equals("Right")){
            exitXCoord = w.getWidth()/2 - 120;
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
}