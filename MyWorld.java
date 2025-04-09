import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World{
    private GreenfootImage background;
    
    //x spawn coordinate for spiders. this is set for the team on the left
    private int spiderXSpawn = 100;
    //The number of researchers player can choose from 1-4
    private int resNumRight = 4;
    private int resNumLeft = 4;
    
    private int[][] coordsRight = {
        {114, 550}, {228, 550}, {342, 550}, {456, 550}
    };
    
    private int[][] coordsLeft = {
        {912, 550}, {798, 550}, {684, 550}, {570, 550} 
    };
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
    public MyWorld()
    {      
        // Create a new world with 1024x800 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        background = new GreenfootImage("background01.png");
        setBackground(background);

    }
    
    public void act(){
        spawn("Right");
        spawn("Left");
        
        if(Greenfoot.isKeyDown("up")) {
            SettingsScreen s = new SettingsScreen();
            Greenfoot.setWorld(s);
        }
    }
    
    public void spawn(String teamSide){
        int spawnChance = 1;
        int randNum = Greenfoot.getRandomNumber(100); //spawn random num from 0-99, for spawn chances
        if(teamSide.equals("Right")){ //change coordinates based on spawn side
            spiderXSpawn = 924; //sets spider x coordinate to the right side of the screen
        }
        else{
            spiderXSpawn = 100; //sets spider x coordinate to left side
        }

        if(randNum == spawnChance){ //chance for a spider to spawn. change logic//added random nums for x and y for now
            addObject(new Spider(teamSide), spiderXSpawn, 600); //added random nums for x and y for now
            //x and y should change based on team
        }
            
    }
    
    public void spawn(int rightSide, int leftSide) {
        for (int i = 0; i < rightSide; i++) {
            addObject(new Researcher(), coordsRight[i][0], coordsRight[i][1]);
        }
        for (int i = 0; i < leftSide; i++) {
            addObject(new Researcher(), coordsLeft[i][0], coordsLeft[i][1]);
        }
    }
}
}
