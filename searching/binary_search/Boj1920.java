package searching.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1920 {
    static long A[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new long[N];
        for (int i=0;i<N;i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++){
            long target = Long.parseLong(st.nextToken());
            System.out.println(binarySearch(target));
        }
    }

    public static int binarySearch(long target){
        int start = 0;
        int end = A.length-1;
        while (start <= end) {
            int mid = (start+end)/2;
            long midValue = A[mid];
            if (midValue == target) return 1; // 같으면 출력
            else if (midValue < target){
                start = mid + 1; // 타겟이 더 크면 뒤 절반에서 다시 탐색
            }
            else if (midValue > target){
                end = mid - 1; // 타겟이 더 작으면 앞 절반에서 다시 탐색
            }
        }
        return 0;
    }
}
