import java.io.*;
import java.util.*;

public class Main {
    
    public static int N;
    public static int M;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M];
        visit = new boolean[N];
        
        dfs(0);
        System.out.println(sb);
    }
    
    // dfs(재귀함수) 구현 
    public static void dfs(int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1); // depth++ 는 재귀에서 빠져나와도 증가된 값이 유지되기 때문에 depth-- 를 따로 해줘야됨!
                visit[i] = false;
            }
        }
        
    }
    
}