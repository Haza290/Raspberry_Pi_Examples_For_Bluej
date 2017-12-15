
/**
 * Write a description of class MotorExercises here.
 * 
 * @author Harry Schneider (hs308) 
 * @version 1.0
 */
public class MotorExercises
{
    // Motor object
    private Motor motor;

    /**
     * Creates a Motor object called motor
     */
    public MotorExercises()
    {
        motor = new Motor();
    }
    
    /**
     * Moves a motor forwards at full speed
     */
    public void forwardsFullSpeed()
    {
        //Exercise 1: Fill out this method.
        
    }
    
    /**
     * Moves a motor forwards at a given speed
     */
    public void forwardsSetSpeed(int speed)
    {
        //Exercise 2: Fill out this method.
        
    }
    
    /**
     * Moves a motor in a given direction at a given speed
     */
    public void setDirectionSetSpeed(int speed, boolean forwards)
    {
        //Exercise 3: Fill out this method.
        
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
