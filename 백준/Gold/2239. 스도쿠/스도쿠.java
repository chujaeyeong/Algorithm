import java.io.*;
import java.util.*;

public class Main {
    
    static final int N = 9;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = st.charAt(j) - '0';
            }
        }
        
        playSdoku();
    }
    
    
    private static void playSdoku() {
        int[] idx = findZeroIdx();
        
        // 0인 좌표가 없다면, 스도쿠를 완성한 것
        if (idx[0] == -1) {
            printSdoku();
            System.exit(0);
        }
        
        // 1부터 0인 좌표에 넣어보기 
        for (int i = 1; i <= 9; i++) {
            if (isValidPosition(idx, i)) {
                map[idx[0]][idx[1]] = i;
                playSdoku();
                map[idx[0]][idx[1]] = 0;
            }
        }
        
    }
    
    // 0인 좌표를 찾기 
    private static int[] findZeroIdx() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    return new int[] {i, j};
                }
            }
        }
        
        return new int[] {-1, -1};
    }
    
    private static boolean isValidPosition(int[] idx, int num) {
        int r = idx[0];
        int c = idx[1];
        
        // 가로 || 세로 체크 
        for (int i = 0; i < N; i++) {
            if (map[r][i] == num || map[i][c] == num) {
                return false;
            }
        }
        
        // 같은 블럭 체크 
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;
        
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static void printSdoku() {
        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer.append(map[i][j]);
            }
            answer.append("\n");
        }
        
        System.out.print(answer.toString());
    }
    
}