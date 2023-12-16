import java.io.*;
import java.util.*;

public class Main {

    static int M, N;

    static int[][] map;
    static int[][] dp;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M+1][N+1];
        dp = new int[M+1][N+1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // dp 초기화 
            }
        }

        System.out.println(dfs(1,1)); // 출발지점 

    }

    private static int dfs(int x, int y) {

        if (x == M && y == N) {
            //도달했을때 추가탐색 필요 없다
            return 1;
        }
        
        if (dp[x][y] != -1) {
            //-1이 아닌 경우는 이미 방문했다(메모이제이션)
            return dp[x][y];
        } else {
            //-1인 경우만 방문
            dp[x][y] = 0;
            for (int i=0; i<dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > M || ny > N) {
                    continue;
                }

                if (map[x][y] > map[nx][ny]) {
                    //현재 값이 더 큰 경우
                    dp[x][y] += dfs(nx, ny);
                }
            }

        }

        return dp[x][y];
    }
    
}