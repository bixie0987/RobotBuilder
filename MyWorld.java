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
    
    private int[][] coordsRight= {
        {180, 550}, {220, 550}, {260, 550}, {300, 550}};  
    private int[][] coordsLeft = {
        {834, 550}, {794, 550}, {754, 550}, {714, 550}};
    // Robots (good and evil)
    private Robot robotGood;
    private Robot robotEvil;
    
    // progress bar for piles
    private SuperStatBar materialProgress1;
    private SuperStatBar materialProgress2;
    
    // materials
    private Materials pile1;
    private Materials pile2;
    
    private int leftRobotPart = 0; // From 0 to 6 (for 6 total parts of robot)
    private int rightRobotPart = 0;

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
        // initiate progress bars
        materialProgress1 = new SuperStatBar(100, 0, null, 60, 8, 0, Color.ORANGE, Color.DARK_GRAY);
        addObject(materialProgress1, 464, 340);
        materialProgress2 = new SuperStatBar(100, 0, null, 60, 8, 0, Color.ORANGE, Color.DARK_GRAY);
        addObject(materialProgress2, 536, 340);
        // initiate piles
        // Assign a different "side" to each pile
        pile1 = new Materials(materialProgress1, "left");
        addObject(pile1, 455, 430);
        
        pile2 = new Materials(materialProgress2, "right");
        addObject(pile2, 545, 430);
                
        spawn(resNumRight, resNumLeft);
        
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
    
    public void increaseProgress(int amount) 
    {
        materialProgress1.update(materialProgress1.getCurrentValue() + amount); // increase the progress bar
        materialProgress2.update(materialProgress1.getCurrentValue() + amount);
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
    }
}
}


