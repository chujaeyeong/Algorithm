class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        // 자신보다 응급도가 높은 값이 있으면 answer 배열에 +1
        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < emergency.length; j++) {
                if (emergency[i] < emergency[j]) {
                    answer[i]++;
                }
            }
            
            // 응급도는 1부터 시작하니까 +1 해줌
            answer[i]++;
        }
        
        return answer;
    }
}