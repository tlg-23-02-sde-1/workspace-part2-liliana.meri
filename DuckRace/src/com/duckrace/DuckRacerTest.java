package com.duckrace;
import java.util.List;

import static com.duckrace.Reward.*; // OK tp use * for static imports

class DuckRacerTest {

    public static void main(String[] args){

        DuckRacer racer5 = new DuckRacer(5, "Chris"); // (id, name)
        System.out.println(racer5); // toString() automatically called

        racer5.win(DEBIT_CARD);
        racer5.win(DEBIT_CARD);
        racer5.win(PRIZES);
        racer5.win(DEBIT_CARD);

        System.out.println(racer5);

        // This is a read-only thanks to Collections.unmodifiableList() in DuckRacer class
        List<Reward> rewards = racer5.getRewards(); // 4 in here now
        //rewards.add(PRIZES); // you can no longer able to cheat
        //rewards.add(PRIZES);

        racer5.win(PRIZES);
        racer5.win(PRIZES);
        System.out.println(racer5); // you'll see 6 now

    }
}