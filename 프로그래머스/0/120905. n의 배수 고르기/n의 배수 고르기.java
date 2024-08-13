class Solution {
    public int[] solution(int n, int[] numlist) {
        int arrSize = 0;
        
        for (int num : numlist) {
            if (num % n == 0) {
                arrSize++;
            }
        }
        
        int[] answer = new int[arrSize];
        int index = 0;
        
        for (int num : numlist) {
            if (num % n == 0) {
                answer[index] = num;
                index++;
            }
        }
        
        return answer;
    }
}