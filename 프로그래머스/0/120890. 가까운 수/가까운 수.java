class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int diff = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < array.length; i++) {
            diff = Math.abs(n - array[i]);
            
            if (diff < min) {
                min = diff;
                answer = array[i];
            } else if (diff == min && array[i] < answer) {
                answer = array[i];
            }
        }
        
        return answer;
    }
}