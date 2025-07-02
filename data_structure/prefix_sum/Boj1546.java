package data_structure.prefix_sum;

import java.util.Scanner;

public class Boj1546 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int numbers[] = new int[n];
        double max = 0;
        for (int i=0;i<n;i++){
            int number = sc.nextInt();
            if (number > max){ max = number; }
            numbers[i] = number;
        }

        double sum = 0;
        for (int number:numbers){
            sum += (number/max)*100;
        }

        System.out.println(sum/n);
        sc.close();
    }
}
