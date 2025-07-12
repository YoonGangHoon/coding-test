package sorting.merge_sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj2751 {
    public static int[] A, tmp;
    public static long result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        A = new int[N+1];
        tmp = new int[N+1];
        for (int i=1;i<=N;i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(1, N);
        for (int i=1;i<=N;i++){
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void mergeSort(int start, int end){
        if (end-start<1){
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(start, mid); // 2개로 나눠서 왼쪽에서 재귀적 시행
        mergeSort(mid+1, end); // 오른쪽
        for (int i=start;i<=end;i++){
            tmp[i] = A[i];
        }
        int k = start;
        int index1 = start;
        int index2 = mid+1;
        while (index1 <= mid && index2 <= end) {

            // 작은 거 A[k]에 넣고 인덱스 한 칸 씩 이동
            if (tmp[index1] > tmp[index2]){
                A[k++] = tmp[index2++];
            }
            else{
                A[k++] = tmp[index1++];
            }
        }
        // 남은 거 처리하기
        while (index1<=mid) {
            A[k++] = tmp[index1++];
        }
        while (index2<=end) {
            A[k++] = tmp[index2++];
        }
    }
}
