class Solution {
    public int[] solution(int[] num_list, int n) {
        
        int[] answer;
        
        if (num_list.length % n == 0) { // n의 배수로 딱 떨어지는 경우
            answer = new int[num_list.length / n];
        } else { // 아니면 n+1로 answer 배열 길이 지정 
            answer = new int[num_list.length / n+1];
        }
        
        int index = 0;
        for (int i = 0; i < num_list.length; i += n) {
            answer[index++] = num_list[i];
        }
        
        return answer;
    }
}