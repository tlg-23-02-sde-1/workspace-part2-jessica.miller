package com.duckrace;

import java.util.List;

import static com.duckrace.Reward.*;

class DuckRacerTest {

    public static void main(String[] args) {
        DuckRacer racer5 = new DuckRacer(5, "Chris");

        racer5.win(DEBIT_CARD);
        racer5.win(PRIZES);
        racer5.win(DEBIT_CARD);
        racer5.win(PRIZES);
        racer5.win(DEBIT_CARD);

        System.out.println(racer5);

        List<Reward> rewards = racer5.getRewards(); //This is a readonly live view - can't alter the reward amount

        racer5.win(DEBIT_CARD);
        racer5.win(PRIZES);

        System.out.println(racer5);
    }
}