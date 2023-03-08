package com.duckrace.client;


import com.duckrace.appcontroller.DuckRaceApp;

/*Application main-class
* Instantiates controller and says "go"*/
//For project reference (project week)
public class Main {

    public static void main(String[] args) {
        DuckRaceApp app = new DuckRaceApp();
        app.execute();
    }
}