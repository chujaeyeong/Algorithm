class Solution {
    public int solution(int n) {
        // 순서쌍의 개수 = n의 약수 개수
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}