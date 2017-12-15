
/**
 * This Class allows the car to drive about using the 2 bumpers to avoid objects.
 * 
 * @author Harry Schneider (HS308) 
 * @version 1.0
 */
public class AlgorithmExercises
{
    // Default bumper pins to be used if none are stated.
    private final static int defaultRightBumperPin = 16;
    private final static int defaultLeftBumperPin = 1;
    
    // Bumper and Car objects needed.
    private Car car;
    private Bumper rightBumper;
    private Bumper leftBumper;

    /**
     * Default constructor used if no pins are given.
     */
    public AlgorithmExercises()
    {
       car = new Car();
       setUpBumpers(defaultRightBumperPin, defaultLeftBumperPin);
       main();
    }
    
    /**
     * Constructor used if specific pins are given.
     */
    public AlgorithmExercises(int rightForwardsPin, int rightBackwardsPin, int rightGoPin, int leftForwardsPin, 
                      int leftBackwardsPin, int leftGoPin, int rightBumperPin, int leftBumperPin)
    {
       car = new Car(rightForwardsPin, rightBackwardsPin, rightGoPin, leftForwardsPin, leftBackwardsPin, leftGoPin);
       setUpBumpers(rightBumperPin, leftBumperPin);
       main();
    }

    /**
     * Sets up the 2 bumpers to direct the car. Used in the constructors.
     */
    private void setUpBumpers(int rightBumperPin, int leftBumperPin)
    {
        rightBumper = new Bumper(rightBumperPin);
        leftBumper = new Bumper(leftBumperPin);
    }
    
    /**
     * The main part of the programe which loops arround checking bumper inputs.
     */
    public void main()
    {
       
    }
        
     /**
     * Wait for a number of milliseconds
     */
    public void sleepMillisec(int millisec)
    {
        try
        {
            Thread.sleep(millisec);
        }
        catch ( InterruptedException e)
        {
        }
    }
}
