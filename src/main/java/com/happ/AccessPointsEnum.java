package com.happ;

/**
 * Created by oleksandr.agafonov on 30-Nov-16.
 */
public enum AccessPointsEnum {
    MAIN_HOME_ENTRANCE("MAIN_HOME_ENTRANCE"),
    MAIN_GATE("MAIN_GATE"),
    GATE_NOVUS("GATE_NOVUS"),
    WICKET_MAIN_GATE("WICKET_MAIN_GATE"),
    WICKET_NOVUS("WICKET_NOVUS");


    private final String name;

    AccessPointsEnum(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
