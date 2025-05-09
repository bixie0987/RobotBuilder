import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @authors Chin-En Hu, Julia Yang, Yuvia Liu, Elise Liu, Jaclyn Liang
 * @version April 2025
 */
public class MyWorld extends World
{
    private GreenfootImage background;
    //x spawn coordinate for spiders. this is set for the team on the left
    private int spiderXSpawn;
    private int supplierXSpawn;

    // PLAYER PARAMETER VALUES -> parameter value stored in ParamStorage
    //The number of researchers player can choose from 1-4
    private int resNumLeft = ParamStorage.getNumResearchersGood();
    private int resNumRight = ParamStorage.getNumResearchersEvil();
    
    // Spider spawn chance player can choose from 1-10
    private int spiderSpawnChanceLeft = ParamStorage.getSpiderSpawnChanceGood();
    private int spiderSpawnChanceRight = ParamStorage.getSpiderSpawnChanceEvil();
    private int leftSpiderSpawnTimer = 0;
    private int rightSpiderSpawnTimer = 0;
    private final int SPIDER_SPAWN_INTERVAL = 600;
    private int spiderFreezeTimerRight = 0;
    private int spiderFreezeTimerLeft = 0;
    
    private int[][] coordsRight = { 
            {834, 550}, {794, 550}, {754, 550}, {714, 550}};

    private int[][] coordsLeft = {
            {180, 550}, {220, 550}, {260, 550}, {300, 550}};
            
    // Computers
    private Computer computerGood;
    private Computer computerEvil;

    // Robots (good and evil)
    private Robot robotGood;
    private Robot robotEvil;

    // materials
    private Materials pile1;
    private Materials pile2;
    
    //Pipe
    private Pipe pipe1;
    private Pipe pipe2;
    private Pipe pipe3;
    private Pipe pipe4;
    
    //variables for the supplier's spawn rate
    private int increaseLeft = 135;
    private int increaseRight = 135;
    
    //variables for the supplier contribution to material stat bar
    protected int supplierContributionLeft = 20;
    protected int supplierContributionRight = 20;
    
    //variables for the moving speed of the suppliers-- mainly for aesthetics
    protected int speedLeft = 2;
    protected int speedRight = 2;
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
        
        //Play background music
        Sounds.getInstance().playBackgroundMusicLoop();

        // Create robots
        robotGood = new Robot("good");
        robotEvil = new Robot("evil");
        addObject(robotGood, 250, 320);
        addObject(robotEvil, 750, 300);

        // initiate piles     
        pile1 = new Materials(robotGood);
        addObject(pile1, 455, 430);

        pile2 = new Materials(robotEvil);
        addObject(pile2, 545, 430);
        
        robotGood.setPile(pile1);  
        robotEvil.setPile(pile2);
        
        //Add pipes
        pipe1 = new Pipe("Mario_pipe.png", 0.5);
        addObject(pipe1, 100, 750);
        pipe2 = new Pipe("Mario_pipe.png", 0.5);
        addObject(pipe2, 924, 750);
        pipe3 = new Pipe("Mario_pipe.png", 0.5);
        addObject(pipe3, 612, 750);
        pipe4 = new Pipe("Mario_pipe.png", 0.5);
        addObject(pipe4, 392, 750);
        
        // Computers
        computerGood = new Computer();
        computerEvil = new Computer();
        
        //set paint order for pipe and spider
        setPaintOrder (TextLabel.class, PowerupInfo.class, PowerupIcon.class, Pipe.class, Researcher.class, Spider.class, Computer.class);

        spawn(resNumRight, resNumLeft);
        spawn();
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
        if (spiderFreezeTimerLeft > 0) {
            for (Object obj : getObjects(Spider.class)) {
                Spider spider = (Spider) obj;
                if (spider.getX() < 512 && spider.getX() > 256) {
                    removeObject(spider);
                }
            }
            spiderFreezeTimerLeft--;
        }
        if (spiderFreezeTimerRight > 0) {
            for (Object obj : getObjects(Spider.class)) {
                Spider spider = (Spider) obj;
                if (spider.getX() > 512 && spider.getX() < 768) {
                    removeObject(spider);
                }
            }
            spiderFreezeTimerRight--;
        }
        if(spiderFreezeTimerLeft == 1) {
            computerGood.getSpiFreIcon().hide();
        }
        if(spiderFreezeTimerRight == 1) {
            computerEvil.getSpiFreIcon().hide();
        }
    }

    /**
     * The spawning of spiders and suppliers
     * 
     * @param teamSide  The team that the living being belongs to. Should be "Right" or "Left".
     */
    public void spawn(String teamSide){
        leftSpiderSpawnTimer++;
        rightSpiderSpawnTimer++;
        int spawnChanceSupplier = 1;
        int randNum = Greenfoot.getRandomNumber(increaseLeft);
        int randNum2 = Greenfoot.getRandomNumber(increaseRight); //spawn random num from 0-60, for spawn chances of spider
        if(leftSpiderSpawnTimer>=SPIDER_SPAWN_INTERVAL){
            leftSpiderSpawnTimer = 0; //resets the timer to 0 every 10 seconds
        }
        if(rightSpiderSpawnTimer>=SPIDER_SPAWN_INTERVAL){
            rightSpiderSpawnTimer = 0; //resets the timer to 0 every 10 seconds
        }
        
        if(teamSide.equals("Right")){ //change coordinates based on spawn side
            supplierXSpawn = 535; //sets supplier x coordinate to the right side of the screen
            spiderXSpawn = 924; //sets spider x coordinate to the right side of the screen
        }
        else{
            supplierXSpawn = 475; //sets supplier x coordinate to left
            spiderXSpawn = 100; //sets spider x coordinate to left side
        }
        if(shouldSpawnSpider(teamSide)){
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
    
    public void spawn () {
        addObject(computerGood, 234, 500);
        addObject(computerEvil, 768, 500);
    }

    public boolean shouldSpawnSpider(String teamSide){
        if(teamSide.equals("Left")){
            //chance to spawn a spider per act = spiderSpawnChance / 600
            return Greenfoot.getRandomNumber(600) < spiderSpawnChanceLeft;
        }
        else{
            return Greenfoot.getRandomNumber(600) < spiderSpawnChanceRight;
        }
    }

    public void started(){
        Sounds.getInstance().playBackgroundMusicLoop();
    }

    public void stopped(){
        Sounds.getInstance().pauseBackgroundMusic();
    }

    /**
     * End World triggers when game is over, and one team achieves victory
     */
    public void endGame(String winner)
    {
        //Stops playing background music
        Sounds.getInstance().stopBackgroundMusic();
        // Condition is found in Robot class! (this method is called when robot's MAX_STAGE is reached)
        Greenfoot.setWorld(new EndScreen(winner));
    }
    public void freezeLeft() {
        spiderFreezeTimerLeft = 600;
    }
    public void freezeRight() {
        spiderFreezeTimerRight = 600;
    }
    public void boostSupplierLeft() {
        if (increaseLeft > 30) {
            increaseLeft -= 3;
        }
        if (supplierContributionLeft <= 35) {
            supplierContributionLeft += 5;
        }
        if (speedLeft <= 4) {
            speedLeft *= 2;
        }
    }
    public void boostSupplierRight() {
        if (increaseRight > 30) {
            increaseRight -= 3;
        }
        if (supplierContributionRight <= 35) {
            supplierContributionRight += 5;
        }
        if (speedRight <= 4) {
            speedRight *= 2;
        }
    }
}