package data_structure.two_pointer;

import java.util.Scanner;

public class Boj2018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n+1];
        for (int i=1;i<=n;i++){
            arr[i] = i;
        }

        int start = 1;
        int end = 1;
        int cnt = 1;

        while (start<n) {
            int sum = 0;

            for (int j=start;j<=end;j++){
                sum += j;
            }

            if (sum == n){
                cnt++;
                end++;
            }
            else if(sum<n){
                end++;
            }
            else if (sum>n){
                start++;
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}