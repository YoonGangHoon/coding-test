package sorting.selection_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numString = br.readLine();
        int N = numString.length();
        int numbers[] = new int[N];
        for (int i=0;i<N;i++){
            numbers[i] = Integer.parseInt(numString.substring(i, i+1));
        }

        for (int i=0;i<N;i++){
            int Max = i;
            for (int j=i;j<N;j++){
                if (numbers[j] > numbers[Max]){
                    Max = j;
                }
            } // 최댓값 찾기

            if (numbers[i] < numbers[Max]){
                int temp = numbers[i];
                numbers[i] = numbers[Max];
                numbers[Max] = temp;
            } // 현재 가리키고 있는 수가 최댓값보다 작으면 swap
        }

        for (int i=0;i<N;i++){
            System.out.print(numbers[i]);
        }
    }
}
