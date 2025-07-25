package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Boj1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][2];
        for (int i=0;i<N;i++){
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }

        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E){
                if (S[1] == E[1]){ // 종료 시간이 같은 경우
                    return S[0] - E[0];
                }
                return S[1] - E[1];
            }
        }); // 종료 시간(2번째 값)을 기준으로 오름차순 정렬

        // for (int i=0;i<N;i++){
        //     System.out.println("("+A[i][0] + "," + A[i][1] +")");
        // }

        int count = 0;
        int end = -1;
        for (int i=0;i<N;i++){
            if (A[i][0] >= end){
                end = A[i][1];
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }   
}
