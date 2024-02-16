import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static boolean[][] checked;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
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
            }
        }
        
        map[0][0] = 9;
        int cycle = 0;
        
        while (true) {
            outsideAirIndexing();
            
            checked = new boolean[N][M];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !checked[i][j]) {
                        cnt += melting(j, i);
                    }
                }
            }
            
            if (cnt == 0) {
                break;
            }
            
            mapUpdated();
            cycle++;
        }
        
        System.out.println(cycle);
    }
    
    public static void mapUpdated() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 9;
                }
            }
        }
    }
    
    // 외부공기 인덱싱 
    public static void outsideAirIndexing() {
        Queue<int[]> queue = new LinkedList<>();
        checked = new boolean[N][M];
        
        queue.add(new int[] {0, 0});
        checked[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int px = pos[0];
            int py = pos[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                
                if (nx < 0 || nx > M-1 || ny < 0 || ny > N-1 || checked[ny][nx]) {
                    continue;
                }
                
                if (map[ny][nx] != 1) {
                    map[ny][nx] = 9;
                    checked[ny][nx] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
    
    // 치즈 녹이기 
    public static int melting(int x, int y) {
        checked[y][x] = true;
        if (map[y][x] == 1 && isAvailableMelt(x, y)) {
            map[y][x] = -1;
            return 1;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx > M-1 || ny < 0 || ny > N-1 || checked[ny][nx]) {
                continue;
            }
            
            if (map[ny][nx] == 1) {
                melting(nx, ny);
            }
        }
        
        return 0;
    }
    
    // 해당 치즈 외부마찰 2개 이상인지 확인 
    public static boolean isAvailableMelt(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx > M-1 || ny < 0 || ny > N-1) {
                continue;
            }
            
            if (map[ny][nx] == 9) {
                cnt++;
            }
        }
        
        if (cnt >= 2) {
            return true;
        }
        
        return false;
    }
    
}