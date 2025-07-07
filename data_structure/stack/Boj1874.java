package data_structure.stack;

import java.util.Scanner;
import java.util.Stack;

public class Boj1874 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        
        int num = 1;
        boolean result = true;
        for (int i=0;i<n;i++){
            int su = arr[i];
            if (su >= num){
                while (su >= num){
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else{
                int top = stack.pop();
                if (top>su){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else{
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString());
        scanner.close();
    }
}
