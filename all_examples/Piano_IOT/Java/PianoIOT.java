import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import java.util.Random;

/**
 * Listens to an MQTT server and plays the notes that it receives with the Speaker class.
 * 
 * @author ojp5
 * @version 19-12-15
 */
public class PianoIOT implements MqttCallback
{
    //MQTT
    String topic = "unikent/users/ojp5/piano";
    String serverURI = "tcp://doughnut.kent.ac.uk:1883";
    String clientID;
    MqttConnectOptions options;
    Speaker speaker;

    /**
     * Constructor for objects of class PianoIOT
     */
    public PianoIOT()
    {
        speaker = new Speaker();
        Random random = new Random();
        clientID = "pianoIOT-" + random.nextInt(999);
        connect();
    }

    /**
     * Connects to MQTT Server
     */
    public void connect()
    {
        options = new MqttConnectOptions();     
        options.setCleanSession(true);
        options.setKeepAliveInterval(30);
        try {
            MqttClient myClient = new MqttClient(serverURI, clientID);
            myClient.setCallback(this);
            myClient.connect(options);
            myClient.subscribe(topic, 0);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        speaker.play(message.getPayload().toString());
        System.out.println("Playing: " + new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
    }

    @Override
    public void connectionLost(Throwable t) {
        connect();
    }
}
