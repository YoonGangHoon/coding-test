package sorting.bubble_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2750 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        int arr[] = new int[N];
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }

        for (int i=0;i<N;i++){
            for (int j=i;j<N;j++){
                if (arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for (int i=0;i<N;i++){
            System.out.println(arr[i]);
        }
    }
}
