package com.duckrace.client;

/*
* Application main-class
* Instantiates controller / starts
*
* NOTE: every Main class has own Run Config: (i.e., C:\StudentWork-TLG\IntmJ\workspace\DuckRace)
 */

import com.duckrace.app.DuckRaceApp;

class Main {
    public static void main(String[] args) {
        DuckRaceApp app = new DuckRaceApp();
        app.execute();
    }
}