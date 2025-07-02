package data_structure.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10986 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long arr[] = new long[n];
        long sumArr[] = new long[n];
        st = new StringTokenizer(br.readLine());

        for (int i=0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
            if (i==0){
                sumArr[i] = arr[i];
            } else {
                sumArr[i] = sumArr[i-1] + arr[i];
            }
        }

        long modCnt[] = new long[m];
        for (int i=0;i<n;i++){
            sumArr[i] %= m;
            modCnt[(int)sumArr[i]]++;
        }

        long cnt = modCnt[0];
        for (int i=0;i<m;i++){
            if (modCnt[i]>0){
                cnt += (long)(modCnt[i] * (modCnt[i]-1))/2;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
