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
    //x spawn coordinate for spiders. this is set for the team on the left
    private int spiderXSpawn;
    private int supplierXSpawn;
    
    // PLAYER PARAMETER VALUES -> parameter value stored in ParamStorage
    //The number of researchers player can choose from 1-4
    private int resNumRight = ParamStorage.getNumResearchers();
    private int resNumLeft = ParamStorage.getNumResearchers();
    // Spider spawn chance player can choose from 1-10
    private int spiderSpawnChance = ParamStorage.getSpiderSpawnChance();
  
    private int[][] coordsRight = {
        {180, 550}, {220, 550}, {260, 550}, {300, 550}}; 
    
    private int[][] coordsLeft = {
        {834, 550}, {794, 550}, {754, 550}, {714, 550}};
    
    // Robots (good and evil)
    private Robot robotGood;
    private Robot robotEvil;
    
    // materials
    private Materials pile1;
    private Materials pile2;
=======
    
    //x spawn coordinate for spiders. this is set for the team on the left
    private int spiderXSpawn = 100;
>>>>>>> Stashed changes

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
<<<<<<< Updated upstream
     
    public MyWorld()   
    {   
=======
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
>>>>>>> Stashed changes
        // Create a new world with 1024x800 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        background = new GreenfootImage("background01.png");
        setBackground(background);
        
        // Create robots
        robotGood = new Robot("good");
        robotEvil = new Robot("evil");
        addObject(robotGood, 250, 320);
        addObject(robotEvil, 750, 320);
        
        // initiate piles
        // Link the robot to each pile
        pile1 = new Materials(robotGood);
        addObject(pile1, 455, 430);
        pile2 = new Materials(robotEvil);
        addObject(pile2, 545, 430);
                
        spawn(resNumRight, resNumLeft);
    }

    public void act(){
        //spawn(resNumRight, resNumLeft);
        spawn("Right");
        spawn("Left");
        
        // TO BE CHANGED EVENTUALLY: to switch to SettingsScreen, press "up"
        if(Greenfoot.isKeyDown("up")) {
            SettingsScreen s = new SettingsScreen();
            Greenfoot.setWorld(s);
        }
        
        // TO BE CHANGED EVENTUALLY: to test PoofAnimation, right click
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null && m.getButton() == 3) {
            robotGood.stageUp();
        }
    }
    
        public void spawn(String teamSide){
        int spawnChanceSpider = 1;
        int spawnChanceSupplier = 1;
        int randNum1 = Greenfoot.getRandomNumber(100); //spawn random num from 0-99, for spawn chances
        int randNum2 = Greenfoot.getRandomNumber(60); //spawn random num from 0-60, for spawn chances of spider
        if(teamSide.equals("Right")){ //change coordinates based on spawn side
            supplierXSpawn = 531; //sets supplier x coordinate to the right side of the screen
            spiderXSpawn = 924; //sets spider x coordinate to the right side of the screen
        }
        else{
            supplierXSpawn = 471; //sets supplier x coordinate to left
            spiderXSpawn = 100; //sets spider x coordinate to left side
        }
<<<<<<< Updated upstream
        if(randNum1 == spawnChanceSpider){
            addObject(new Spider(teamSide), spiderXSpawn, 600);
        }
        if(randNum2 == spawnChanceSupplier){//chance for a supplier to spawn. change logic
            addObject(new Supplier(), supplierXSpawn, 720); //added random nums for x and y for now
            //x and y should change based on team
=======
        if(randNum < spawnChance){ //chance for a spider to spawn. change logic
            if(randNum < spawnChance) { //chance for a spider to spawn. change logic//added random nums for x and y for now
                addObject(new Spider(), spiderXSpawn, 600); //added random nums for x and y for now
                //x and y should change based on team
            }
>>>>>>> Stashed changes
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
    
    //plays or stops background music depending on if scenario is running or not
    public void started(){
        Sounds.getInstance().playBackgroundMusicLoop();
    }

    public void stopped(){
        Sounds.getInstance().stopBackgroundMusic();
    }
    
    /**
     * End World triggers when game is over, and one team achieves victory
     */
    public void endGame()
    {
        // Condition is found in Robot class! (this method is called when robot's MAX_STAGE is reached)
        Greenfoot.setWorld(new EndScreen());    
    }
}

