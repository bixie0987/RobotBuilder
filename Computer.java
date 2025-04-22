import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResearchPile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computer extends Actor
{
    private SuperStatBar researchBar;
    private boolean morality;
    
    private int randomPowerUp;
    
    // Powerup icons
    private PowerupIcon spiFreIcon, resIncIcon, supIncIcon;
    
    public Computer() {
        setImage("researcherComputer.png");
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 20, img.getHeight() / 20);
        setImage(img);
        
        researchBar = new SuperStatBar(100, 0, null, 60, 8, 0, Color.RED, Color.DARK_GRAY);
        
        // Powerup icons
        spiFreIcon = new PowerupIcon("powerup_icon.png", 0.08);
        resIncIcon = new PowerupIcon("powerup_icon.png", 0.08);
        supIncIcon = new PowerupIcon("powerup_icon.png", 0.08);
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
            
            if (randomPowerUp == 0) {
                spiderFreeze();
            } else if (randomPowerUp == 1) {
                researchIncrease();
            } else if (randomPowerUp == 2) {
                supplierIncrease();
            }
            researchBar.update(0);
            randomPowerUp = 0; // DEBUGGING
            System.out.println("randomPowerUp: " + randomPowerUp); // DEBUGGING
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
        }
        if (!morality) {
            //System.out.println("Bad side freeze spider");
            world.freezeRight();
        }
        
        // Show spiderFreeze icon (icon is otherwise hidden when powerup is not activated)
        spiFreIcon.show();
        System.out.println("showing"); // DEBUGGING
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
}
