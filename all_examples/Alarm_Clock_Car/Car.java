
/**
 * This class allows you to control 2 motors independantly to create a basic car
 * 
 * @author Harry Schneider
 * @version 2.0
 */
public class Car
{
    // The defult pins used to run the right motor
    private final static int defultRightForwardPin = 10;
    private final static int defultRightBackwardPin = 11;
    private final static int defultRightSpeedPin = 6;
    // The defult pins used to run the left motor
    private final static int defultLeftForwardPin = 14;
    private final static int defultLeftBackwardPin = 13;
    private final static int defultLeftSpeedPin = 12;
    
    public Motor motorRight;
    public Motor motorLeft;
        
    /**
     * Sets the defult pins if none are chosen for the constructor.
     */
    public Car()
    {
        this(defultRightForwardPin, defultRightBackwardPin, defultRightSpeedPin, 
             defultLeftForwardPin, defultLeftBackwardPin, defultLeftSpeedPin);
    }
    
    /**
     * Constructor for objects of class Car. Creates the 2 motor objects.
     */
    public Car(int rightForwardPin, int rightBackwardPin, int rightGoPin, 
               int leftForwardPin, int leftBackwardPin, int leftGoPin)
    {
        motorRight = new Motor(rightForwardPin, rightBackwardPin, rightGoPin);
        motorLeft = new Motor(leftForwardPin, leftBackwardPin, leftGoPin);
    }
    
    /**
     * Sets the speed that the 2 motors will run at between 0 and 100.
     */
    public void setSpeed(int speed)
    {
        motorRight.setSpeed(speed);
        motorLeft.setSpeed(speed);
    }
    
    /**
     * Sets both motors to move forwards.
     */
    public void forwards()
    {
        motorRight.forwards();
        motorLeft.forwards();
    }
    
    /**
     * Sets both motors to move backwards.
     */
    public void backwards()
    {
        motorRight.backwards();
        motorLeft.backwards();
    }
        
    /**
     * Sets the motors so they turn right.
     */
    public void right()
    {
        motorRight.stop();
        motorLeft.forwards();
    }
    
    /**
     * Sets the motors so they turn right quicker.
     */
    public void rightQuick()
    {
        motorRight.backwards();
        motorLeft.forwards();
    }
    
    /**
     * Sets the motors so they turn left.
     */
    public void left()
    {
        motorRight.forwards();
        motorLeft.stop();
    }
    
    /**
     * Sets the motors so they turn left quicker.
     */
    public void leftQuick()
    {
        motorRight.forwards();
        motorLeft.backwards();
    }
    
    /**
     * Stops both the motors.
     */
    public void stop()
    {
        motorRight.stop();
        motorLeft.stop();
    }
    
    /**
     * Turns the car quickly or normally, depending on boolean quick, a direction determined by 
     * boolean turnRight.
     */
    public void turn(boolean turnRight, boolean quick)
    {
        if(turnRight) {
            if(quick) {
                rightQuick();
            }
            else {
                right();
            }
        }
        else {
            if(quick) {
                leftQuick();
            }
            else {
                left();
            }
        }
    }
}
