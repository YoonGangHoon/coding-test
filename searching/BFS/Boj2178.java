package searching.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j=0;j<M;j++){
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]); // 목표 지점의 깊이 출력
    }

    public static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int k=0;k<4;k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M){ // 좌표 유효성 검사(미로를 벗어나면 안됨)
                    if (A[x][y] != 0 && !visited[x][y]){ // 갈 수 있는 칸 && 방문 검사
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // *깊이를 업데이트*
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
