package sorting.bubble_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
버블 정렬 중 몇번째 loop에서 끝날 수 있는 지 묻는 문제
실제 버블 정렬 코드를 사용하면 시간 초과
자바 내장 sort를 사용
1번의 loop애서 왼쪽으로 이동할 수 있는 최대 거리는 1이라는 것을 이용
정렬 후 인덱스 값을 비교하여 가장 많이 왼쪽으로 이동한 것을 찾음
*/
public class Boj1377 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        mData arr[] = new mData[N];
        for (int i=0;i<N;i++){
            arr[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);
        int Max = 0;
        for (int i=0;i<N;i++){
            if (Max < arr[i].index - i){
                Max = arr[i].index - i;
            }
        }
        System.out.println(Max+1);
        
    }
}

// value를 기준으로 정렬하기 위해 사용
class mData implements Comparable<mData>{
    int value;
    int index;

    public mData(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o){
        return this.value - o.value;
    }
}
