
/**
 * This Class allows you to drive around a car and control it with 4 buttons.
 * 
 * @author Harry Schneider (HS308) 
 * @version 1.0
 */
public class ControllerExercises
{
    // Default button pins to be used if none are stated.
    private final static int defaultForwardsButtonPin = 16;
    private final static int defaultBackwardsButtonPin = 1;
    private final static int defaultRightButtonPin = 4;
    private final static int defaultLeftButtonPin = 5;
    
    // Button and Car objects needed.
    private Car car;
    private Button forwardsButton;
    private Button backwardsButton;
    private Button rightButton;
    private Button leftButton;

    /**
     * Default constructor used if no pins are given.
     */
    public ControllerExercises()
    {
       car = new Car();
       setUpButtons(defaultForwardsButtonPin, defaultBackwardsButtonPin, defaultRightButtonPin, 
                    defaultLeftButtonPin);
    }
    
    /**
     * Constructor used if specific pins are given.
     */
    public ControllerExercises(int rightForwardsPin, int rightBackwardsPin, int rightGoPin, int leftForwardsPin, 
                      int leftBackwardsPin, int leftGoPin, int forwardsButtonPin, int backwardsButtonPin,
                      int rightButtonPin, int leftButtonPin)
    {
       car = new Car(rightForwardsPin, rightBackwardsPin, rightGoPin, leftForwardsPin, leftBackwardsPin, leftGoPin);
       setUpButtons(forwardsButtonPin, backwardsButtonPin, rightButtonPin, leftButtonPin);
    }

    /**
     * Sets up the 4 buttons to dive the car. Used in the constructors.
     */
    private void setUpButtons(int forwardsButtonPin, int backwardsButtonPin, int rightButtonPin, int leftButtonPin)
    {
        forwardsButton = new Button(forwardsButtonPin);
        backwardsButton = new Button(backwardsButtonPin);
        rightButton = new Button(rightButtonPin);
        leftButton = new Button(leftButtonPin);
    }
    
    /**
     * The main part of the programe which loops arround checking button inputs.
     */
    public void main()
    {
        // While(true) means loop forever.
       while(true) {
           
        }
    }
}