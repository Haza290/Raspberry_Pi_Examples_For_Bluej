/**
 * The completed ecervises class that counts how many time button1 is pressed and resets that counter when button2
 * is pressed
 * 
 * @author hs308
 * @version 1.0
 */
public class ButtonAnswers
{
    // Button objects 
    private Button button1;
    private Button button2;
    
    private int counter;

    /**
     * Constructor for objects of class ButtonAnswers. Creates 2 button objects and sets the counter to 0.
     */
    public ButtonAnswers()
    {
        // Instantiates button 1 and 2
        button1 = new Button(16);
        button2 = new Button(1);
        counter = 0;
    }

    /**
     * Loop around forever counting button presses.
     */
    public int countButtonPresses()
    {
        // while(true) mean repeat this while loop forever.
        while(true) {
            // Checks if button 1 is being pressed.
            if(button1.isPressed()) {
                counter++;
                System.out.println("Count: " + counter);
            }
            // Waits for button1 to stop being pressed so we don't keep counting and printing to the screen
            // if the button1 is held down.
            while(button1.isPressed()) {
            }
            
            // Checks if button 2 is being pressed.
            if(button2.isPressed()) {
                counter = 0;
            }
        }
    }
}
