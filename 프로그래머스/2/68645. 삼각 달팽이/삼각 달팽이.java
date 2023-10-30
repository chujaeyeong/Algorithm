import java.util.*;

class Solution {
    
    // 아래, 오른쪽, 왼쪽 위 이렇게 3개 방향을 쓸 거니까 
    // x좌표의 변화량을 dx, y좌표의 변화량을 dy로 선언
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};
    
    public int[] solution(int n) {
        
        // 가로 n, 세로 n의 삼각형을 표현하기 위해 n * n의 2차원 배열 선언
        // 채워 넣을 변수를 v로 선언, 숫자를 triangle에 기록할 때마다 1씩 증가하게 할 것임 
        int[][] triangle = new int [n][n];
        int v = 1;
        
        // 숫자를 채운 현재 위치를 (0, 0)으로 설정 
        // 방향 변수 d 추가 
        int x = 0;
        int y = 0;
        int d = 0;
        
        // 방향에 따라 이동할 수 없을 때까지 반복하면서 숫자를 채울 것임
        // 여기서는 반시계 방향으로 아래, 오른쪽, 왼쪽, 위로 이동하면서 숫자를 채울거라, 무한 루프로 작성할것임 
        while (true) {
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            // 세 가지 조건이 필요함
            // 아래 방향이나 오른쪽으로 진행할 때를 위한 nx == n || ny == n
            // 왼쪽 위로 진행할 때를 위한 nx == -1 || ny == -1
            // 이미 숫자가 써 있는 칸에 도달했음을 검사 triangle[ny][nx] != 0
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                
                // 2를 넘어가면 다시 0으로 돌아오는 로직
                d = (d + 1) % 3;
                
                nx = x + dx[d];
                ny = y + dy[d];
                
                // 모든 숫자를 다 채웠을 때는 break로 숫자 채우기 종료 
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                    break;
                }
            }
            
            // if문 종료 후 현재 위치 업데이트
            x = nx;
            y = ny;
        }
            
        // 정답 형태로 출력하기 위해 1차원 배열 result 선언
        int[] result = new int[v - 1];
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}