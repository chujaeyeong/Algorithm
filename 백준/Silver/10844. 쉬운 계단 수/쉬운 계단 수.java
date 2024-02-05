import java.io.*;
import java.util.*;

public class Main {
    
    static Long[][] dp;
    static int N;
    final static long MOD = 1000000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        dp = new Long[N + 1][10];
        
        // 첫 번째 자릿수는 1로 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }
        
        long result = 0;
        
        for (int i = 1; i <= 9; i++) {
            result += recur(N, i);
        }
        
        System.out.println(result % MOD);
    }
    
    // digit : 자릿수, val : 자릿값
    // 첫째 자릿수는 각 val이 끝이기 때문에, 경우의 수는 1
    // -> dp[1]의 각 자릿값은 1로 초기화되어 있어야 한다
    
    static long recur(int digit, int val) {
        if (digit == 1) {
            return dp[digit][val];
        }
        
        if (dp[digit][val] == null) {
            if (val == 0) {
                dp[digit][val] = recur(digit - 1, 1);
            } else if (val == 9) {
                dp[digit][val] = recur(digit - 1, 8);
            } else {
                dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
            }
        }
        return dp[digit][val] % MOD;
    }
    
}