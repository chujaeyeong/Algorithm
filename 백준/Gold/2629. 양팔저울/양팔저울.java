import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] chu;
    static int num;
    static int[] gusul;
    static boolean[][] cache;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        chu = new int[N];
        for(int i = 0 ; i < N ; i++){
            chu[i] = Integer.parseInt(st.nextToken());
        }
        
        num = Integer.parseInt(br.readLine());
        gusul = new int[num];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < num ; i++) {
            gusul[i] = Integer.parseInt(st.nextToken());
        }
        cache = new boolean[N+1][40001];
        dp(0,0);
        
        for(int i = 0 ; i < num ; i++) {
            boolean isPossible = false;
            for(int j = 0 ; j < N+1 ; j++) {
                if(cache[j][gusul[i]]) {
                    System.out.print("Y ");
                    isPossible = true;
                    break;
                }
            }
            if(!isPossible) System.out.print("N ");
        }
        
    }

    private static void dp(int n, int weight) {
        if (weight < 0 || weight > 40000) return;
        if (cache[n][weight]) return;
        cache[n][weight] = true;
        if (n == N) return;

        dp(n + 1, weight + chu[n]); // 현재꺼를 더하는 경우
        dp(n + 1, weight); // 현재꺼를 더하지 않는 경우
        dp(n + 1, (weight < chu[n]) ? chu[n] - weight : weight - chu[n]); // 현재꺼를 빼는 경우 

    }
    
}