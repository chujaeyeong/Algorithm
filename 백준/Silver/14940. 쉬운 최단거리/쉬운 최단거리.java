import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static int[][] map;
    static int sx, sy;
    
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    
    public static class point {
        int x;
        int y;
        
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                // 도착지점 
                if (map[i][j] == 2) {
                    sx = i; 
                    sy = j;
                }
            }
        }
        
        bfs();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) { // 갈 수 있는 곳 
                    sb.append(map[i][j] - 2 + " "); // 시작을 2로 했기 때문에 2를 빼줘야한다 
                } else { // 못 가는 곳 
                    sb.append(0 + " ");
                }
            }
            
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void bfs() {
        Queue<point> queue = new LinkedList<>();
        
        // 도착지점을 시작지점으로 잡음 
        queue.offer(new point(sx, sy));
        map[sx][sy] = 2;
        
        while (!queue.isEmpty()) {
            point p = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dr[i];
                int ny = p.y + dc[i];
                
                // 범위를 벗어나거나 못 나가는 곳 
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0) {
                    continue;
                }
                
                // 갈 수 있는 곳이라면 이전 값 + 1
                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[p.x][p.y] + 1;
                    queue.offer(new point(nx, ny));
                }
            }
        }
    }
    
}