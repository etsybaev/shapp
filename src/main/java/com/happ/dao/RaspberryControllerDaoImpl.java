package com.happ.dao;

import com.happ.AccessPointsEnum;
import com.pi4j.io.gpio.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ievgenii.tsybaiev on 11.01.2017.
 */

public class RaspberryControllerDaoImpl{

    // create gpio controller
    private final GpioController gpio = GpioFactory.getInstance();
    private GpioPinDigitalOutput pin;
    private AccessPointsEnum accessPoint;
    private static Map<AccessPointsEnum, RaspberryControllerDaoImpl> raspberryControllerDaoImplInstanceMap = new HashMap<>();

    private RaspberryControllerDaoImpl(AccessPointsEnum accessPoint){
        this.accessPoint = accessPoint;
        // provision gpio pin number as an output pin
        this.pin = gpio.provisionDigitalOutputPin(accessPoint.getRaspiPin(), PinState.LOW);
        // set shutdown state for this pin
        this.pin.setShutdownOptions(true, PinState.LOW);
    }

    public static RaspberryControllerDaoImpl getInstance(AccessPointsEnum accessPoint){
        RaspberryControllerDaoImpl raspberryControllerDao = raspberryControllerDaoImplInstanceMap.get(accessPoint);
        if(raspberryControllerDao == null){
            raspberryControllerDao = new RaspberryControllerDaoImpl(accessPoint);
            raspberryControllerDaoImplInstanceMap.put(accessPoint, raspberryControllerDao);
        }
        return raspberryControllerDao;
    }


    public void openAccessPoint() {
        pin.pulse(accessPoint.getSignalDurationTime(), true); // set second argument to 'true' use a blocking call
    }

    public void completelyShutDownService(){
        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        //TODO check if its affect all the pins of just current one
        gpio.shutdown();
    }
}
