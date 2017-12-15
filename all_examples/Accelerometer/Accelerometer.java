import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import java.lang.Math.*;

/**
 * Interfaces with MCU-6050 sensor to grab accelerometer data;.
 * 
 * @ojp5 
 * @20-12-15
 */
public class Accelerometer
{
    I2CBus bus;
    I2CDevice device;
    byte[] bytes;
    SensorLoop sensorLoop;

    /**
     * Debug constructor with the option to get output
     */
    public Accelerometer(boolean quiet,int address)
    {
        try {
            connect(quiet, address);
        }
        catch(IOException e) {
            System.out.println("Couldn't connect! Are your drivers and wiring done properley?");
        }
    }

    /**
     * Default Constructor
     */
    public Accelerometer() {
        this(true,0x68);
    }
    
    /**
     * Constructor for non-default device address
     */
    public Accelerometer(int address) {
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
        device.write(0x19, (byte) 0b00000000);
        device.write(0x1A, (byte) 0b00000001);
        device.write(0x1C, (byte) 0b00000000);
        device.write(0x23, (byte) 0b00000000);
        device.write(0x38, (byte) 0b00000000);
        device.write(0x6C, (byte) 0b00000000);
        
        if(!quiet) {
            System.out.println("Device Sensing OK!");
        }

        //Start reading from sensor in seperate thread so we can still execute
        sensorLoop = new SensorLoop();
        new Thread(sensorLoop).start();
    }

    /*
     * Simple getter for the X value. This reads the most recently available data from the thread.
     */
    public int getX() {
        return sensorLoop.getX();
    }
    
    /*
     * Simple getter for the Y value. This reads the most recently available data from the thread.
     */
    public double getY() {
        return sensorLoop.getY();
    }
    
    
    /*
     * Simple getter for the Z value. This reads the most recently available data from the thread.
     */
    public double getZ() {
        return sensorLoop.getZ();
    }

    /*
     * Inner class to execute the reading of the sensor continuously in a seperate thread.
     */
    public class SensorLoop implements Runnable {
        public int x;
        public double y;
        public double z;
        @Override
        public void run() {
            //Array to hold the value of the two registers we are reading
            bytes = new byte[6];
            while(true) {
                try {
                    //Read device. r becomes the number of registers read. the data goes into the bytes array
                    int r = device.read(0x3B, bytes, 0, bytes.length);
                    //Wrong register length check
                    if (r != bytes.length) {
                        System.out.println("Error reading data: Wrong number of registries found: " + r);
                    }
                    //Combine the two registries together, bitshifting the first one.
                    int x = (bytes[0] << 8) + bytes[1];
                    short yb = (short) (bytes[2] << 8 | bytes[3]);
                    short zb = (short) (bytes[4] << 8 | bytes[5]);
                    //Create a Short object to convert to other types
                    Short y_object = new Short(yb);
                    Short z_object = new Short(zb);
                    //Assign field variable
                    y = y_object.doubleValue();
                    z = z_object.doubleValue();
                    System.out.println(x + " " + y + " " + z);
                    //Sleep for two seconds
                    Thread.sleep(2000);
                }
                catch(IOException | InterruptedException e) {
                    System.err.println("Error reading form device");
                }
            }
        }
        
        // Passes the data from the Thread to the main class when needed
        public int getX() {
            return x;
        }
        
        public double getY() {
            return y;
        }
        
        public double getZ() {
            return z;
        }
    }
}
