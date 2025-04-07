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
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
    public Researcher () {
        
    }
    
    public void act()
    {
<<<<<<< Updated upstream
        if (getWorld() == null) {
=======
                if (getWorld() == null) {
>>>>>>> Stashed changes
            killSpider();
        }
        // Add your action code here.
    }
<<<<<<< Updated upstream
    
    public void killSpider () {
        Spider target = (Spider) getOneIntersectingObject(Spider.class);
        
=======

    public void killSpider () {
        Spider target = (Spider) getOneIntersectingObject(Spider.class);

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    
    public Spider getClosestSpider() {
        Spider closest = null;
        double closestDistance = Double.MAX_VALUE;
        
        for (Object obj : getWorld().getObjects(Spider.class)) {
            Spider spider = (Spider) obj;
            double distance = Math.hypot(getX() - spider.getX(), getY() - spider.getY());
            
=======

    public Spider getClosestSpider() {
        Spider closest = null;
        double closestDistance = Double.MAX_VALUE;

        for (Object obj : getWorld().getObjects(Spider.class)) {
            Spider spider = (Spider) obj;
            double distance = Math.hypot(getX() - spider.getX(), getY() - spider.getY());

>>>>>>> Stashed changes
            if (distance < closestDistance) {
                closestDistance = distance;
                closest = spider;
            }
        }
<<<<<<< Updated upstream
        
=======

>>>>>>> Stashed changes
        return closest;
    }
}

