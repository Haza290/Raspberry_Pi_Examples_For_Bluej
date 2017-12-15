import java.util.*;

/**
 * Manipulates the Speaker class to play a tune.
 * @ojp
 * @04-10-15
 */
public class JukeBox
{
    // instance variables
    private ArrayList<Song> song_list; 
    private Speaker speaker;
    
    /**
     * Constructor for objects of class MediaPlayer.
     */
    public JukeBox()
    {
        // initialise instance variables
        speaker = new Speaker();
        song_list = new ArrayList<Song>();
        populateSongs();
    }
    
    /**
     * Adds songs to song_list.
     */
    public void populateSongs() {
        song_list.add(new Song(Arrays.asList("D#","wait","wait","D#","wait","C#","wait","Bb","wait","wait","wait","Bb","wait","g#","wait","C#","wait","wait","C#","wait","f#","wait","f","wait","wait","wait","f","wait","eb","wait","wait"),280));
        song_list.add(new Song(Arrays.asList("C","C","G","G","F","F","G","wait","F","F","E","E","D","D","C","wait","G","G","F","F","E","E","D","wait","G","G","F","F","E","E","D","wait","C","C","G","G","A","A","G","wait","F","F","E","E","D","D","C"),280));
        song_list.add(new Song(Arrays.asList("A","G","A","E","C","E","A","wait","A","G","A","E","C","E","A","wait","A","B","B","C","C","A","D","A","D","D","G","A","A","G","A","B","C","E","D","E","C","A","C","G","E","D","E","C","A","C","G","wait","E","F#","G","F#","E","E"),280));
    }

    /**
     * Plays music.
     */
    public void play(int song)
    {
        for(int i = 0;i < song_list.get(song).notes.size(); i++) {
            speaker.play(song_list.get(song).notes.get(i));
        }
    }
}
