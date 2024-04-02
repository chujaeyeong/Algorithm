class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '1') {
                mode = 1 - mode;
            } else if (i % 2 == mode) {
                answer += code.charAt(i);
            }
        }
        
        // 문자열이 비어있다면 EMPTY를 반환하고, 비어있지 않다면 answer 를 반환
        return "".equals(answer) ? "EMPTY" : answer;
    }
}