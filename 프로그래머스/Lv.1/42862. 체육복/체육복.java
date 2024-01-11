import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        HashSet<Integer> reserveSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();
        
        for (int i : reserve) {
            reserveSet.add(i);
        }
        
        for (int i : lost) {
            if (reserveSet.contains(i)) {
                reserveSet.remove(i);
            } else {
                lostSet.add(i);
            }
        }
        
        // 앞뒤로 확인 후 체육복 빌려주기
        for (int i : reserveSet) {
            if (lostSet.contains(i - 1)) {
                lostSet.remove(i - 1);
            } else if (lostSet.contains(i + 1)) {
                lostSet.remove(i + 1);
            }
        }
        
        // 정답 반환 (전체 학생 수 - lostSet 에 남은 학생 수)
        return n - lostSet.size();
    }
}