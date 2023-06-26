class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {0, 0};
        // answer[0] --> 짝
        // answer[1] --> 홀
        
        // num_list의 원소를 하나씩 꺼내서 
        // 짝수 홀수인지 구분 후 
        // 짝수 개수 => answer[0] 에 집어넣기 
        // 홀수 개수 => answer[1] 에 집어넣기

        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
        }
        return answer;
    }
}