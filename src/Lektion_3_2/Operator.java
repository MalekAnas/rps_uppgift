package Lektion_3_2;

public class Operator {

    int num1, num2, num3;


    public Operator() {
    }

    public Operator(int num1, int num2, int num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }


    public int operateSum(int n1, int n2, int n3){

        return n1+n2+n3;

    }


    public int operateGreatest(int n1, int n2, int n3){

        int greatest = 0;
        if (n1>=n2 ){

            if (n1 >= n3){
                greatest = n1;

            }

        }

        if (n2 >= n1 ){
            if (n2>=n3){
                greatest = n2;

            }
        }
        if (n3 >=n1){
            if (n3 >= n2){
                greatest = n3;
            }
        }
        return greatest;
    }




    public int operateSmallest(int n1, int n2, int n3){

        int smallest =0;

        if (n1 <= n2 ){

            if (n1 <= n3){
                smallest= n1;

            }

        }

        if (n2 <= n1 ){
            if (n2  <= n3){
                smallest = n2;

            }
        }
        if (n3 <= n1){
            if (n3 <= n2){
                smallest = n3;
            }
        }
        return smallest;
    }


}
