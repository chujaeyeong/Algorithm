class Solution {
    public int solution(int slice, int n) {
        int answer = 0; // 피자 판 수 
        if (n <= slice) {
        	answer = 1;
        } else if ((n % slice) == 0) {
        	answer = n / slice; 
        } else {
        	answer = (n / slice) + 1;
        }
        return answer;
    }
}