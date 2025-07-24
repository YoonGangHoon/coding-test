package greedy;

import java.util.Scanner;

public class Boj11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int coins[] = new int[N];

        for (int i=0;i<N;i++){
            coins[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i=N-1;i>=0;i--){
            cnt += K/coins[i];
            K = K%coins[i];
        }
        System.out.println(cnt);
        sc.close();
    }
}
