package searching.binary_search;

import java.util.Scanner;

public class Boj1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        long start = 1, end = K;
        long ans = 0;

        // 작은 수의 개수가 k-1개인 중앙값을 찾는 것이 핵심
        while (start<=end) {
            long middle = (start+end)/2;
            long cnt = 0;
            for (int i=1;i<=N;i++){
                cnt += Math.min(middle/i, N); // 중앙값보다 작은 수 카운트 (각 행마다 중앙값/각 행의 첫번째 값이 중앙값보다 작거나 같은 수의 개수, 단 N보다 크면 N)
            }
            if (cnt<K){
                start = middle+1;
            }
            else{
                ans = middle;
                end = middle-1;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
