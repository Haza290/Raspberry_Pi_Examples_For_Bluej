import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftTone;
import java.util.HashMap;

/**
 * A simple class to drive a frequency through a buzzer.
 * 
 * @ojp5
 * @27-10-15
 */

public class Speaker

{
    // instance variables
    private int PIN;
    private double waitvalue;
    private int step;
    private HashMap<String, Integer> note_store;

    /**
     * Default constructor for objects of class Speaker.
     */
    public Speaker()
    {
        PIN = 3;
        waitvalue = 0.28;
        step = 280;
        populateNotes();
        Gpio.wiringPiSetup();
        SoftTone.softToneCreate(PIN);
    }

    /**
     * Constructor used if a waitcalue and pin are specified.
     */
    public Speaker(int waitvalue, int pin)
    {
        PIN = pin;
        this.step = step;
        populateNotes();
        Gpio.wiringPiSetup();
        SoftTone.softToneCreate(PIN);
    }

    /**
     * Populates the note_store Hashmap with the notes and their frequencies.
     */
    private void populateNotes() {
        note_store = new HashMap<>();
        note_store.put("wait",0);
        note_store.put("a",220);
        note_store.put("bb",233);
        note_store.put("b",247);
        note_store.put("c",262);
        note_store.put("c#",277);
        note_store.put("d",294);
        note_store.put("eb",311);
        note_store.put("e",330);
        note_store.put("f",349);
        note_store.put("f#",370);
        note_store.put("g",392);
        note_store.put("g#",415);  
        note_store.put("A",440);
        note_store.put("Bb",466);
        note_store.put("B",494);
        note_store.put("C",523);
        note_store.put("C#",554);
        note_store.put("D",587);
        note_store.put("D#",622);
        note_store.put("Eb",662);
        note_store.put("E",659);
        note_store.put("F",699);
        note_store.put("F#",740);
        note_store.put("G",784);
        note_store.put("G#",831);    
    }

    /**
     * This method takes a Note as a parameter, converts that note to a frequency using our Array, and then plays the Note for 1 Second using the Pi4J Library.
     */
    public void play(String str)
    {
        int freq = note_store.get(str);
        SoftTone.softToneWrite(PIN,freq);
        try {
            Thread.sleep(step);
        }
        catch(Exception e) {
            System.err.println("Error:" + e);
        }
        SoftTone.softToneWrite(PIN,0);
    }

    /**
     * This method takes a frequency instead.
     */
    public void play(int freq)
    {
        SoftTone.softToneWrite(PIN,freq);
        try {
            Thread.sleep(step);
        }
        catch(Exception e) {
            System.err.println("Error:" + e);
        }
        SoftTone.softToneWrite(PIN,0);
    }
}
