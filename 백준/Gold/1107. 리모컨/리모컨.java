import java.io.*;
import java.util.*;

class Main {
    
    static boolean[] broken;
    static int target;
    static long count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        target = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        
        broken = new boolean[10];
        if (N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int cur = Integer.parseInt(st.nextToken());
                broken[cur] = true;
            }
        }
        
        if (target == 100) {
            System.out.println(0);
            return;
        }
        
        count = Math.abs(target - 100);
        
        dfs(0, 0);
        System.out.println(count);
    }
    
    
    public static void dfs(int idx, int click) {
        for (int i = 0; i < 10; i++) {
            if (!broken[i]) {
                int newButton = click * 10 + i;
                int cnt = Math.abs(target - newButton) + String.valueOf(newButton).length();
                count = Math.min(count, cnt);
                
                if (idx < 6) {
                    dfs(idx + 1, newButton);
                }
            }
        }
    }
    
}