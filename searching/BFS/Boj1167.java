package searching.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1167 {
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N+1];
        for (int i=1;i<=N;i++){
            A[i] = new ArrayList<Edge>();
        }
        for (int i=0;i<N;i++){
            int S = sc.nextInt();
            while (true) {
                int E = sc.nextInt();
                if (E==-1) break;
                int V = sc.nextInt();
                A[S].add(new Edge(E, V));
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(1);
        int Max = 1;
        for (int i=2;i<=N;i++){
            if (distance[Max] < distance[i]){
                Max = i;
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    public static void BFS(int node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int current_node = queue.poll();
            for (Edge i:A[current_node]){
                int e = i.e;
                int value = i.value;
                if (!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[current_node] + value;
                }
            }
        }
    }
}

class Edge{
    int e;
    int value;
    public Edge(int e, int value){
        this.e = e;
        this.value = value;
    }
}