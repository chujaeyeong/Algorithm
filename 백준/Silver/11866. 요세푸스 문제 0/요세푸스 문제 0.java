import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        
        int index = 0; // 리스트에서 삭제할 요소를 참조할 인덱스 변수 
        
        while (N > 1) {
            index = (index + (K - 1)) % N;
            
            // index 위치에 있는 요소를 삭제함과 동시에 출력 
            sb.append(list.remove(index)).append(", ");
            N--;
        }
        
        // 마지막으로 남은 요소를 삭제함과 동시에 출력 
        sb.append(list.remove()).append('>');
        System.out.println(sb);
    }
}