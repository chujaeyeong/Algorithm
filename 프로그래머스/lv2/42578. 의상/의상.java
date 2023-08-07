import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        
        // 1. 옷을 종류벌로 구분한다. 
        HashMap<String, Integer> map = new HashMap<>();
        for(String [] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        // 2. 입지 않는 경우를 추가해서 모든 조합을 계산한다. 
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;
        
        while(it.hasNext()) {
            answer *= it.next().intValue() + 1;
            // 입지 않는 경우도 있으니까 +1 해줘야됨 
        }
        
        // 3. 아무 종류의 옷도 입지 않는 경우의 수를 제거한다. 
        return answer - 1;
    }
}