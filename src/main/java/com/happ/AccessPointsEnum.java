package com.happ;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Created by oleksandr.agafonov on 30-Nov-16.
 */
public enum AccessPointsEnum {
    MAIN_HOME_ENTRANCE("MAIN_HOME_ENTRANCE", RaspiPin.GPIO_00, 7000),
    MAIN_GATE("MAIN_GATE", RaspiPin.GPIO_01, 5000),
    WICKET_NOVUS("WICKET_NOVUS", RaspiPin.GPIO_02, 7000),
    WICKET_MAIN_GATE("WICKET_MAIN_GATE", RaspiPin.GPIO_03, 7000);
    //    GATE_NOVUS("GATE_NOVUS", RaspiPin.GPIO_04, 5000);


    private final String name;
    private Pin pin;
    private final int signalDurationTime;

    AccessPointsEnum(String name, Pin pin, int signalDurationTime) {
        this.name=name;
        this.pin = pin;
        this.signalDurationTime = signalDurationTime;
    }

    public String getName() {
        return name;
    }
    public Pin getRaspiPin(){return pin;}
    public int getSignalDurationTime() {
        return signalDurationTime;
    }

    public static AccessPointsEnum getAccessPointEnumByName(String v) {
        for (AccessPointsEnum c: AccessPointsEnum.values()) {
            if (c.getName().equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
