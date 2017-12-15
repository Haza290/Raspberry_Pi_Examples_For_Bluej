/**
 * A completed exercise class to provide you with answers.
 */
public class AccelerometerAnswers
{
    // instance variables
    private Accelerometer acc;

    /**
     * Constructor for objects of class AccelerometerAnswers
     */
    public AccelerometerAnswers()
    {
        acc = new Accelerometer();
    }

    /*
     * Output a nicely printed version of the X, Y and Z values on a single line. 
     * You may also have to round each value to an appropriate significant figure.
     */
    public void prettyPrint() {
        System.out.println("X: " + acc.getX() + " Y: " + acc.getY() + " Z: " + acc.getZ());
    }
    
    /*
     * Return true when the sensor is upside down. 
     * Hint: Use your prettyPrint() method to determine which axis you will have to monitor.
     */
    public boolean isUpsideDown() {
        return false;
    }
}
