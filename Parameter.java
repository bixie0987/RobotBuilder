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
    private int minVal;
    private int maxVal;
    private int diff;
    
    private Button bPlus;
    private Button bMinus;
    
    private ParameterBox parameterBox;
    
    private Color FONT_COLOUR = Color.WHITE; // REPLACE COLOUR AFTER!
    private int FONT_SIZE = 21;
    
    private Color FILLEDBAR_COLOUR = new Color(166, 255, 255);
    private Color EMPTYBAR_COLOUR = new Color(30, 70, 136);
    
    /**
     * Creates parameter with corresponding text, bar, counter, and +/- buttons
     * 
     * @param paramText    Text of the parameter's title
     * @param x            X-position of parameter (specifically, the text)
     * @param y            Y-position of parameter (specifically, the text)
     * @param w            World that parameter exists in (should be SettingsWorld, which passes itself as a parameter)
     * @param maxVal       Maximum value of parameter
     * @param minVal       Minimum value that parameter can be set to
     */
    public Parameter(String paramText, int x, int y, World w, int maxVal, int minVal) {
        // Set parameter values and max values
        this.maxVal = maxVal;
        this.minVal = minVal;
        this.val = minVal; // by default, set current value to minVal
        this.diff = minVal; // SuperStatBar stats must start at 0; this line accounts for params that start at a different number (ex: min value is 0)
        // ex: actual val is 4 (1 2 3 4), but statBarVal = 3 (bar: 0 1 2 3) -- minVal was 1, so difference/offs = 1.
        // i.e. statBarVal = val - diff -> everytime u pass val into SuperStatBar, must instead pass val-diff
        
        // Create text
        text = new TextLabel(paramText, FONT_SIZE, FONT_COLOUR); // parameter text
        counter = new TextLabel(String.valueOf(val), FONT_SIZE, FONT_COLOUR); // counter display of parameter value
        
        // Draw square box around each parameter
        int boxWidth = 450;
        int boxMargin = 20; // distance between left of text to left edge of box
        parameterBox = new ParameterBox(boxWidth, 40, new Color(3, 12, 31, 150));
        int boxX = x + boxWidth/2;
        w.addObject(parameterBox, boxX - boxMargin, y);
        
        // Create settings bars
        bar = new SuperStatBar(maxVal-diff, val-diff, null, 100, 10, 0, FILLEDBAR_COLOUR, EMPTYBAR_COLOUR);
        
        // Create plus/minus sign buttons
        bPlus = new Button("plus_icon.png", 0.08);
        bMinus = new Button("minus_icon.png", 0.08);
        
        // Add all objects, ADJUST SPACING HERE
        int boxRightX = x + boxWidth;
        w.addObject(bar, boxRightX-170, y);
        w.addObject(counter, boxRightX-105, y);
        w.addObject(bMinus, boxRightX-80, y);
        w.addObject(bPlus, boxRightX-50, y);
        // Add text
        x += text.getImage().getWidth()/2; // add offset to entire parameter's x-position so all spacing stays consistent
        w.addObject(text, x, y);
    }
    
    /**
     * Updates parameter value - checks if buttons are pressed, then increases/decreases value and updates visuals accordingly.
     */
    public void update()
    {
        // Button increase/decrease function
        // Only allow user to increase/decrease parameter value within the limits (minValue -> maxValue)
        if(bPlus.getPressed() && val < maxVal) {
            val++;
        } else if(bMinus.getPressed() && val > minVal) {
            val--;
        }
        
        // Update bar and text counter
        bar.update(val-diff);
        counter.updateText(String.valueOf(val));
    }
    
    /**
     * @return int    Returns parameter value
     */
    public int getParamValue() {
        return val;
    }
    
    /**
     * @return int    Returns width of entire parameter, aka the width of the parameterBox
     */
    public int getWidth() {
        return parameterBox.getImage().getWidth();
    }
}
