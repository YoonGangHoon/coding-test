package sorting.merge_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1517 {
    public static int[] A, tmp;
    public static long result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        mergeSort(1,N);
        System.out.println(result);
    }
    public static void mergeSort(int s, int e){
        if (e-s<1){
            return;
        }
        int m = s+(e-s)/2;
        mergeSort(s, m);
        mergeSort(m+1, e);

        for (int i=s;i<=e;i++){
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m+1;
        while (index1<=m && index2<=e) {
            if (tmp[index1] > tmp[index2]){
                A[k++] = tmp[index2++];
                // 뒤쪽 데이터 값이 더 작아 선택 될 때, swap이 일어났다고 가정하고, 현재 남이 있는 앞쪽 데이터 개수만큼 결과값을 더함
                result += (m - index1 + 1);
            }
            else{
                // 앞쪽 데이터 값이 작은 경우엔 그 자리 그대로 이거나 뒤로 가기 때문에 swap이 일어났다고 볼 수 X
                A[k++] = tmp[index1++];
            }
        }
        while(index1<=m){
            A[k++] = tmp[index1++];
        }
        while(index2<=e){
            A[k++] = tmp[index2++];
        }
    }
}
