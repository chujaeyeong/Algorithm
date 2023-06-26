class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        char[] c = {'수', '박'};
        
        for (int i = 1; i <= n; i++) {
            if (i%2 == 0) {
                answer.append(c[1]);
            } else {
                answer.append(c[0]);
            }
        }
        return answer.toString();
    }
}