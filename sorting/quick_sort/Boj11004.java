package sorting.quick_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11004 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int A[] = new int[N];
        for (int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }

    // 위치만 찾으면 되기 때문에 모든 수를 정렬할 필요는 없음.
    public static void quickSort(int A[], int start, int end, int K){
        if (start<end){
            int pivot = partition(A, start, end);
            if (pivot == K){
                return;
            }
            else if (pivot < K){
                quickSort(A, pivot+1, end, K);
            }
            else if(pivot > K){
                quickSort(A, start, pivot-1, K);
            }
        }
    }

    public static int partition(int A[], int start, int end){
        // 서로 붙어 있으면 작은 수 앞에 보내기
        if (start + 1 == end){
            if (A[start] > A[end]){
                swap(A, start, end);
                return end;
            }
        }

        int M = (start+end)/2;
        swap(A, start, M);
        int pivot = A[start];
        int i = start + 1, j = end;

        while (i<=j){

            // 뒤에서부터 pivot보다 작은 수 찾기
            while (j>=start+1 && pivot < A[j]) {
                j--;
            }

            // 앞에서부터 pitvot보다 큰 수 찾기
            while (i<= end && pivot > A[i]) {
                i++;
            }

            // 자리 안 맞으면 바꿔주기
            if (i<=j){
                swap(A, i++, j--);
            }
        }

        // pivot을 그룹의 중간에 저장
        A[start] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
