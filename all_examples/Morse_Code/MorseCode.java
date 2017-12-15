/**
 * This class converts a string to morse code (alphanumeric + spaces only).
 * I am basing this off international morse code assuming the following constraints:
 * 1.) The length of a dot is 1 unit.
 * 2.) A dash is 3 units.
 * 3.) The space between parts of the same letter is one unit.
 * 4.) The space been letters is three units.
 * 5.) The space between words is seven units.
 * 
 * @author Oliver Pechey
 * @version 0.2
 */
public class MorseCode
{
    private LED led;
    private char[] array;
    private int unit;

    private final static int defaultPin = 1;
    
    /**
     * Constructor for objects of class MorseCode with default unit
     * @param word String that takes letters, numbers and space only.
     */
    public MorseCode(String word)
    {
        this(word, 1, defaultPin);
    }
    
    /**
     * Constructor for objects of class MorseCode
     * @param word String that takes letters, numbers and space only.
     * @param unit Value from 0 to 1 to change the unit of time.
     */
    public MorseCode(String word, double unit, int pin)
    {
        led = new LED(pin);
        array = word.toCharArray();
        Double temp = new Double(unit*1000);
        this.unit = temp.intValue();
    }

    /**
     * Changes the word
     * @param word The new word
     */
    public void changeword(String word) 
    {
        array = word.toCharArray();
    }
    
     /**
     * Changes the unit
     * @param unit The new unit
     */
    public void changeUnit(int unit) 
    {
        Double temp = new Double(unit*1000);
        this.unit = temp.intValue();
    }
    
    /**
     * Makes dot show up on LED
     */
    public void dot() throws InterruptedException
    {
        led.on();
        Thread.sleep(unit);
        led.off();
        //For space between letter
        Thread.sleep(unit);
    }
    
     /**
     * Makes dash show up on LED
     */
    public void dash() throws InterruptedException
    {
        led.on();
        Thread.sleep(3*unit);
        led.off();
        //For space between letter
        Thread.sleep(unit);
    }
    
     /**
     * Makes spaces show up on LED
     */
    public void space(String space) throws InterruptedException
    {
        if(space.equals("Letter")) {
            //Adjusted due to sleep after dot/dash
            Thread.sleep(2*unit);
        }
        else {
            //Adjusted due to sleep after dot/dash
            Thread.sleep(4*unit);
        }
    }
    
     /**
     * Plays the morse code
     */
    public void play() 
    {
        try {
            for(int i = 0; i < array.length; i++) {
                switch (array[i]) {
                    case 'a':
                        dot();dash();
                        break;
                    case 'b':
                        dash();dot();dot();dot();
                        break;
                    case 'c':
                        dash();dot();dash();dot();
                        break;
                    case 'd':
                        dash();dot();dot();
                        break;
                    case 'e':
                        dot();
                        break;
                    case 'f':
                        dot();dot();dash();dot();
                        break;
                    case 'g':
                        dash();dash();dot();
                        break;
                    case 'h':
                        dot();dot();dot();dot();
                        break;
                    case 'i':
                        dot();dot();
                        break;
                    case 'j':
                        dot();dash();dash();dash();
                        break;
                    case 'k':
                        dash();dot();dash();
                        break;
                    case 'l':
                        dot();dash();dot();dot();
                        break;
                    case 'm':
                        dash();dash();
                        break;
                    case 'n':
                        dash();dot();
                        break;
                    case 'o':
                        dash();dash();dash();
                        break;
                    case 'p':
                        dot();dash();dash();dot();
                        break;
                    case 'q':
                        dash();dash();dot();dash();
                        break;
                    case 'r':
                        dot();dash();dot();
                        break;
                    case 's':
                        dot();dot();dot();
                        break;
                    case 't':
                        dash();
                        break;
                    case 'u':
                        dot();dot();dash();
                        break;
                    case 'v':
                        dot();dot();dot();dash();
                        break;
                    case 'w':
                        dot();dash();dash();
                        break;
                    case 'x':
                        dash();dot();dot();dash();
                        break;
                    case 'y':
                        dash();dot();dash();dash();
                        break;
                    case 'z':
                        dash();dash();dot();dot();
                        break;
                    case '0':
                        dash();dash();dash();dash();dash();
                        break;
                    case '1':
                        dot();dash();dash();dash();dash();
                        break;
                    case '2':
                        dot();dot();dash();dash();dash();
                        break;
                    case '3':
                        dot();dot();dot();dash();dash();
                        break;
                    case '4':
                        dot();dot();dot();dot();dash();
                        break;
                    case '5':
                        dot();dot();dot();dot();dot();
                        break;
                    case '6':
                        dash();dot();dot();dot();dot();
                        break;
                    case '7':
                        dash();dash();dot();dot();dot();
                        break;
                    case '8':
                        dash();dash();dash();dot();dot();
                        break;
                    case '9':
                        dash();dash();dash();dash();dot();
                        break;
                    default:
                        space("Word");
                        break;
                }   
                space("Letter");
            }
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
