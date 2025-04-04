import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private GreenfootImage background;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        background = new GreenfootImage("background01.png");
        setBackground(background);

    }
    
    public void act(){
        spawn();
    }
    
    public void spawn(){
        int spawnChance = 100;
        int randNum = Greenfoot.getRandomNumber(100); //spawn random num from 0-99, for spawn chances
        if(randNum < spawnChance){ //chance for a spider to spawn. change logic
            addObject(new Spider("Right"), 300, 800); //added random nums for x and y for now
            //x and y should change based on team
        }
    }
}
