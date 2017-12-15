/**
 * An ecervises class that counts how many time button1 is pressed and resets that counter when button2
 * is pressed
 * 
 * @author hs308
 * @version 1.0
 */
public class ButtonExercises
{
    // Button objects
    private Button button1;
    private Button button2;
    
    private int counter;

    /**
     * Constructor for objects of class ButtonAnswers. Creates 2 button objects and sets the counter to 0.
     */
    public ButtonExercises()
    {
        // Instantiates button 1
        button1 = new Button(16);
        // Exercise 2: Instantiate the second button.
        
        counter = 0;
    }

    /**
     * Loop around forever counting button presses.
     */
    public int countButtonPresses()
    {
        // while(true) means repeat this while loop forever.
        while(true) {
            // Exercise 1: Check if button1 is being pressed.
            
            
            // This while loop waits for button1 to stop being pressed so we don't keep counting and printing 
            // to the screen while button1 is held down.
            while(button1.isPressed()) {
            }
            
            // Exercise 3: Check if button2 is being pressed.
        }
    }
}
