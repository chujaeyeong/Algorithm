import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[K + 1]; // 메모리 제한때문에 1차원 배열로 만들기 
        
        for (int T = 0; T < N; T++) {
            int coin = Integer.parseInt(br.readLine());
            for (int i = 1; i <= K; i++) {
                if (i - coin > 0) {
                    dp[i] = dp[i] + dp[i - coin];
                } else if (i - coin == 0) {
                    dp[i]++;
                }
            }
        }
        
        System.out.print(dp[K]);
    }
}