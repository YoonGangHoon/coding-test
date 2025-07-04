package sliding_window;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj11003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Deque<Node> myDeque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            int now = Integer.parseInt(st.nextToken());

            // 새로운 값이 들어올 때 현재 수보다 큰 값을 덱에서 제거
            while (!myDeque.isEmpty() && myDeque.getLast().value > now) {
                myDeque.removeLast();
            }
            myDeque.addLast(new Node(now, i));

            // 범위에서 벗어난 값 제거
            if (myDeque.getFirst().index <= i-l){
                myDeque.removeFirst();
            }

            bw.write(myDeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
