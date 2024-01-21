import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;
    
    static int N, K, xSum;
    static int[] x;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        x = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            xSum += x[i];
        }
        
        int left = 0;
        int right = xSum;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                sum += x[i];
                if (sum >= mid) {
                    cnt++;
                    sum = 0;
                }
            }
            
            if (cnt >= K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // 이진탐색이 끝나면 left > right 상태
        // cnt == K 인 경우에도 right가 유지되니까 right를 정답으로 출력
        System.out.println(right);
    }
}