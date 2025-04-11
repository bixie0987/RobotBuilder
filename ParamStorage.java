/**
 * This class acts purely as a storage space for all the parameter values.
 * Parameter values are stored here after user exits SettingsScreen.
 * Other classes must reference ParamStorage to access parameter values.
 * 
 * @author Julia
 * @version April 2025
 */
public class ParamStorage  
{
    private static int numResearchers, spiderSpawnChance;
    
    // Getters and setters for each parameter variable
    public static int getNumResearchers() {
        return numResearchers;
    }
    public static void setNumResearchers(int i) {
        numResearchers = i;
    }
    public static int getSpiderSpawnChance() {
        return spiderSpawnChance;
    }
    public static void setSpiderSpawnChance(int i) {
        spiderSpawnChance = i;
    }
    
    // Print all parameter values. Useful for debugging
    public static void printAll() {
        System.out.println("numResearchers: " + numResearchers);
        System.out.println("spiderSpawnChance: " + spiderSpawnChance);
    }
}
