import java.util.List;

/**
 * Storage Object for Songs to be used in Tune Player
 * 
 * @ojp5
 * @17-12-15
 */
public class Song
{
    public List<String> notes;
    public int step;

    /**
     * Constructor for objects of class Song
     */
    public Song(List<String> notes, int step)
    {
        this.notes = notes;
        this.step = step;
    }
}
