import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manages powerups of researchers
 * 
 * @author Chin-En Hu, Julia
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
    
    // Powerup variables (to use in their text)
    private int resLvl = 0;
    private int resInc, resSpeed; // idk what to do with these
    
    public Computer() {
        setImage("researcherComputer.png");
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 5, img.getHeight() / 5);
        setImage(img);
        
        researchBar = new SuperStatBar(100, 0, null, 60, 8, 0, Color.RED, Color.DARK_GRAY);
        
        // Set up powerup icon description text HERE!!!!!!!
        // Each index in the array is one line of text
        spiFreText = new String[]{"Freezes spiders for 30 secs in", "their pipes", "", "", "", ""};
        resIncText = new String[]{"Boosts researcher's movement", "speed and research ability", "Lvl: " + resLvl, "line3", "line4", "line5"};
        supIncText = new String[]{"description", "", "Lvl: ", "line3", "line4", "line5"};
        
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
        if (researchBar.getCurrentValue() >= 100) {
            randomPowerUp = Greenfoot.getRandomNumber(3);
            
            if (randomPowerUp == 0) {
                //freezes spiders for 30 secs
                spiderFreeze();
            } else if (randomPowerUp == 1) {
                //increases researcher stats
                researchIncrease();
            } else if (randomPowerUp == 2) {
                //increases supplier stats
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
    }
    
    public void spiderFreeze() {
        MyWorld world = (MyWorld) getWorld();
        if (morality) {
            world.freezeLeft();
        }
        if (!morality) {
            world.freezeRight();
        }
        
        // Show spiderFreeze icon (icon is otherwise hidden when powerup is not activated)
        spiFreIcon.show();
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
        resLvl++; // increase level, indicator of how many times this powerup has been activated
    }
    public void supplierIncrease() {
        MyWorld world = (MyWorld) getWorld();
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
