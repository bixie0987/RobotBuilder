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
    private static int numResearchersGood, spiderSpawnChanceGood;
    private static int numResearchersEvil, spiderSpawnChanceEvil;
    
    // Getters and setters for each parameter variable
    public static int getNumResearchersGood() {
        return numResearchersGood;
    }
    public static void setNumResearchersGood(int i) {
        numResearchersGood = i;
    }
    public static int getSpiderSpawnChanceGood() {
        return spiderSpawnChanceGood;
    }
    public static void setSpiderSpawnChanceGood(int i) {
        spiderSpawnChanceGood = i;
    }
    
    public static int getNumResearchersEvil() {
        return numResearchersEvil;
    }
    public static void setNumResearchersEvil(int i) {
        numResearchersEvil = i;
    }
    public static int getSpiderSpawnChanceEvil() {
        return spiderSpawnChanceEvil;
    }
    public static void setSpiderSpawnChanceEvil(int i) {
        spiderSpawnChanceEvil = i;
    }
    
    // Print all parameter values. Useful for debugging
    public static void printAll() {
        System.out.println("numResearchersGood: " + numResearchersGood);
        System.out.println("spiderSpawnChanceGood: " + spiderSpawnChanceGood);
        
        System.out.println("numResearchersEvil: " + numResearchersEvil);
        System.out.println("spiderSpawnChanceEvil: " + spiderSpawnChanceEvil);
    }
}
