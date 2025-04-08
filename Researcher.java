import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Researcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Researcher extends Scientist
{
    /**
     * Act - do whatever the Researcher wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Researcher () {
        setImage("R-Placeholder.png");
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 2, img.getHeight() / 2);
        setImage(img);
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    }

    public void act()
    {
        // Add your action code here.
        if (getWorld() == null) {
            killSpider();
        }
    }

    public void killSpider () {
        Spider target = (Spider) getOneIntersectingObject(Spider.class);

        if (target != null) {
            getWorld().removeObject(target);
        } else {
            Spider closest = getClosestSpider();
            if (closest != null) {
                turnTowards(closest.getX(), closest.getY());
                move(2);
            }
        }
    }
    
    public Spider getClosestSpider() {
        Spider closest = null;
        double closestDistance = Double.MAX_VALUE;

        for (Object obj : getWorld().getObjects(Spider.class)) {
            Spider spider = (Spider) obj;
            double distance = Math.hypot(getX() - spider.getX(), getY() - spider.getY());

            if (distance < closestDistance) {
                closestDistance = distance;
                closest = spider;
            }
        }
        return closest;
    }
}
