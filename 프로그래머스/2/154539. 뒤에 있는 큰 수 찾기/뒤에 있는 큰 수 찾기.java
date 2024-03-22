import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        // 스택을 사용해서 앞뒤 수를 비교할 것임
        Stack<Integer> stack = new Stack<>();
        
        // for 문을 돌며 뒷 큰 수가 있는지 비교
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                answer[stack.pop()] = numbers[i];
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}