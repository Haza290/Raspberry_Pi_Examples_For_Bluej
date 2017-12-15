import com.pi4j.io.gpio.*;

/**
 * A class used to check if a bumper has made contact with anthing. It is very similar to Class Button but it uses
 * PULL_UP instead of PULL_DOWN.
 * 
 * @author Harry Schneider (HS308)
 * @version 1.0
 */
public class Bumper
{
    // The bumper instance is an input pin.
    private GpioPinDigitalInput bumper;
    
    // This array maps the GPIO pin numbers to ints
    private static final Pin[] pinMap = new Pin[] {RaspiPin.GPIO_00, RaspiPin.GPIO_01, RaspiPin.GPIO_02, RaspiPin.GPIO_03, RaspiPin.GPIO_04, 
        RaspiPin.GPIO_05, RaspiPin.GPIO_06, RaspiPin.GPIO_07, RaspiPin.GPIO_08, RaspiPin.GPIO_09, RaspiPin.GPIO_10, 
        RaspiPin.GPIO_11, RaspiPin.GPIO_12, RaspiPin.GPIO_13, RaspiPin.GPIO_14, RaspiPin.GPIO_15, RaspiPin.GPIO_16, 
        RaspiPin.GPIO_17, RaspiPin.GPIO_18, RaspiPin.GPIO_19, RaspiPin.GPIO_20};
    
    // The default pin, used by the constructor without parameters.
    private final static int defaultPin = 16;

    /**
     * Sets the default pins if none are chosen for the constructor.
     */
    public Bumper()
    {
        this(defaultPin);
    }

    /**
     * Constructor for objects of class Bumper. Sets up a pin as an input to be used to check if a bumper is pressed.
     */
    public Bumper(int pin)
    {
        // Get a gpio controller
        GpioController gpio = GpioFactory.getInstance();
        
        bumper = gpio.provisionDigitalInputPin(pinMap[pin], PinPullResistance.PULL_UP);
    }
    
    /**
     * Checks to see if the bumpers is being pressed and returns true if it is.
     */
    public boolean isPressed()
    { 
        return bumper.isLow();
    }
}
