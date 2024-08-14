import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        List<String> answer = new ArrayList<>();
        
        // n으로 나눠서 0이면 잘라서 잘라서 저장, 남으면 남는거를 마지막에 저장
        for (int i = 0; i < (my_str.length() / n); i++) {
            answer.add(my_str.substring((n * i), (n * (i + 1))));
        }
        if (my_str.length() % n != 0) {
            answer.add(my_str.substring( (my_str.length() / n) * n));
        }
        
        return answer.toArray(new String[0]);
    }
}