import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Researcher here.
 * 
 * @author Chin-En Hu
 * @version April 2025
 */
public class Researcher extends Scientist
{
    private boolean firstTime = false;
    private int startX, startY;
    private String side; //Whether the researchers are on the left or right side.

    private final int framesBetweenImages = 30; //half a second between switching between images
    private int actCount = 0; //counts acts passed
    private GreenfootImage[] images; //array that contains images for animation
    
    private int researchCooldown = 0;
    
    //variables for the contribution of researchers to computer stat bar
    private int increaseLeft = 1;
    private int increaseRight = 1;
    
    //variables for the moving speed of researchers
    private int leftSpeed = 1;
    private int rightSpeed = 1;
    /**
     * Act - do whatever the Researcher wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Researcher () {
        images = new GreenfootImage[9];
        //adds images to the array
        for(int i=0; i<9; i++){
            images[i] = new GreenfootImage("fresearcherwalk" + i + ".png");
        }
        setImage(images[0]);
        enableStaticRotation();
    }

    public void act()
    {
        if (firstTime == false) {
            if (getX() < 301) {
                side = "left";
            } else {
                side = "right";
            }
            startX = getX();
            startY = getY();
            firstTime = true;
        }
        if(actCount == 270){
            actCount=0; //resets act count, or animation image, after last image has been reached
        }
        killSpider();
        doResearch();
    }

    public void doResearch() {
        Computer touchedComputer = (Computer) getOneIntersectingObject(Computer.class);
        if (touchedComputer != null) {
            if (researchCooldown == 0 ) {
                if (side == "left") {
                    touchedComputer.increaseProgress(increaseLeft);  // Only the touched computer's bar increases
                }
                if (side == "right") {
                    touchedComputer.increaseProgress(increaseRight);  // Only the touched computer's bar increases
                }
                researchCooldown = 60;
            }
        }
        
        if (researchCooldown > 0) {
            researchCooldown--;
        }
    }
    
    public void killSpider () {
        Spider target = (Spider) getOneIntersectingObject(Spider.class);
        if (target != null) {
            getWorld().removeObject(target);
            Sounds.getInstance().playSounds(Sounds.KILL_SPIDER);
        } else if (hasSpiderOnSide()) {
            Spider closest = getClosestSpider();
            if (closest != null) {
                animate();
                turnTowards(closest.getX(), closest.getY());
                if (side.equals("left")) {
                    move(leftSpeed);
                } else {
                    move(rightSpeed);
                }
            }
        } else if (startX != getX() && startY != getY()) {
            animate();
            turnTowards(startX, startY);
            if (side.equals("left")) {
                move(leftSpeed);
            } else {
                move(rightSpeed);
            }
        }
    }

    public Spider getClosestSpider() {
        Spider closest = null;
        double closestDistance = Double.MAX_VALUE;

        double distance;
        for (Object obj : getWorld().getObjects(Spider.class)) {
            Spider spider = (Spider) obj;

            int x = spider.getX();
            if (x >= 256 && x <= 768) {
                distance = Math.hypot(getX() - spider.getX(), getY() - spider.getY());
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closest = spider;
                }
            }
        }
        return closest;
    }

    public boolean hasSpiderOnSide() {
        for (Object obj : getWorld().getObjects(Spider.class)) {
            Spider spider = (Spider) obj;
            if ((side.equals("left") && spider.getX() < 512 && spider.getX() > 256) || (side.equals("right") && spider.getX() > 512 && spider.getX() < 768)) {
                return true;
            }
        }
        return false;
    }
    public void animate(){
        int frame = actCount/30; //cycles between frames every half second
        setImage(images[frame]); //set image to the frame that corresponds to the time passed
        actCount++;
    }
    public void boostResearcherLeft() {
        if (side.equals("left")) {
            if (increaseLeft <= 8) {
                increaseLeft *= 2;
                //System.out.println("Good size research boost");
            }
            if (leftSpeed <= 4) {
                leftSpeed += 1;
            }
        }
    }
    public void boostResearcherRight() {
        if (side.equals("right")) {
            if (increaseRight <= 8) {
                increaseRight *= 2;
                //System.out.println("Good size research boost");
            }
            if (rightSpeed <= 4) {
                rightSpeed += 1;
            }
        }
    }
    
    public int getIncreaseLeft() {
        return increaseLeft;
    }
    public int getIncreaseRight() {
        return increaseRight;
    }
    public int getLeftSpeed() {
        return leftSpeed;
    }
    public int getRightSpeed() {
        return rightSpeed;
    }
}
