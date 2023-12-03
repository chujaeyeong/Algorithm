import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Deque<Integer> deque = new ArrayDeque<>();
        
        // arr[i][0] = 0 이면 큐, 1이면 스택 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 스택에 대해선 신경 쓸 필요 없음 -> 큐 자료구조인 것만 저장 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) {
                deque.addLast(num);
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            deque.addFirst(Integer.parseInt(st.nextToken()));
            bw.write(deque.pollLast() + " ");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}