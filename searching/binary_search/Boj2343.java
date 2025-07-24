package searching.binary_search;

import java.util.Scanner;

public class Boj2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int start = 0;
        int end = 0;
        for (int i=0;i<N;i++){
            A[i] = sc.nextInt();
            if (start < A[i]) start = A[i];
            end += A[i];
        }
        while (start <= end) {
            int mid = (start+end)/2;
            int sum = 0;
            int count = 0;
            for (int i=0;i<N;i++){
                if (sum + A[i] > mid){
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }
            if (sum!=0) count++; // 남은 레슨을 담을 블루레이가 하나 더 필요함
            if (count > M) start = mid+1; // 목표 개수보다 크면 하나의 크기를 더 늘리기
            else end = mid-1; // 목표 개수보다 작으면 하나의 크기를 줄이기
        }
        System.out.println(start);
        sc.close();
    }
}
