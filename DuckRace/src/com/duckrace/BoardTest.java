package com.duckrace;
import static com.duckrace.Reward.*;
class BoardTest {

    public static void main(String[] args) {
        Board board = new Board();
        board.dumpStudentIdMap();
        System.out.println();

        board.update(3, PRIZES);
        board.update(7, PRIZES);
        board.update(9, PRIZES);
        board.update(2, PRIZES);
        board.update(6, PRIZES);

        board.show();

    }
}