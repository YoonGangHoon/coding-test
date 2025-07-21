package searching.DFS;
import java.util.ArrayList;
import java.util.Scanner;

public class Boj13023 {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    static boolean arrive;

    public static void main(String[] args) {
        arrive = false;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        for (int i=0;i<N;i++){
            A[i] = new ArrayList<Integer>();
        }
        for (int i=0;i<M;i++){
            int S = scanner.nextInt();
            int E = scanner.nextInt();
            A[S].add(E);
            A[E].add(S);
        }
        for (int i=0;i<N;i++){
            DFS(i, 1);
            if (arrive) break;
        }
        if (arrive) System.out.println("1");
        else System.out.println("0");
        scanner.close();
    }

    public static void DFS(int now, int depth){
        if (depth == 5 || arrive){ // 깊이가 5거나 이미 조건을 다 만족했다면 중단
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int i:A[now]){
            if (!visited[i]){
                DFS(i, depth+1);
            }
        }
        visited[now] = false; // 다른 노드에서 다시 방문할 수 있게 백트래킹
    }
}
