import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;

/**
 * Interfaces with MCU-6050 sensor to grab temperature data;.
 * 
 * @ojp5 
 * @20-12-15
 */
public class Thermometer
{
    I2CBus bus;
    I2CDevice device;
    byte[] bytes;
    SensorLoop sensorLoop;

    /**
     * Constructor for objects of class Gyroscope
     */
    public Thermometer(boolean quiet, int address)
    {
        try {
            connect(quiet,address);
        }
        catch(IOException e) {
            System.out.println("Couldn't connect! Are your drivers and wiring done properley?");
        }
    }

    /**
     * Default Constructor
     */
    public Thermometer() {
        this(true,0x68);
    }
    
     /**
     * Constructor for non-default device address
     */
    public Thermometer(int address) {
        this(true, address);
    }

    public void connect(boolean quiet, int address) throws IOException {
        bus = I2CFactory.getInstance(I2CBus.BUS_1); //May have to change to '0' for older Pis
        if(!quiet) {
            System.out.println("Connected to bus OK!"); //DEBUG
        }

        device = bus.getDevice(address); //GYRO uses this bus address
        if(!quiet) {
            System.out.println("Connected to device OK!");
        }

        device.write(0x6B, (byte) 0b00000000); //Write a zero to the device to activate
        if(!quiet) {
            System.out.println("Device Sensing OK!");
        }

        //Start reading from sensor in seperate thread so we can still execute
        sensorLoop = new SensorLoop();
        new Thread(sensorLoop).start();
    }

    /*
     * Simple getter for the Temperature value. This reads the most recently available temperature from the thread.
     */
    public float getTemperature() {
        return sensorLoop.getTemperature();
    }

    /*
     * Inner class to execute the reading of the sensor continuously in a seperate thread.
     */
    public class SensorLoop implements Runnable {
        public float temperature;
        @Override
        public void run() {
            //Array to hold the value of the two registers we are reading
            bytes = new byte[2];
            while(true) {
                try {
                    //Read device. r becomes the number of registers read. the data goes into the bytes array
                    int r = device.read(0x41, bytes, 0, bytes.length);
                    //Wrong register length check
                    if (r != bytes.length) {
                        System.out.println("Error reading data: Wrong number of registries found: " + r);
                    }
                    //Combine the two registries together, bitshifting the first one.
                    short temp = (short) (bytes[0] << 8 | bytes[1]);
                    //Create a Short object to convert to other types
                    Short temp_object = new Short(temp);
                    //Assign field variable temperature the current temp
                    temperature = temp_object.floatValue()/340.00f+36.53f;
                    //Sleep for one second so we don't overload the pi
                    Thread.sleep(1000);
                }
                catch(IOException | InterruptedException e) {
                    System.err.println("Error reading form device");
                }
            }
        }

        // Passes the temperature from the Thread to the main class when needed
        public float getTemperature() {
            return temperature;
        }
    }
}
