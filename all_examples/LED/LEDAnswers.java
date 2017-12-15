/**
 * A completed exercise class to provide you with answers.
 * 
 * @author ojp
 * @version 20-03-16
 */
public class LEDAnswers
{
    // instance variables
    private LED led;
    private Button button;

    /**
     * Constructor for objects of class LEDExcercises
     */
    public LEDAnswers()
    {
        led = new LED();
        button = new Button();
    }

    /**
     * Make the LED flash X amount of times. With X being a parameter.
     */
    public void flashXTimes(int x)
    {
        led.off();
        for(int y = 0; y < x; y++) {
            led.on();
            try {
                Thread.sleep(500);
            }
            catch(InterruptedException e) {
                System.err.println("Error sleeping between flashes");
            }
            led.off();
        }
    }

    /**
     * Combine with the Button Class. So when the Button is pressed, the light comes on. When the button is released, the light turns off.
     */
    public void ledWithButton() {
        while(true) {
            while(button.isPressed()) {
                led.on();
            }
            led.off();
            try {
                Thread.sleep(50);
            }
            catch(InterruptedException e) {
                System.err.println("Error sleeping between flashes");
            }
        }
    }
}
