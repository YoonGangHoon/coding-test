package data_structure.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1940 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = n-1;
        int cnt = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == m){
                cnt++;
                start++;
                end--;
            }
            else if (sum < m){
                start++;
            }
            else if (sum > m){
                end--;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
