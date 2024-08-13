import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 10씩 나눠서 더하기
        while (true) {
            answer += n % 10;
            
            if (n < 10) {
                break;
            }
            
            n = n / 10;
        }
        
        return answer;
    }
}