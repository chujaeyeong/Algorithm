class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for (int i = 0; i < my_string.length(); i++) {
            if (Character.isUpperCase(my_string.charAt(i))) { // 대문자면, 소문자로 변경
                answer += Character.toLowerCase(my_string.charAt(i));
            } else { // 소문자면, 대문자로 변경 
                answer += Character.toUpperCase(my_string.charAt(i));
            }
        }
        
        return answer;
    }
}