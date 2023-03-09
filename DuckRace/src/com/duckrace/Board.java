package com.duckrace;

import java.io.*;
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

public class Board implements Serializable {
    //Static variables and methods
    private static final String dataFilePath = "data/board.dat";
    public static Board getInstance() { //If file data.board exsists, read that bianry file into a board object
        Board board = null;
        if (Files.exists(Path.of(dataFilePath))) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
                board = (Board) in.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            board = new Board();
        }
        return board;
    }

    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    public void update(int id, Reward reward) {
        //Declare and dont initialize
        DuckRacer racer = null;

        if (racerMap.containsKey(id)) {
            racer = racerMap.get(id); //Fetch existing
            racer.win(reward);
        } else {
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer); //put it in the map

        }
        racer.win(reward);
        save();
        //either way, it needs to win
    }

    //TODO Render data pretty.
    //This includes column headings, spacing (String.format("", )
    public void show() {
        if (racerMap.isEmpty()) {
            System.out.println("There are currently no winners.");
        } else {
            StringBuilder board = new StringBuilder();
            board.append("--------Duck Race Results--------");
            board.append("=================================");
            board.append("");
            Collection<DuckRacer> allRacers = racerMap.values();
            for (DuckRacer racer : allRacers) {
                System.out.println(racer); //toString automatically called
            }
        }



    }

    /*
    * Populates studentIdMap from file conf/student-ids.csv
    * */

    //Testing only
    void dumpStudentIdMap() {
        System.out.println(studentIdMap);
    }

    public int maxId () {
        return studentIdMap.size();
    }

    private void save () {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
            out.writeObject(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<Integer, String> loadStudentIdMap() {
        //declare return value
        Map<Integer, String> idMap = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));
            //for each line in lines we want to split the string into "tokens"
            for (String line : lines) {
                String[] tokens = line.split(",");
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                idMap.put(id, name);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return idMap;
    }
}