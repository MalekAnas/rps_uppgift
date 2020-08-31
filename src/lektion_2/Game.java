package lektion_2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {


    static char ROCK = 0x270A;
    static char PAPER = 0x270B;
    static char SCISSORS = 0x270C;

    Scanner reader = new Scanner(System.in);

    String[] playerNames = new String[2];  //playerNames {player1 name, player 2 name}
    int[] playerScores = {0, 0}; // playerScores {player1 score, player2 score} initially 0-0

    int winnerIndex; //get updated when ever a side wins the round


    int gameMode; //decides if game will be vs AI or vs another player.
    int roundLimit; // number of rounds in each match

    public static void main(String[] args) {
        // write your code here

        Game game = new Game(); //
        ConsoleMessanger.printName();
        ConsoleMessanger.printInstructions();

        try {

            int consoleChoice = game.reader.nextInt();
            switch (consoleChoice) {
                case 1:
                    game.playVsAI();
                    break;
                case 2:
                    game.playVsPlayer();
                    break;
                case 0:
                    System.exit(1);
                    break;

            }


        } catch (InputMismatchException nfe) {
            System.out.println("Invalid input, enter a number!");
        }


    }

    private void playVsPlayer() {

        this.gameMode = 2;

        ConsoleMessanger.printInputNameMsg();
        this.playerNames[0] = reader.nextLine();

        ConsoleMessanger.printInputNameMsg();
        this.playerNames[1] = reader.nextLine();

        this.roundLimit = 6;


        for (int i = 1; i <= roundLimit; i++) {

            playRound(this.playerNames[0], this.playerNames[1]);


        }


    }


    private void playVsAI() {

        this.gameMode = 1;

        ConsoleMessanger.printInputNameMsg();
        this.playerNames[0] = reader.nextLine();

        this.playerNames[1] = "Computer";


        ConsoleMessanger.roundsLimitMsg();
        this.roundLimit = reader.nextInt();


        for (int i = 1; i <= roundLimit; i++) {

            playRound(this.playerNames[0], this.playerNames[1]);


        }


    }

    private void playRound(String p1Name, String p2Name) {

        String[] playerChoices = new String[2];


        if (gameMode == 1) {


            ConsoleMessanger.pnEnterPick(p1Name);
            playerChoices[0] = reader.next();

            System.out.println(playerNames[0] + " picks " + getPickOfValue(getValueOfPick(playerChoices[0])));


            playerChoices[1] = Integer.toString(getRandomNumber(1, 4));
            System.out.println(playerNames[1] + " picks " + getPickOfValue(getValueOfPick(playerChoices[1])));


            checkWinner(playerChoices);


        }
        if (gameMode == 2) {
            ConsoleMessanger.pnEnterPick(p1Name);
            playerChoices[0] = reader.next();


            ConsoleMessanger.pnEnterPick(p2Name);
            playerChoices[1] = reader.next();

            checkWinner(playerChoices);
        }


    }

    private void checkWinner(String[] playerChoices) {
        if (isValidPick(playerChoices[0]) && isValidPick(playerChoices[1])) {

            int winner = comparePicks(playerChoices, this.playerScores);


            if (winner == 0 || winner == 1) {
                ConsoleMessanger.printWinnerMsg(playerNames[winner]);
                updatedScores(playerScores, winnerIndex);
                printScores(playerScores);
            } else if (winner == 3) {
                this.roundLimit = this.roundLimit + 1;
            }
        }
    }


    private boolean isValidPick(String choice) {
        if (choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("Rock")) {
            return true;
        }
        if (choice.equalsIgnoreCase("2") || choice.equalsIgnoreCase("Paper")) {
            return true;
        }
        if (choice.equalsIgnoreCase("3") || choice.equalsIgnoreCase("Scissors")) {
            return true;
        } else
            return false;
    }


    private int comparePicks(String[] playerChoices, int[] playerScores) {


        //p1 picks rock
        if (getValueOfPick(playerChoices[0]) == 0) {


            //p2 pick is not rock
            if (getValueOfPick(playerChoices[1]) != 0) {

                //p2 pick is a paper, p2 wins. Paper beats rock
                if (getValueOfPick(playerChoices[1]) == 1) {
                    this.winnerIndex = 1;
                    return 1;

                }
                //p2 pick is a scissor, p1 wins. Rock beats Scissors
                if (getValueOfPick(playerChoices[1]) == 2) {
                    this.winnerIndex = 0;
                    return 0;

                }

            }


            //p2 picks the same pick as p1, Tie, returns 3 which is processed later as a Tie value
            if (getValueOfPick(playerChoices[1]) == 0) {
                ConsoleMessanger.printTieMsg();
                return 3;

            }
        }



        if (getValueOfPick(playerChoices[0]) == 1) {


            if (getValueOfPick(playerChoices[1]) != 1) {

                if (getValueOfPick(playerChoices[1]) == 2) {
                    this.winnerIndex = 1;
                    return 1;
                }
                if (getValueOfPick(playerChoices[1]) == 0) {
                    this.winnerIndex = 0;
                    return 0;

                }

            }


            if (getValueOfPick(playerChoices[1]) == 1) {
                ConsoleMessanger.printTieMsg();
                return 3;

            }
        }


        if (getValueOfPick(playerChoices[0]) == 2) {


            if (getValueOfPick(playerChoices[1]) != 2) {

                if (getValueOfPick(playerChoices[1]) == 0) {
                    this.winnerIndex = 1;
                    return 1;

                }
                if (getValueOfPick(playerChoices[1]) == 1) {

                    this.winnerIndex = 0;
                    return 0;

                }

            }


            if (getValueOfPick(playerChoices[1]) == 2) {
                ConsoleMessanger.printTieMsg();
                return 3;
            }
        }

        return 3;

    }

    //adds 1 to the winner score based on the index
    private void updatedScores(int[] playerScores, int indexOfWinner) {

        for (int i = 0; i < playerScores.length; i++) {
            if (i == indexOfWinner) {
                playerScores[indexOfWinner] = playerScores[indexOfWinner] + 1;
            }
        }


    }

    //will get an int value of a string pick
    private int getValueOfPick(String pick) {

        if (pick.equalsIgnoreCase("Rock") || pick.equalsIgnoreCase("1"))
            return 0;
        if (pick.equalsIgnoreCase("Paper") || pick.equalsIgnoreCase("2"))
            return 1;
        if (pick.equalsIgnoreCase("Scissors") || pick.equalsIgnoreCase("3"))
            return 2;

        return -1;
    }


    //will get a string based on the pick
    private String getPickOfValue(int pick) {
        if (pick == 0)
            return "Rock " + ROCK;
        if (pick == 1)
            return "Paper " + PAPER;
        if (pick == 2)
            return "Scissors " + SCISSORS;


        return "Not Valid";
    }


    //print the score array
    private void printScores(int[] playerScores) {

        System.out.println(playerNames[0] + ": " + playerScores[0]);
        System.out.println(playerNames[1] + ": " + playerScores[1]);
    }

    //Generate random number in range min-max
    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    private void clearConsole() {
        try {
            new ProcessBuilder("console", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
