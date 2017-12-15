import java.util.Date;
import java.util.Timer;
import java.text.SimpleDateFormat;
import java.util.TimerTask;

/**
 * A simple Alarm clock example
 * 
 * @ojp5
 * @19-11-15
 */
public class AlarmClock
{
    private Date date;
    private JukeBox jukebox;
    private Timer timer;
    public boolean alarm;

    /**
     * Constructor for objects of class AlarmClock
     */
    public AlarmClock()
    {
        date = new Date();
        timer = new Timer();
        jukebox = new JukeBox();
        alarm = false;
    }

    class Alert extends TimerTask 
    {
         @Override
         public void run() {
             alarm = true;
             System.out.println("Alarm set off");
             while(alarm == true) {
             jukebox.play(0);
            }
         }
    }
    
    /**
     * Sets an Alarm. Format: dd-mm-yy hh:mm:ss
     */
    public void setAlarm(String datetime)
    {
        date = new Date(); //Refresh our Time variable with current time
        Date setdate = null;
        
        try {
            setdate = new SimpleDateFormat("dd-MM-yy hh:mm:ss").parse(datetime); //Parse the string and convert into a Date object
        }
        catch(Exception e) {
            System.out.println("Invalid Date/Time, Alarm could not be sent");
        }
        
        if (setdate !=null) { //Check that object is not null
            if(date.compareTo(setdate) < 0) { //If time is after current time
                timer.schedule(new Alert(),setdate);
                System.out.println("Alarm set for: " + datetime);
            }
            else {
                // Set for next date maybe?
            }
        }
        else {
            System.out.println("Invalid Date/Time, Alarm could not be sent");
        }
    }
    
    /**
     * Resets the Alarm
     */
    public void reset() {
        alarm = false;
    }
  
}
