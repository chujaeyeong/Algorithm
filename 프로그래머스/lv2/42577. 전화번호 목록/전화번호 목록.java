import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        boolean answer = true;
        
        // 1. HashMap을 선언한다 
        Map<String, String> map = new HashMap<>();
        
        // 모든 전화번호를 HashMap에 넣는다 
        for(String number : phone_book){
            map.put(number, number);
        }
        
        // 모든 전화번호의 substring이 HashMap에 존재하는지 확인한다
        for(String check : phone_book){
            for (int i=0; i < check.length(); i++){
                // 접두어로 비교해야되니까 check.length() 보다 하나 작은 substring을 떼서 비교
                if(map.containsKey(check.substring(0,i))){
                    answer = false;
                }
            }
        }

        return answer;
    }
}