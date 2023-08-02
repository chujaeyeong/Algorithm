import java.util.HashMap;

class Solution {
    
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        
        // 1. Hash map을 만든다. (participant)
        // 여기서, 동명이인이 있을 수도 있다는 전제가 있기 때문에, 
        // HashMap의 getOrDefault(player, 0) 을 써서 player 라는 value가 있으면 가져오고,
        // 아닐 경우 0을 Default로 지정해서 사용하겠다고 해야한다. value 자리에 1을 넣으면, 동명이인 예외 케이스를 
        // 처리할 수가 없기 때문에 넣어주는 것~ 
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        // 2. Hash map을 뺀다 (completion)
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }
        
        // 3. value가 0이 아닌 마지막 주자를 찾는다
        for (String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
        
    }
    
}