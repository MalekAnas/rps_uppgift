package lektion_2;

import java.sql.Statement;

public class ConsoleMessanger {



    public static void printName(){
        System.out.println("------------------------------------------------------------");
        System.out.println("\t\t\tRock[1] Paper[2] Scissors[3]\n");
        System.out.println("------------------------------------------------------------");
    }


    public static void printInstructions(){
        System.out.println("1-Play against AI.");
        System.out.println("1-Play against Player.");
        System.out.println("------------------------------------------------------------");

    }

    public static void printInputNameMsg(){
        System.out.println("Enter your name: ");
    }

    public static void roundsLimitMsg(){
        System.out.println("Enter number of rounds you want to play: ");
        System.out.println("------------------------------------------------------------");

    }

    public static void pnEnterPick(String pn){
        System.out.println(pn + ", your turn, pick Rock[1] Paper[2] Scissors[3] ");
        System.out.println("------------------------------------------------------------");

    }

    public static void printTieMsg(){
        System.out.println("TIE");
    }

    public static void printWinnerMsg(String playerName){
        System.out.println( playerName + " WINS!");
    }
}
