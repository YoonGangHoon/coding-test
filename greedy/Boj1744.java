package greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        int cntZero = 0;
        int cntMinusOne = 0;
        int cntOne = 0;
        for (int i=0;i<N;i++){
            int data = sc.nextInt();
            if (data == 0){
                cntZero++;
            }
            else if (data == -1){
                cntMinusOne++;
            }
            else if (data == 1){
                cntOne++;
            }
            else if (data>0){
                positive.add(data);
            }
            else if (data<0){
                negative.add(data);
            }
        }

        int sum = 0;

        while (positive.size() >= 2) {
            int data1 = positive.remove();
            int data2 = positive.remove();
            sum+=data1*data2;
        }
        if (!positive.isEmpty())
            sum+=positive.remove();

        while (negative.size() >= 2) {
            int data1 = negative.remove();
            int data2 = negative.remove();
            sum+=data1*data2;
        }
        if (!negative.isEmpty()){
            if (cntMinusOne > 0){
                sum+=negative.remove()*(-1);
                cntMinusOne--;
            }
            else if (cntZero > 0){
                negative.remove();
                cntZero--;
            }
            else{
                sum+=negative.remove();
            }
        }


        sum+=cntMinusOne/2;
        if (cntMinusOne%2==0){
            cntMinusOne = 0;
        }
        else{
            cntMinusOne=1;
        }

        if (cntZero >= cntMinusOne){
            System.out.println(sum + cntOne);
        }
        else{
            System.out.println(sum+cntZero-cntMinusOne+cntOne);
        }
        sc.close();
    }   
}
