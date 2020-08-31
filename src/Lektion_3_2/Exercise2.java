package Lektion_3_2;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {


        Scanner reader = new Scanner(System.in);
        Operator operator = new Operator();

        System.out.println("Enter num1:");
        int num1 = reader.nextInt();

        System.out.println("Enter num2:");
        int num2 = reader.nextInt();

        System.out.println("Enter num3:");
        int num3 = reader.nextInt();


        System.out.println("Sum is : " + operator.operateSum(num1,num2, num3));
        System.out.println("Greatest num is : " + operator.operateGreatest(num1,num2, num3));
        System.out.println("Smallest num is : " + operator.operateSmallest(num1,num2, num3));

    }
}
