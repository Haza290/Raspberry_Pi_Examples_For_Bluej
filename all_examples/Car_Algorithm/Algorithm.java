
/**
 * This Class allows the car to drive about using the 2 bumpers to avoid objects.
 * 
 * @author Harry Schneider (HS308) 
 * @version 1.0
 */
public class Algorithm
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
    public Algorithm()
    {
       car = new Car();
       setUpBumpers(defaultRightBumperPin, defaultLeftBumperPin);
       main();
    }
    
    /**
     * Constructor used if specific pins are given.
     */
    public Algorithm(int rightForwardsPin, int rightBackwardsPin, int rightGoPin, int leftForwardsPin, 
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
        // Sets cars moving forwards full speed.
        car.setSpeed(100);
        car.forwards();
        
        // While(true) means loop forever.
        while(true) {
            // Checks if rightBumper is being pressed.
            if(rightBumper.isPressed()) {
                // Reverse and turns the car left before moving forwards again.
                car.backwards();
                sleepMillisec(1000);
                car.leftQuick();
                sleepMillisec(1000);
                car.forwards();
            }
            // Checks if leftBumper is being pressed.
            if(leftBumper.isPressed()) {
                // Reverse and turns the car right before moving forwards again.
                car.backwards();
                sleepMillisec(1000);
                car.rightQuick();
                sleepMillisec(1000);
                car.forwards();
            }
        }
    }
    
    /**
     * A different way the program could be written to make use of method turn in class Car
     */
    public void main2()
    {
        // Sets cars moving forwards full speed.
        car.setSpeed(100);
        car.forwards();
        
        // Creates a boolean named right.
        boolean right = false;
        
        // While(true) means loop forever.
        while(true) {
            // Checks if either bumper is being pressed
            if(rightBumper.isPressed()||leftBumper.isPressed()) {
                // if it is right bumper being pressed set boolean right to true, else set it to false.
                if(rightBumper.isPressed()) {
                    right = true;
                } else {
                    right = false;
                }
                
                // Backup the car and turn it in the opersite direction to the bumper that has just been pressed
                // then move forwards.
                car.backwards();
                sleepMillisec(1000);
                car.turn(right, true);
                sleepMillisec(1000);
                car.forwards();
            }
        }
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
