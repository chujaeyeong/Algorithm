import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> arr = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            arr.add(br.readLine());
        }
        
        int count = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            
            if (arr.contains(str)) { // 비교할 대상의 문자열이 HashSet 안에 있는지
                count++;
            }
        }
        
        System.out.println(count);
    }
}