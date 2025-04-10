/**
 * Write a description of class ParameterStorage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParamStorage  
{
    private static int numResearchers;
    
    public static int getNumResearchers() {
        return numResearchers;
    }
    public static void setNumResearchers(int i) {
        numResearchers = i;
    }
    
    public static void printAll() {
        System.out.println(numResearchers);
    }
}
