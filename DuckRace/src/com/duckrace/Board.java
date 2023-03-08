package com.duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    // Updates board (racerMAp) by making a DuckRacer win
    // fetch existing DuckRacer from racerMap
    // or create a new DuckRacer, then .put() in map
    // then make it win
    public void update(int id, Reward reward) {
        DuckRacer racer = null; // both reasons need racer

        if (racerMap.containsKey(id)) {
            racer = racerMap.get(id); // fetch existing
        }
        else {
            racer = new DuckRacer(id, studentIdMap.get(id)); // returns 'name' String
            racerMap.put(id, racer);
        }

        racer.win(reward); // either way it needs to 'win'
    }

    // gets racerMap Value from <K,V>
    public void show() {
        if (racerMap.isEmpty()) {
            System.out.println("There are currently No Winners in the board");
        }
        else {
            System.out.println("             DUCK RACE RESULTS                 ");
            System.out.println("================================================\n");
            System.out.println("id        name           wins          rewards");
            System.out.println("--        ----          -----          --------");


            Collection<DuckRacer> allRacers = racerMap.values(); // return Collection<V>

            for (DuckRacer racer: allRacers) {
                //System.out.println(racer); // toString() automatic call
                System.out.printf("%s         %s            %s            %s\n",
                        racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());

            }
        }
    }

    /*
    * create method that get max id, Map size()
     */


    // TESTING ONLY
    void dumbStudentIdMap() {
        System.out.println(studentIdMap);
    }

    // populates studentIdMap from file conf/student-ids.csv
    private Map<Integer,String> loadStudentIdMap() {
        // declare return value (a Map)
        Map<Integer,String> idMap = new HashMap<>();


        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

            // for each line, we split string
            // then convert to Integer,String
            // add to map using .put()
            for(String line : lines) {
                String[] tokens = line.split(","); // returns 2 Strings: "1" | "Caleb"
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                idMap.put(id, name); // add to map
            }
        }
        catch (IOException e) {

            e.printStackTrace();
        }

        return idMap;

    }
}