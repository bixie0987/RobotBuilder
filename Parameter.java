import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * For each parameter, creates a text for the parameter's title, a bar for its value, a counter to display the current value of the parameter,
 * and +/- buttons to increase/decrease the parameter.
 * 
 * To adjust spacing between objects, see constructor.
 * 
 * @author Julia
 * @version April 2025
 */
public class Parameter
{
    private TextLabel text;
    private TextLabel counter; // number displaying value of parameter
    private SuperStatBar bar;
    private int val;
    private int maxVal;
    
    private Button bPlus;
    private Button bMinus;
    
    private Color FONT_COLOUR = Color.GREEN; // REPLACE COLOUR AFTER!
    private int FONT_SIZE = 24;
    
    /**
     * Creates parameter with corresponding text, bar, counter, and +/- buttons
     * 
     * @param paramText    Text of the parameter's title
     * @param x            X-position of parameter (specifically, the text)
     * @param y            Y-position of parameter (specifically, the text)
     * @param w            World that parameter exists in (should be SettingsWorld, which passes itself as a parameter)
     */
    public Parameter(String paramText, int x, int y, World w, int maxVal) {
        // Set parameter values and max values
        this.maxVal = maxVal; // max value of the bar
        val = 0; // starting value
        
        // Create text
        text = new TextLabel(paramText, FONT_SIZE, FONT_COLOUR); // parameter text
        counter = new TextLabel(String.valueOf(val), FONT_SIZE, FONT_COLOUR); // counter display of parameter value
        
        // Create settings bars
        bar = new SuperStatBar(maxVal, val, null, 100, 10, 0);
        
        // Create plus/minus sign buttons
        bPlus = new Button("plus_icon.png", 0.1);
        bMinus = new Button("minus_icon.png", 0.1);
        
        // Add all objects, ADJUST SPACING HERE
        w.addObject(text, x, y);
        w.addObject(bar, x+150, y);
        w.addObject(counter, x+225, y);
        w.addObject(bMinus, x+250, y);
        w.addObject(bPlus, x+280, y);
    }
    
    /**
     * Updates parameter value - checks if buttons are pressed, then increases/decreases value and updates visuals accordingly.
     */
    public void update()
    {
        if(bPlus.getPressed() && val < maxVal) {
            val++;
            bar.update(val);
        } else if(bMinus.getPressed() && val > 0) {
            val--;
            bar.update(val);
        }
        
        counter.updateText(String.valueOf(val));
    }
    
    /**
     * Returns parameter value
     */
    public int getParamValue() {
        return val;
    }
}
