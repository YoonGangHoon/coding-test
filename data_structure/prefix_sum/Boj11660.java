package data_structure.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11660 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n][n];
        int sumArr[][] = new int[n][n];

        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i==0 && j==0){
                    sumArr[i][j] = arr[i][j];
                }
                else if (j==0){
                    sumArr[i][j] = sumArr[i-1][n-1] + arr[i][j];
                }
                else {
                    sumArr[i][j] = sumArr[i][j-1] + arr[i][j];
                }
            }
        }

        for (int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int answer = 0;
            for (int j=x1-1;j<x2;j++){
                answer += sumArr[j][y2-1] - sumArr[j][y1-1] + arr[j][y1-1];
            }
            System.out.println(answer);
        }
        br.close();
    }
}
