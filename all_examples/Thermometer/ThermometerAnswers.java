/**
 * A completed exercise class to provide you with answers.
 */
public class ThermometerAnswers
{
    // instance variables
    private Thermometer thermo;
    private Speaker speaker;

    /**
     * Constructor for objects of class ThermomterAnswers
     */
    public ThermometerAnswers()
    {
        thermo = new Thermometer();
        speaker = new Speaker();
    }

    /**
     * Return true when the temperature is above the threshold specified and return false 
     * when this is not the case.
     */
    public boolean tooHot(int limit) {
        float temp = thermo.getTemperature();
        if(temp > limit) {
            speaker.play("A");
            return true;
        }
        else {
            return false;
        }
    }
}
