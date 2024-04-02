class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        
        // included 가 true 일 때만 등차수열의 항을 합산
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                answer += a + (d * i);
            }
        }
        
        return answer;
    }
}