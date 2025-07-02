package data_structure.array_and_list;

import java.util.Scanner;

public class Boj11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();        
        String numbers = sc.nextLine();
        int answer = 0;

        for (int i=0;i<n;i++){
            int number = Character.getNumericValue(numbers.charAt(i));
            answer = answer + number;
        }
        System.out.println(answer);
        sc.close();
    }
}