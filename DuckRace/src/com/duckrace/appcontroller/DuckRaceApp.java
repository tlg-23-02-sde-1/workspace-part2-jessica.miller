package com.duckrace.appcontroller;

import static com.duckrace.Reward.*;
import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Scanner;

/*Application "controller" Directs overrall flow of the application,
* and coordinates all user prompting, taking those inputs and passing
* them into the system*/
public class DuckRaceApp {
    private final Board board = Board.getInstance(); //reference to board
    private final Scanner scanner = new Scanner(System.in); //reference to scanner

    //high level execute method (coding with intention)
    //implement private methods from the sketch through redhighlight
    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }

    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if(input.matches("D|P")) { //Now you can safely convert input to reward
                validInput = true;

                reward = ("D".equals(input)) ? DEBIT_CARD : PRIZES;

//                if("D".equals(input)) { //or use ternary operator here
//                    reward = Reward.DEBIT_CARD;
//                } else {
//                    reward = Reward.PRIZES;
//                }
            }
        }

        return reward;
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false; //assume its wrong
        while (!validInput) {
            System.out.print("Please enter ID of winner [1-14]: " );// TODO don't hardcode 14
            String input = scanner.nextLine().trim(); //BLOCKS for input
            if (input.matches("\\d{1,2}")) { //any digit one or two times
                id = Integer.parseInt(input); //now you can safely parseint() without it blowing
                if (1 <= id && id <= 14) {
                    validInput = true;
                }
            }
        }
        return id;
    }

    private void updateBoard(int id, Reward reward) { //takes two arguments. Reference the update board in board class
        board.update(id, reward);
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("-------WELCOME TO THE DUCK-RACE APPLICATION-------"); //Files.readString("Banner.txt")
        System.out.println();
    }
}