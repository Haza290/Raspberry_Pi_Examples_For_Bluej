
/**
 * Write a description of class MotorAnswers here.
 * 
 * @author Harry Schneider (hs308) 
 * @version 1.0
 */
public class MotorAnswers
{
    // Motor object
    private Motor motor;

    /**
     * Creates a Motor object called motor
     */
    public MotorAnswers()
    {
        motor = new Motor();
    }
    
    /**
     * Moves a motor forwards at full speed
     */
    public void forwardsFullSpeed()
    {
        motor.forwards();
        motor.setSpeed(100);
    }
    
    /**
     * Moves a motor forwards at a given speed
     */
    public void forwardsSetSpeed(int speed)
    {
        motor.forwards();
        motor.setSpeed(speed);
    }
    
    /**
     * Moves a motor in a given direction at a given speed
     */
    public void setDirectionSetSpeed(int speed, boolean forwards)
    {
        if(forwards) {
            motor.forwards();
        }
        else {
            motor.backwards();
        }
        motor.setSpeed(speed);
    }
    
    /**
     * Stops the motor and sets its speed to 0
     */
    public void stop()
    {
        motor.setSpeed(0);
        motor.stop();
    }
}
