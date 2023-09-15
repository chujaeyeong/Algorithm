import java.util.*;
import java.io.*;

class Main {
    
    // 상하좌우 배열을 만드는 방법 
    // 이 두 배열을 for문으로 돌릴거임 
    //                우  상  하  좌 
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static boolean[][] visited;
    // 데이터 저장 2차원 배열 A
    static int[][] A;
    // N -> row, M -> column
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        
        BFS(0, 0);
        System.out.println(A[N-1][M-1]);
        
    }
    
    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            
            for(int k=0; k<4; k++) { // 상하좌우 탐색을 하면서 BFS를 돌릴거임
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                
                if(x >= 0 && y >= 0 && x < N && y < M) { // 배열을 넘어가면 안 되고
                    if(A[x][y]!=0 && !visited[x][y]) { // 0이어서 갈 수 없거나 기방문한 배열도 안 됨 
                        // 이제 갈 수 있는 곳이다
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // 이 부분이 핵심!
                        
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
    
}