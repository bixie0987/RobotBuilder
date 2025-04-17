import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Researcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Researcher extends Scientist
{
    private boolean firstTime = false;
    private int startX, startY;
    private String side; //Whether the researchers are on the left or right side.
    private SuperStatBar researchBar;
    /**
     * Act - do whatever the Researcher wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Researcher () {
        setImage("R-Placeholder.png");
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 4, img.getHeight() / 4);
        setImage(img);
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
        killSpider();
    }

    public void killSpider () {
        Spider target = (Spider) getOneIntersectingObject(Spider.class);
        if (target != null) {
            getWorld().removeObject(target);
        } else if (hasSpiderOnSide()) {
            Spider closest = getClosestSpider();
            if (closest != null) {
                turnTowards(closest.getX(), closest.getY());
                move(1);
            }
        } else if (startX != getX() && startY != getY()) {
            turnTowards(startX, startY);
            move(1);
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
}

