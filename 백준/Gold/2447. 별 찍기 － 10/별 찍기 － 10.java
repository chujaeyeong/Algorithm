import java.io.*;

public class Main {
    static char[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        arr = new char[N][N];
        
        star(0, 0, N, false);
        
        for (int i = 0; i < N; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
    }
    
    // 별을 찍는 재귀함수 star 구현 
    static void star(int x, int y, int N, boolean blank) {
        
        // 공백칸일 경우 
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        
        // 더 이상 쪼갤 수 없는 블록일 때 
        if (N == 1) {
            arr[x][y] = '*';
            return;
        }
        
        /*
        N = 27 일 경우 한 블록의 사이즈는 9 
        N = 9 일 경우 한 블록의 사이즈는 3
        -> 해당 블록의 한 칸을 담을 변수를 의미 (size)
        
        count = 별 출력 누적 
        */
        
        int size = N / 3;
        int count = 0;
        
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) { // 공백 칸일 경우 
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }
        
    }
}