package lektion_3;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter number:");
        int number = reader.nextInt();
        System.out.println(intToString(number));


        System.out.println("Enter String:");
        String s = reader.next();
        System.out.println(stringToInt(s));

    }


    private static String intToString(int number){
        String returnVal ;
        returnVal = Integer.toString(number);
        return "String number =" + returnVal;
    }



    private static int stringToInt(String s){
        try
        {
            // the String to int conversion happens here
            int returnVal = Integer.parseInt(s.trim());

            // print out the value after the conversion
            System.out.println("int i = " + returnVal);
            return returnVal;

        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return 0;
    }
}
