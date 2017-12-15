import com.pi4j.wiringpi.*;
import com.pi4j.io.gpio.*;
/**
 * Class to control speed and direction of a motor.
 * 
 * @author Harry Schneider
 * @version 2.0
 */
public class Motor
{
    //An array which maps the GPIO pin numbers to integers.
    private static final Pin[] pinMap = new Pin[] {RaspiPin.GPIO_00, RaspiPin.GPIO_01, RaspiPin.GPIO_02, RaspiPin.GPIO_03, RaspiPin.GPIO_04, 
        RaspiPin.GPIO_05, RaspiPin.GPIO_06, RaspiPin.GPIO_07, RaspiPin.GPIO_08, RaspiPin.GPIO_09, RaspiPin.GPIO_10, 
        RaspiPin.GPIO_11, RaspiPin.GPIO_12, RaspiPin.GPIO_13, RaspiPin.GPIO_14, RaspiPin.GPIO_15, RaspiPin.GPIO_16, 
        RaspiPin.GPIO_17, RaspiPin.GPIO_18, RaspiPin.GPIO_19, RaspiPin.GPIO_20};
    
    // The 3 pins needed to run the motor.
    private GpioPinDigitalOutput forwardPin;
    private GpioPinDigitalOutput backwardPin;
    private int speedPin;
    
    // The default pins used to run the motor.
    private final static int defaultForwardPin = 10;
    private final static int defaultBackwardPin = 11;
    private final static int defaultSpeedPin = 6;

    /**
     * Sets the default pins if none are chosen for the constructor.
     */
    public Motor()
    {
        this(defaultForwardPin, defaultBackwardPin, defaultSpeedPin);
    }
    
    /**
     * Constructor for objects of class Motor. Sets up the 2 pins to chose if the motor moves fowards or backwards
     * and sets up the PWM (pulse width modulation) pin used to set the speed.
     */
    public Motor(int forwardPin, int backwardPin, int speedPin)
    {
        Gpio.wiringPiSetup();
        GpioController gpio = GpioFactory.getInstance();

        this.forwardPin = gpio.provisionDigitalOutputPin(pinMap[forwardPin], PinState.LOW);
        this.backwardPin = gpio.provisionDigitalOutputPin(pinMap[backwardPin], PinState.LOW);
        this.speedPin = speedPin;
        SoftPwm.softPwmCreate(speedPin, 0, 100);
    }

    /**
     * Sets the speed of the motor between 0 and 100.
     */
    public void setSpeed(int speed)
    {
        // Checks that speed is set bettween 0 and 100
        if( 0 <= speed && speed <= 100 ) { 
            SoftPwm.softPwmWrite(speedPin, speed);
        } else {
            System.out.println("You tried to set a speed: " + speed + ". Please set a speed between 0 and 100.");
        }
    }
    
    /**
     * Sets the motor to move forwards.
     */
    public void forwards()
    {
        forwardPin.high();
        backwardPin.low();
    }

    /**
     * Sets the motor to move backwards.
     */
    public void backwards()
    {
        forwardPin.low();
        backwardPin.high();
    }
    
    /**
     * Stop the movement of the motor. Note it does not change the motors speed setting so when forwards or
     * backwards is called the motor will run at the last speed set.
     */
    public void stop()
    {
        forwardPin.low();
        backwardPin.low();
    }   
}
