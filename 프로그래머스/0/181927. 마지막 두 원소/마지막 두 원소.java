class Solution {
    public int[] solution(int[] num_list) {
        
        int answer[] = new int[num_list.length + 1];
        
        // answer에 num_list 값 복사
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[i];
        }
        
        // 마지막 원소(last), 그 전 원소(before) 선언
        int last = num_list[num_list.length - 1];
        int before = num_list[num_list.length - 2];
        
        // last랑 before 비교하고 answer에 값 추가
        if (last > before) {
            answer[num_list.length] = last - before;
        } else {
            answer[num_list.length] = last * 2;
        }
        
        return answer;
        
    }
}