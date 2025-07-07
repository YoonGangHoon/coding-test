package data_structure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj11286 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());

        /*
        PriorityQueue는 return 값에 따라
        > 0 이면 o1이 뒤,
        == 0 이면 아무데나,
        < 0 이면 o2가 뒤
        */
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (o1, o2) -> {
                int first_abs = Math.abs(o1);
                int second_abs = Math.abs(o2);
                if (first_abs == second_abs)
                    return o1 > o2 ? 1: -1; // 두 개의 절댓값이 같으면 실제로 큰 애가 뒤로
                else
                    return first_abs - second_abs; // 다르면 그냥 큰 애가 뒤로
            }
        ); 
        
        for (int i=0;i<N;i++){
            int op = Integer.parseInt(bf.readLine());
            if (op == 0){
                if (queue.isEmpty()){
                    System.out.println("0");
                }
                else{
                    System.out.println(queue.poll());
                }
            }else{
                queue.add(op);
            }
        }
    }
}
