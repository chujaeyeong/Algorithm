import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[1001];
        
        while (N-- > 0) {
            arr[Integer.parseInt(st.nextToken())]++;
        }
        
        int prev = 0; // 이전까지의 대기시간 누적합
        int sum = 0; // 사람별 대기시간 총합
        
        for (int i = 0; i < 1001; i++) {
            while (arr[i]-- > 0) { // 해당 i index가 0이 될 때까지 반복 
                sum += (i + prev); // 이전까지의 대기시간과 현재 사람이 걸리는 시간을 더하기 
                prev += i; // 이전까지의 누적합에 현재 걸리는 시간을 더하기 
            }
        }
        
        System.out.println(sum);
    }
}