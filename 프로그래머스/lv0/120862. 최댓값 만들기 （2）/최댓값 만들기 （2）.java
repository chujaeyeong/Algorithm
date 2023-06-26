import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        
        int post = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        int pre = numbers[0] * numbers[1];
        
        int answer = 0;
        
        if(post > pre) {
            answer = post;
        } else {
            answer = pre;
        }
        
        return answer;
    }
}