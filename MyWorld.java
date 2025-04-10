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
    //x spawn coordinate for spiders. this is set for the team on the left
    private int spiderXSpawn;
    private int supplierXSpawn;
    
    //The number of researchers player can choose from 1-4
    private int resNumRight = 4;
    private int resNumLeft = 4;
    
    private int[][] coordsRight = {
        {114, 550}, {228, 550}, {342, 550}, {456, 550}};
    
    private int[][] coordsLeft = {
        {912, 550}, {798, 550}, {684, 550}, {570, 550}};
        
    // Robots (good and evil)
    private Robot robotGood;
    private Robot robotEvil;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
     
    public MyWorld()   
    {   
        // Create a new world with 1024x800 cells with a cell size of 1x1 pixels.
        super(1024, 800, 1); 
        background = new GreenfootImage("background01.png");
        setBackground(background);
        // initiate progress bar
        SuperStatBar materialProgress = new SuperStatBar(100, 50, null, 60, 8, 0, Color.ORANGE, Color.DARK_GRAY);
        addObject(materialProgress, 465, 300);
        // initiate piles
        Materials woodPile = new Materials();
        addObject(woodPile, 460, 430);
        
        spawn(resNumRight, resNumLeft);
        
        // Create robots
        robotGood = new Robot("good", 0.55);
        robotEvil = new Robot("evil", 0.55);
        addObject(robotGood, 250, 300);
        addObject(robotEvil, 775, 300);
    }

    public void act(){
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
        if(randNum1 == spawnChanceSpider){
            addObject(new Spider(teamSide), spiderXSpawn, 600);
        }
        if(randNum2 == spawnChanceSupplier){//chance for a supplier to spawn. change logic
            addObject(new Supplier(), supplierXSpawn, 720); //added random nums for x and y for now
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
    
    /**
     * End World triggers when game is over, and one team achieves victory
     */
    public void endGame()
    {
        // if (condition)
        Greenfoot.setWorld(new EndScreen());    
    }
}
