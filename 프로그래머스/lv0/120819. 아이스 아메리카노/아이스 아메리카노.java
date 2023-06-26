class Solution {
    public int[] solution(int money) {
        int[] answer = {0, 0}; // 몇잔, 나머지 돈 
        int price = 5500;
        answer[0] = money / price; // 2잔 먹을 수 있음. 
        answer[1] = money % price; // 나머지 돈 
        return answer;
    }
}