
/**
 * This class (when you complete it) allows you to control 2 motors independantly to create a basic car.
 * 
 * @author Harry Schneider (HS308)
 * @version 2.0
 */
public class CarExercises
{
    // The default pins used to run the right motor
    private final static int defaultRightForwardPin = 10;
    private final static int defaultRightBackwardPin = 11;
    private final static int defaultRightSpeedPin = 6;
    // The default pins used to run the left motor
    private final static int defaultLeftForwardPin = 14;
    private final static int defaultLeftBackwardPin = 13;
    private final static int defaultLeftSpeedPin = 12;
    // Motor objects needed for this class
    public Motor motorRight;
    public Motor motorLeft;
        
    /**
     * Sets the default pins if none are chosen for the constructor.
     */
    public CarExercises()
    {
        this(defaultRightForwardPin, defaultRightBackwardPin, defaultRightSpeedPin, 
             defaultLeftForwardPin, defaultLeftBackwardPin, defaultLeftSpeedPin);
    }
    
    /**
     * Constructor for objects of class Car. Creates the 2 motor objects.
     */
    public CarExercises(int rightForwardPin, int rightBackwardPin, int rightGoPin, 
               int leftForwardPin, int leftBackwardPin, int leftGoPin)
    {
        motorRight = new Motor(rightForwardPin, rightBackwardPin, rightGoPin);
        motorLeft = new Motor(leftForwardPin, leftBackwardPin, leftGoPin);
    }
     
    /**
     * Sets both motors to move forwards.
     */
    public void forwards()
    {
        
    }
    
    /**
     * Stops both the motors
     */
    public void stop()
    {
        motorRight.stop();
        motorLeft.stop();
    }
}
