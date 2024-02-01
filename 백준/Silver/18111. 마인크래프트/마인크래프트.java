import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M, B;
    static int[][] map;
    static int max = Integer.MIN_VALUE; // 입력 시 주어지는 최고 층수 
    static int min = Integer.MAX_VALUE; // 입력 시 주어지는 최저 층수 
    static int time = Integer.MAX_VALUE; // 땅을 고르는데 걸리는 시간 
    static int height = 0; // 땅을 고르고 났을 때 가장 높은 층수 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
                min = Math.min(min, map[i][j]);
            }
        }
        
        for (int k = max; k >= min; k--) {
            int t = 0; // 현재 층수로 땅을 고르는데 걸리는 시간
            int item = B; // 땅을 골랐을 때 나온 총 아이템 양
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > k) { // 층수가 원하는 층수보다 높으면
                        item += (map[i][j] - k);
                        t += 2 * (map[i][j] - k);
                    } else if (map[i][j] < k) {
                        item -= (k - map[i][j]);
                        t += (k - map[i][j]);
                    }
                }
            }
            
            if (item >= 0 && time > t) { // 시간이 더 적은 경우, 높이와 시간 갱신
                height = k;
                time = t;
            }
        }
        
        System.out.println(time + " " + height);
    }
}