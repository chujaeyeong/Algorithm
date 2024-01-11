import java.util.Arrays;

class Solution {
    public boolean solution(String s) {
       boolean answer = true;
        
        int size = s.length();
        if (size == 4 || size == 6) {
            char[] c = s.toCharArray();
            
            for (char x : c) {
                if (x < '0' || x > '9') {
                    answer = false;
                    break;
                }
            }
            
        } else {
            answer = false;
        }
        
        return answer;

    }
}