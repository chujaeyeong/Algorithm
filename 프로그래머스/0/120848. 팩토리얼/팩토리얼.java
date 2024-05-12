class Solution {
    
    // 팩토리얼 함수
    public int factorial (int n) {
        return (n <= 1) ? n : factorial(n - 1) * n;
    }
    
    public int solution(int n) {
        int answer = 0;
        // n의 최댓값은 10! 이니까 1부터 10까지 팩토리얼 기준
        for (int i = 1; i <= 10; i++) {
            if (factorial(i) <= n) {
                answer = i;
            }
        }
        
        return answer;
    }
}