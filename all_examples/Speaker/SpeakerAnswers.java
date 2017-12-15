/**
 * A completed exercise class to provide you with answers.
 */
public class SpeakerAnswers
{
    // instance variables
    private Speaker speak;
    private Button button;

    /**
     * Constructor for objects of class SpeakerExercises
     */
    public SpeakerAnswers()
    {
        speak = new Speaker();
    }

    /*
     * Should start at a low note, and get progressively higher.
     */
    public void ascendingPitch() {
        for(int i = 200; i < 1000; i+=50) {
            speak.play(i);
        }
    }
    
    /*
     * Try and combine with the Button class. So when a button is pressed the speaker makes a noise. 
     * To extend this, the speaker should turn off when the button is pressed again
     */
    public void speakerWithButton() {
        boolean pressed = false;
        while(true) {
            if(button.isPressed()) {
                pressed = true;
            }
            if(pressed) {
                speak.play("A");
            }
            if(button.isPressed()) {
                pressed = false;
            }
        }
    }
}
