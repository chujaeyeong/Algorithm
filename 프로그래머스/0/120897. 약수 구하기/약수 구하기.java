class Solution {
    public int[] solution(int n) {
        int size = 0; // answer 배열 크기 변수
        int index = 0;  // answer 배열 인덱스 변수
        
        //i가 n의 약수일 때마다 size를 1씩 증가
        for (int i = 1; i <= n; i++) {
           if (n % i == 0) {
               size++;
           } 
        }
        
        int[] answer = new int[size];
        
        for (int i = 1; i <= n; i++) {
           if (n % i == 0) {
               answer[index++] = i; 
           } 
        }
        
        return answer;
    }
}