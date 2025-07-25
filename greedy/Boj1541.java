package greedy;

import java.util.Scanner;

public class Boj1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ex = sc.nextLine();
        String[] str = ex.split("-");
        int answer = 0;

        for (int i=0;i<str.length;i++){
            int temp = sum(str[i]);
            if (i==0){
                answer = temp;
            }
            else{
                answer -= temp;
            }
        }
        System.out.println(answer);
        sc.close();

    }

    static int sum(String a){
        int sum = 0;
        String numbers[] = a.split("[+]");
        for (int i=0;i<numbers.length;i++){
            sum+=Integer.parseInt(numbers[i]);
        }
        return sum;
    } 
}
