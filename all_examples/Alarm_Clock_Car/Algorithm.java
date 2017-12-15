
/**
 * This Class allows the car to drive about using the 2 bumpers to avoid objects.
 * 
 * @author Harry Schneider (HS308) 
 * @version 1.0
 */
public class Algorithm
{
    // Default bumper and button pins to be used.
    private final static int defaultRightBumperPin = 16;
    private final static int defaultLeftBumperPin = 1;
    private final static int defaultResetButtonPin = 15;

    // Bumper, Button and Car objects needed.
    private Car car;
    private AlarmClock alarmClock;
    private Bumper rightBumper;
    private Bumper leftBumper;
    private Button resetButton;

    /**
     * Default constructor used if no pins are given.
     */
    public Algorithm(String dateTime)
    {
        // Sets up alarmClock.
        alarmClock = new AlarmClock();
        alarmClock.setAlarm(dateTime);
        // Sets up car.
        car = new Car();
        car.setSpeed(100);
        // Sets up the bumpers.
        rightBumper = new Bumper(defaultRightBumperPin);
        leftBumper = new Bumper(defaultLeftBumperPin);
        // Sets up the button.
        resetButton = new Button(defaultResetButtonPin);

        // Start the main part of are program.
        main();
    }

    /**
     * The main part of the programe which loops arround checking bumper inputs.
     */
    public void main()
    {        
        while(true) {
            // While the alarm is going off move the car.
            while(alarmClock.alarm) {
                // Sets cars moving forwards.
                car.forwards();

                // Checks if rightBumper is being pressed.
                if(rightBumper.isPressed()) {
                    // Reverse and turns the car left before moving forwards again.
                    car.backwards();
                    sleepMillisec(1000);
                    car.leftQuick();
                    sleepMillisec(1000);
                }
                // Checks if leftBumper is being pressed.
                if(leftBumper.isPressed()) {
                    // Reverse and turns the car right before moving forwards again.
                    car.backwards();
                    sleepMillisec(1000);
                    car.rightQuick();
                    sleepMillisec(1000);
                }
                // Checks if resetButton is being pressed.
                if(resetButton.isPressed()) {
                    car.stop();
                    alarmClock.reset();
                }
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
