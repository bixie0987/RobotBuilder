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
    
    // PLAYER PARAMETER VALUES -> parameter value stored in ParamStorage
    //The number of researchers player can choose from 1-4
    private int resNumRight = ParamStorage.getNumResearchers();
    private int resNumLeft = ParamStorage.getNumResearchers();
    
    // Spider spawn chance player can choose from 1-10
    //if the number is 1, spider should spawn once every 10 seconds
    //if the number is 10, spider should spawn 10 times every 10 seconds
    private int spiderSpawnChance = ParamStorage.getSpiderSpawnChance();
    //600 acts every 10 seconds; each interval should be 10 seconds long
    private final int SPIDER_SPAWN_INTERVAL = 600;
    private int spiderSpawnTimer = 0; //timer that counts the acts between spawn intervals
  
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
        spiderSpawnTimer++;
        if(spiderSpawnTimer>=SPIDER_SPAWN_INTERVAL){
            spiderSpawnTimer = 0; //resets the timer to 0 every 10 seconds
        }
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
        int randNum2 = Greenfoot.getRandomNumber(300); //spawn random num from 0-60, for spawn chances of spider
        if(teamSide.equals("Right")){ //change coordinates based on spawn side
            supplierXSpawn = 531; //sets supplier x coordinate to the right side of the screen
            spiderXSpawn = 924; //sets spider x coordinate to the right side of the screen
        }
        else{
            supplierXSpawn = 471; //sets supplier x coordinate to left
            spiderXSpawn = 100; //sets spider x coordinate to left side
        }
        if(shouldSpawnSpider()){
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
    
    public boolean shouldSpawnSpider(){
        //chance to spawn a spider per act = spiderSpawnChance / 600
        return Greenfoot.getRandomNumber(600) < spiderSpawnChance;
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
    
    public void checkAndUnlockLeftPart() {
        int progress = materialProgress1.getCurrentValue();

        if (progress >= 100 && leftRobotPart < 6) {
            leftRobotPart++;

            // Create a generic Actor to display image
            Actor part = new Actor() {};
            part.setImage("part" + leftRobotPart + ".PNG");
            part.getImage().scale(450, 670); // adjust the size

            addObject(part, 250, 310);
    
            // Reset the progress bar back to 0
            materialProgress1.update(0);
        }
    }
    
    public void checkAndUnlockRightPart() {
        int progress = materialProgress2.getCurrentValue();

        if (progress >= 100 && rightRobotPart < 6) {
            rightRobotPart++;
    
            // Generic actor with right-side image
            Actor part = new Actor() {};
            part.setImage("right" + rightRobotPart + ".PNG"); 
            part.getImage().scale(450, 670); // adjust the size
            addObject(part, 775, 310);
    
            // Reset the progress bar
            materialProgress2.update(0);
            part.getImage().scale(450, 610); // adjust the size
    
            addObject(part, 250, 300);
    
            // Reset the progress bar back to 0
            materialProgress1.update(0);
        }
    }

}

