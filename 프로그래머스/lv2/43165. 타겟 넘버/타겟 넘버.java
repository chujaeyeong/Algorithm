class Solution {
    
    // 사용해야되는 멤버변수를 매번 호출하는건 부담이 되니 
    // 멤버변수로 미리 설정하고 문제를 풀자 
    int[] numbers;
    int target;
    int answer;
    
    void dfs(int index, int sum) {
        // 1. 탈출 조건 (재귀함수는 탈출 조건을 설정해주지 않으면 무한히 돌아서 스택오버플로가 발생함)
        if(index == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        // 2. 수행 동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
    
    
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        
        dfs(0,0);
        
        return answer;
    }
}