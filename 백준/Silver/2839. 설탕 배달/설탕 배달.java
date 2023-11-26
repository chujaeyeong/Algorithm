import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[5001]; 
        
        for (int i = 8; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[3] = dp[5] = 1;
        dp[4] = dp[7] = -1;
        dp[6] = 2;
        
        for (int i = 8; i <= N; i++) {
            if (dp[i-3] != -1 && dp[i-5] != -1) {
                dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
            } else if (dp[i-3] != -1) {
                dp[i] = dp[i-3] + 1;
            } else if (dp[i-5] != -1) {
                dp[i] = dp[i-5] + 1;
            } else {
                dp[i] = -1;
            }
        }
        
        System.out.print(dp[N]);
        
    }
}