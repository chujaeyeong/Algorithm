import java.io.*;
import java.util.*;

class Main {
    
    // 필요한 N, K, D배열 선언
    static int N, K;
    static int D[][];
    
    public static void main(String[] args) {
        // 이항계수 -> 조합 점화식을 이용해서 문제를 풀면 된다 (조합의 점화식을 쓸 수 있는지 물어보는 문제)
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        D = new int[N+1][N+1];
        
        // D배열 초기화 
        for(int i=0; i<=N; i++) {
            D[i][i] = 1;
            D[i][0] = 1;
            D[i][1] = i;
        }
        
        // 2. 점화식으로 D배열의 값을 채우자 
        // 조합 점화식 : D[i][j] = D[i-1][j] + D[i-1][j-1]
        for(int i=2; i<=N; i++) {
            for(int j=1; j<i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }
        // D[N][K] 를 출력 
        System.out.println(D[N][K]);
    }
}