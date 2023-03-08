package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;
import java.util.Scanner;
import static com.duckrace.Reward.*;
/*
 * Application "controller" Directs overall flow of the APP,
 * & coordinates all user prompting, taking those inputs and passing
 * them into the system.
 */
public class DuckRaceApp {
    private Board board = new Board();
    private final  Scanner scanner = new Scanner(System.in);


    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }


    // private methods for => execute() method
    private Reward promptForReward() {
        Reward reward = null;

        boolean validInput = false;
        while(!validInput) {
            System.out.print("Please enter [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")){
                validInput = true;
                reward = ("D".equals(input)) ? DEBIT_CARD : PRIZES;

                /*if ("D".equals(input)) {
                    reward = Reward.DEBIT_CARD;
                }
                else
                {
                    reward = Reward.PRIZES;
                }
                */
            }
        }

        return reward;
    }

    private int promptForId() {
        int id = 0;

        boolean validInput = false;
        while(!validInput) {
            System.out.print("Please enter id of the winner [1-14]: "); // TODO, no hardcode
            String input = scanner.nextLine().trim(); // BLOCKS for input
            if (input.matches("\\d{1,2}")) {          // any digit, one or two times
                id = Integer.parseInt(input);         // now safely parseInt()
                if(id >= 1 && id <= 14) {
                    validInput = true;
                }
            }
        }
        return id;
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("W E L C O M E   T O   T H E   D U C K R A C E    A P P L I C A T I O N");
        System.out.println();
    }
}