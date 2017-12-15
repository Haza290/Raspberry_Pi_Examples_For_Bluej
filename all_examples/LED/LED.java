import com.pi4j.wiringpi.*;
import com.pi4j.io.gpio.*;

/**
 * Simple LED class that turns a pinned LED on or off. Uses Wiring Pi Pin 1.
 * @jp481
 */
public class LED
{
    //An array which maps the GPIO pin numbers to integers.
    private static final Pin[] pinMap = new Pin[] {RaspiPin.GPIO_00, RaspiPin.GPIO_01, RaspiPin.GPIO_02, RaspiPin.GPIO_03, RaspiPin.GPIO_04, 
        RaspiPin.GPIO_05, RaspiPin.GPIO_06, RaspiPin.GPIO_07, RaspiPin.GPIO_08, RaspiPin.GPIO_09, RaspiPin.GPIO_10, 
        RaspiPin.GPIO_11, RaspiPin.GPIO_12, RaspiPin.GPIO_13, RaspiPin.GPIO_14, RaspiPin.GPIO_15, RaspiPin.GPIO_16, 
        RaspiPin.GPIO_17, RaspiPin.GPIO_18, RaspiPin.GPIO_19, RaspiPin.GPIO_20};
    
    private final GpioController gpio;
    private final GpioPinDigitalOutput pin;
    
    private final static int defaultPin = 1;
    
    /**
     * Sets the default pin if none are chosen for the constructor.
     */
    public LED()
    {
        this(defaultPin);
    }
    
    /**
     * Constructor for LED. Sets up an LED on connected to a given pin.
     */
    public LED(int pin) 
    {
        //Set Up 
        Gpio.wiringPiSetup();
        gpio = GpioFactory.getInstance();
        this.pin = gpio.provisionDigitalOutputPin(pinMap[pin], PinState.HIGH);
    }

    /**
     * Turns LED on
     */
    public void on() 
    {
        pin.high();
    }

    /**
     * Turns LED off
     */
    public void off() 
    {
        pin.low();
    }

    /**
     * Pulses LED for x milliseconds.
     */
    public void pulse(int x) 
    {
        pin.pulse(x, true);
    }
}
