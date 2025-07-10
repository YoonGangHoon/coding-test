package sorting.insertion_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A[] = new int[N];
        for (int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 삽입 정렬
        for (int i=1;i<N;i++){
            int insert_index = i;
            int insertion = A[i];
            for (int j=i-1;j>=0;j--){
                if (A[i] > A[j]){
                    insert_index = j+1;
                    break;
                }
                if (j==0){
                    insert_index = 0;
                }
            }

            // 한 칸 씩 뒤로 밀기
            for (int j=i;j>insert_index;j--){
                A[j] = A[j-1];
            }
            A[insert_index] = insertion;
        }
        
        int S[] = new int[N];
        S[0] = A[0];
        for (int i=1;i<N;i++){
            S[i] = S[i-1] + A[i];
        }
        int sum = 0;
        for (int i=0;i<N;i++){
            sum += S[i];
        }
        System.out.println(sum);
    }
}
