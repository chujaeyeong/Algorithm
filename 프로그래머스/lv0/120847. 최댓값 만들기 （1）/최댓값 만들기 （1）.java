import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers); // 파괴형함수
		int answer = numbers[numbers.length - 1] * numbers[numbers.length - 2];
		
        return answer;
    }
}