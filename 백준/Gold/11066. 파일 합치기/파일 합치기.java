import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int[] files = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < files.length; j++) {
                files[j] = Integer.parseInt(st.nextToken());
            }

            int[] sum = new int[k];
            sum[0] = files[0];
            for (int s = 1; s < sum.length; s++) {
                sum[s] = sum[s - 1] + files[s];
            }

            bw.write(String.valueOf(solution(files, sum)));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
    
    
    private static int sumDist(int[] sum, int start, int end) {
        if (start == 0) {
            return sum[end];
        }

        return sum[end] - sum[start - 1];
    }
    
    
    private static int solution(int[] files, int[] sum) {
        int[][] dp = new int[files.length][files.length];

        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i + 1] = files[i] + files[i + 1];
        }

        for (int j = 2; j < dp.length; j++) {
            for (int i = 0; i + j < dp.length; i++) {
                for (int k = i; k < i + j; k++) {
                    if (dp[i][i + j] == 0) {
                        dp[i][i + j] = dp[i][k] + dp[k + 1][i + j] + sumDist(sum, i, i + j);
                    } else {
                        dp[i][i + j] = Math.min(dp[i][i + j], dp[i][k] + dp[k + 1][i + j] + sumDist(sum, i, i + j));
                    }
                }
            }
        }

        return dp[0][dp.length - 1];
    }
    
    
}