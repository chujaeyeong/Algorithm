import java.util.*;

class Solution {
    public Deque<Integer> solution(int[] numbers, String direction) {
        // Deque 자료구조 활용
        Deque<Integer> deq = new ArrayDeque<>();
        
        for (int num : numbers) {
            deq.add(num);
        }
        
        if (direction.equals("left")) {
            int temp = deq.pollFirst(); // 맨 처음 원소를 뽑아서 
            deq.addLast(temp); // 맨 마지막 자리에 넣기
        } else {
            int temp = deq.removeLast(); // 맨 마지막 원소를 뽑아서
            deq.addFirst(temp); // 맨 처음 자리에 넣기
        }
        
        return deq;
    }
}