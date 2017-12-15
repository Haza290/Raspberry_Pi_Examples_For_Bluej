import com.pi4j.io.gpio.*;

/**
 * Write a description of class Button here.
 * 
 * @author hs308
 * @version 1.0
 */
public class Button
{
    // the button instance is an input pin.
    private GpioPinDigitalInput button;
    
    //this array maps the GPIO pin numbers to integers
    private static final Pin[] pinMap = new Pin[] {RaspiPin.GPIO_00, RaspiPin.GPIO_01, RaspiPin.GPIO_02, RaspiPin.GPIO_03, RaspiPin.GPIO_04, 
        RaspiPin.GPIO_05, RaspiPin.GPIO_06, RaspiPin.GPIO_07, RaspiPin.GPIO_08, RaspiPin.GPIO_09, RaspiPin.GPIO_10, 
        RaspiPin.GPIO_11, RaspiPin.GPIO_12, RaspiPin.GPIO_13, RaspiPin.GPIO_14, RaspiPin.GPIO_15, RaspiPin.GPIO_16, 
        RaspiPin.GPIO_17, RaspiPin.GPIO_18, RaspiPin.GPIO_19, RaspiPin.GPIO_20};
    
    //the default pin, used by the constructor without parameters.
    private final static int defaultPin = 16;

    /**
     * Sets the default pins if none are chosen for the constructor.
     */
    public Button()
    {
        this(defaultPin);
    }

    /**
     * Constructor for objects of class Button. Sets up a pin as an input to be used to check if a button is pressed.
     */
    public Button(int pin)
    {
        //get a gpio controller
        GpioController gpio = GpioFactory.getInstance();
        
        button = gpio.provisionDigitalInputPin(pinMap[pin], PinPullResistance.PULL_DOWN);
    }
    
    /**
     * Checks to see if the buttons is being pressed and returns true if it is.
     */
    public boolean isPressed()
    { 
        return button.isHigh();
    }
}
