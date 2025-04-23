import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manages powerups of researchers
 * 
 * @author Chin En, Julia
 * @version April 2025
 */
public class Computer extends Actor
{
    private SuperStatBar researchBar;
    private boolean morality;
    
    private int randomPowerUp;
    
    // Powerup icons
    private PowerupIcon spiFreIcon, resIncIcon, supIncIcon;
    
    // Powerup text. Set them up IN THE CONSTRUCTOR!!!!!
    private String[] spiFreText, resIncText, supIncText;
    
    public Computer() {
        setImage("researcherComputer.png");
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 20, img.getHeight() / 20);
        setImage(img);
        
        researchBar = new SuperStatBar(100, 0, null, 60, 8, 0, Color.RED, Color.DARK_GRAY);
        
        // Set up powerup icon description text HERE!!!!!!!
        // Each index in the array is one line of text
        spiFreText = new String[]{"description", "", "", "", ""};
        resIncText = new String[]{"description", "lvl: ", "line3", "line4", "line5"};
        supIncText = new String[]{"description", "lvl: ", "line3", "line4", "line5"};
        
        // Powerup icons
        spiFreIcon = new PowerupIcon("spider_freeze_icon.png", 0.5, spiFreText);
        resIncIcon = new PowerupIcon("researcher_increase_icon.png", 0.5, resIncText);
        supIncIcon = new PowerupIcon("supplier_increase_icon.png", 0.5, supIncText);
    }
    public void addedToWorld(World w) {
        w.addObject(researchBar, getX(), getY() - 70);
        
        // Powerup icons
        w.addObject(spiFreIcon, getX()-80, getY()+80);
        spiFreIcon.hide(); // spiderFreeze icon starts off hidden, is only shown when activated
        w.addObject(resIncIcon, getX(), getY()+80);
        w.addObject(supIncIcon, getX()+80, getY()+80);
    }
    public void increaseProgress(int amount) { 
        if (researchBar != null) {
            int newVal = Math.min(100, researchBar.getCurrentValue() + amount);
            researchBar.update(newVal); // make sure that the two sides are independent
        }
        checkPowerUpStatus();
    }
    public void checkPowerUpStatus() {
        // DEBUGGING!
        if(Greenfoot.isKeyDown("down")) {
            researchBar.update(95);
        }
        
        
        if (researchBar.getCurrentValue() >= 100) {
            randomPowerUp = Greenfoot.getRandomNumber(3);
            
            randomPowerUp = 0; // DEBUGGING
            
            if (randomPowerUp == 0) {
                spiderFreeze();
            } else if (randomPowerUp == 1) {
                researchIncrease();
            } else if (randomPowerUp == 2) {
                supplierIncrease();
            }
            researchBar.update(0);
        }
    }
    /**
     * Act - do whatever the ResearchPile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (getX() == 234) {
            morality = true;
        } else {
            morality = false;
        }
        // Add your action code here.
    }
    public void spiderFreeze() {
        MyWorld world = (MyWorld) getWorld();
        if (morality) {
            //System.out.println("Good side freeze spider");
            world.freezeLeft();
            System.out.println("called freezeLeft");
        }
        if (!morality) {
            //System.out.println("Bad side freeze spider");
            world.freezeRight();
            System.out.println("called freezeRight");
        }
        
        // Show spiderFreeze icon (icon is otherwise hidden when powerup is not activated)
        spiFreIcon.show();
        System.out.println(morality + " is activated");
    }
    public void researchIncrease() {
        for (Object obj : getWorld().getObjects(Researcher.class)) {
            Researcher r = (Researcher) obj;
            if (morality) {
                r.boostResearcherLeft();
            }
            if (!morality) {
                r.boostResearcherRight();
            }
        }
    }
    public void supplierIncrease() {
        MyWorld world = (MyWorld) getWorld();
        for (Object obj : getWorld().getObjects(Supplier.class)) {
            Supplier s = (Supplier) obj;
            if (morality) {
                //System.out.println("Good side supplier boost");
                s.boostSupplierLeft();
            } else {
                //System.out.println("Bad side supplier boost");
                s.boostSupplierRight();
            }
        }
        if (morality) {
            world.boostSupplierLeft();
        } else {
            world.boostSupplierRight();
        }
    }
    
    public PowerupIcon getSpiFreIcon() {
        return spiFreIcon;
    }
    
    public boolean getMorality() {
        return morality;
    }
}
