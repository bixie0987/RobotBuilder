import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ParameterBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParameterBox extends Actor
{
    public ParameterBox(int width, int height, Color color) {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(color);
        img.fillRect(0, 0, width, height);  // or drawRect for outline only
        setImage(img);
    }
}
