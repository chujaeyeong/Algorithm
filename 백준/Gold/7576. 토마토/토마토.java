import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M, status;
    static int[][] map;
    static boolean[][] check;
    static Queue<int[]> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken()); // x
        N = Integer.parseInt(st.nextToken()); // y
        map = new int[N][M];
        check = new boolean[N][M];
        queue = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (map[i][j] == 0) {
                    status++;
                } else if (map[i][j] == 1) {
                    check[i][j] = true;
                    queue.add(new int[] {j, i, 0});
                }
            }
        }
        
        System.out.println(bfs());
        
    }
    
    static int bfs() {
        int res = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int px = pos[0];
                int py = pos[1];
                res = pos[2];
                
                for (int d = 0; d < 4; d++) {
                    int nx = px + dx[d];
                    int ny = py + dy[d];
                    
                    if (nx < 0 || nx > M-1 || ny < 0 || ny > N-1) {
                        continue;
                    }
                    if (!check[ny][nx] && map[ny][nx] == 0) {
                        check[ny][nx] = true;
                        map[ny][nx] = 1;
                        status--;
                        queue.add(new int[] {nx, ny, res + 1});
                    }
                }
            }
            
            if (queue.isEmpty() && status == 0) {
                return res;
            }
        }
        
        return -1;
    }
    
}