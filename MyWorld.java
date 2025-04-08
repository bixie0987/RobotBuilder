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
<<<<<<< Updated upstream
<<<<<<< HEAD

=======
    
    //x spawn coordinate for spiders. this is set for the team on the left
    private int spiderXSpawn = 100;
    
>>>>>>> subs
=======
    
    //x spawn coordinate for spiders. this is set for the team on the left
    private int spiderXSpawn = 100;

>>>>>>> Stashed changes
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
<<<<<<< Updated upstream
<<<<<<< HEAD
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
=======
=======
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
>>>>>>> Stashed changes
        // Create a new world with 1024x800 cells with a cell size of 1x1 pixels.
>>>>>>> subs
        super(1024, 800, 1); 
        background = new GreenfootImage("background01.png");
        setBackground(background);

    }
    
    public void act(){
        spawn();
        spawn("Right");
        spawn("Left");
    }
    
    public void spawn(String teamSide){
        int spawnChance = 100;
        int randNum = Greenfoot.getRandomNumber(100); //spawn random num from 0-99, for spawn chances
        if(teamSide.equals("Right")){ //change coordinates based on spawn side
            spiderXSpawn = 924; //sets spider x coordinate to the right side of the screen
        }
        else{
            spiderXSpawn = 100; //sets spider x coordinate to left side
        }
        if(randNum < spawnChance){ //chance for a spider to spawn. change logic
<<<<<<< Updated upstream
            addObject(new Spider("Right"), 300, 800); //added random nums for x and y for now
            addObject(new Spider(), spiderXSpawn, 600); //added random nums for x and y for now
            //x and y should change based on team
=======
            if(randNum < spawnChance) { //chance for a spider to spawn. change logic//added random nums for x and y for now
                addObject(new Spider(), spiderXSpawn, 600); //added random nums for x and y for now
                //x and y should change based on team
            }
>>>>>>> Stashed changes
        }
    }
}
