import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 1. Queue를 만들기 
        List<Integer> printer = new ArrayList<Integer>();
        for (int priority : priorities) {
            printer.add(priority);
        }
        
        int turn = 0;
        while (!printer.isEmpty()) {
            // 2. 0번을 꺼내서 max priority가 아니면 끝에 다시 넣기 
            Integer priority = printer.remove(0);
            if (printer.stream().anyMatch(otherPriority -> priority < otherPriority)) {
                printer.add(priority);
            } else {
                turn++;
                // 3. max Priority 가 맞다면 내가 찾는 job이 맞는지 확인하기 
                if (location == 0) {
                    break;
                }
            }
            
            location--;
            if (location < 0) {
                location = printer.size() - 1;
            }
            
        }

        
        return turn;
    }
    
}