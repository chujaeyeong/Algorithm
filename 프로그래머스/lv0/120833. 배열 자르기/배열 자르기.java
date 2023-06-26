import java.util.*;
class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int size = num2 - num1 + 1; // 3
    	int[] answer = new int[size];
    	for (int i = 0; i < size; i++) {
			answer[i] = numbers[num1];
			// answer[0] = numbers[1];
			// answer[1] = numbers[2];
			// answer[2] = numbers[3];
			// i가 3이니까 answer[2]가 끝 
			num1++;
		}
        return answer;
    }
}