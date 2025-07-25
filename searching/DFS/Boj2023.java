package searching.DFS;

import java.util.Scanner;

public class Boj2023 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);

        sc.close();
    }

    static void DFS(int number, int digit){
        if (digit == N){
            if (isPrime(number)){
                System.out.println(number);
            }
            return;
        }
        for (int i=1;i<10;i+=2){ // 홀수만 고려
            if (isPrime(number*10+i)){
                DFS(number*10+i, digit+1);
            }
        }
    }

    static boolean isPrime(int num){ // 소수 판별
        for (int i=2; i<=num/2; i++){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
}
