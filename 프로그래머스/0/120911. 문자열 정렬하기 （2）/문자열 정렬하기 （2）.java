import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] array = my_string.toLowerCase().split("");
        
        Arrays.sort(array);
        
        for (int i = 0; i < array.length; i++) {
            answer += array[i];
        }
        
        return answer;
    }
}