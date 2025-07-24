package greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선 순위 큐는 add 될 때마다 자동 정렬
        for (int i=0;i<N;i++){
            int data = sc.nextInt();
            pq.add(data);
        }
        int data1=0, data2=0, sum=0;
        while (pq.size() != 1) {
            data1 = pq.remove();
            data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1+data2);
        }
        System.out.println(sum);
        sc.close();
    }
}
