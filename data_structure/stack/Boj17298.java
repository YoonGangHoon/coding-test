package data_structure.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A[] = new int[N];
        int answer[] = new int[N];
        for (int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
            answer[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<N;i++){
            while (!stack.isEmpty()){
                int top = A[stack.peek()];
                if (top < A[i]){
                    answer[stack.pop()] = A[i];
                }
                else{
                    break;
                }
            }
            stack.push(i);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0;i<N;i++){
            bw.write(answer[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
