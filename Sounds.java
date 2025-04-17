import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * This class is in charge of managing all sound effects and background music
 * 
 * @Elise Liu
 * @V03
 */
public class Sounds extends Actor
{
    private static final Sounds instance = new Sounds(); //creates an object of this class

    //initializes variables to store sound effects/ambience sound
    //these sounds do not need to be in an array since they do not overlap
    private GreenfootSound backgroundMusic;

    //array that holds sound effects
    private ArrayList<GreenfootSound> soundList = new ArrayList<GreenfootSound>();

    private int soundIndex[] = new int[8]; //holds which sound is being played
    //holds the sound effects of each living being
    //first index holds the type of living being, second index holds duplicates of its audio files
    private GreenfootSound[][] soundArray = new GreenfootSound[soundIndex.length][15];

    //array that holds each living being's sound file name
    private String[] soundNames = {"research_in_progress.wav","spider_spawn.wav","attach_limb.mp3", 
        "research_bar_max.wav", "mouse_click.wav", "change_material.wav", "kill_spider.wav",
    "win_sound.wav"};

    //variables to identify living beings
    public final static int RESEARCH_IN_PROGRESS = 0;
    public final static int SPIDER_SPAWN = 1;
    public final static int ATTACH_LIMB = 2;
    public final static int RESEARCH_BAR_MAX = 3;
    public final static int MOUSE_CLICK = 4;
    public final static int CHANGE_MATERIAL = 5;
    public final static int KILL_SPIDER = 6;
    public final static int WIN_SOUND = 7;

    /**
     * The constructor is private so that it can't be created by any other classes
     * There will be a method to get an instance of this class, which will be shared by every class
     */
    private Sounds(){
        //darknessSound = new GreenfootSound("dark_sound.wav");
        //darknessSound.setVolume(60);
        //soundList.add(darknessSound); //adds the sound effect to the array list    

        backgroundMusic = new GreenfootSound("background_music.mp3");
        backgroundMusic.setVolume(30);
        soundList.add(backgroundMusic);

        //adds 15 sounds of the same audio file to their corresponding row of the 2d array
        //their corresponding row is determined by the living being type, which is index 1
        for(int livingBeingType=0; livingBeingType<soundIndex.length; livingBeingType++){ //runs through each column (living being type)
            for(int i=0; i<soundArray[livingBeingType].length; i++){ //runs through each row of the living being type
                soundArray[livingBeingType][i] = new GreenfootSound(soundNames[livingBeingType]); //creates the sound
                soundArray[livingBeingType][i].setVolume(80); //sets each sounds volume to 80
                preload(soundArray[livingBeingType][i]); //preloads the sound
            }
        }

        for(GreenfootSound s:soundList){
            preload(s); //preloads each sound that is not in an array
        }

    }

    public static Sounds getInstance(){ //used to get the object of this class, since constructor is private
        return instance;
    }

    //play and stop the sound immediately, which preloads it 
    public void preload(GreenfootSound s){
        s.play();
        s.stop();
    }

    /**
     * Act - do whatever the Sounds wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

    }

    public void playBackgroundMusicLoop(){
        backgroundMusic.playLoop();
    }

    public void stopBackgroundMusic(){
        backgroundMusic.stop();
    }

    public void playSounds(int livingBeingType){
        soundArray[livingBeingType][soundIndex[livingBeingType]].play(); //plays the sound for the living being type
        soundIndex[livingBeingType]++; //increases the number for the sound index of the living being
        if(soundIndex[livingBeingType]>soundArray[livingBeingType].length-1){
            soundIndex[livingBeingType]=0; //resets sound index once it reaches end of array
        }
    }
}
