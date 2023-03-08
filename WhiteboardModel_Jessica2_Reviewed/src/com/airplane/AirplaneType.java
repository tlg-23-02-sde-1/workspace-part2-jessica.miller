package com.airplane;

public enum AirplaneType {
    BOE_737("Boeing-737"),
    BOE_747("Boeing-747"),
    BOE_767("Boeing-767"),
    NEXT_GEN_737("Nextgen-737");

    private final String display;

    //constructor
    AirplaneType(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    @Override
    public String toString() {
        return getDisplay();
    }
}




