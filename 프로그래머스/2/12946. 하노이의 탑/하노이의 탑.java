import java.util.*;

class Solution {
    
    // 옮겨야되는 원판의 개수 n, 원판이 현재 위치한 기둥 from, 원판이 이동해야 되는 기둥 to
    // 문제에서 제시한 원판 n개를 기둥 1에서 3으로 옮기는 과정은 (n, 1, 3) 으로 나타낼 수 있다
    public int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray(new int[0][1]);
    }
    
    private void hanoi(int n, int from, int to, List<int[]> process) {
        
        if(n == 1) {
            process.add(new int[] {from, to});
            return;
        }

        int empty = 6 - from - to;

        hanoi(n-1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n-1, empty, to, process);
        
    }
}