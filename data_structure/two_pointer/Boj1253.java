package data_structure.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1253 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long arr[] = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;
        for (int i=0;i<n;i++){
            if (n==2){
                break;
            }
            long target = arr[i];
            int start = 0;
            int end = n-1;
            while (start<end){
                if (start == i){
                    start++;
                }
                else if (end == i){
                    end--;
                }
                else if (arr[start] + arr[end] == target){
                    cnt++;
                    break;
                }
                else if (arr[start] + arr[end] < target) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }    
}
