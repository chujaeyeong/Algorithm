class Solution {
    public int solution(int[] numbers, int k) {
        int index = 0; // numbers 값을 가져올 때 사용할 index 선언
        
        // k번째로 공을 던지는 사람을 먼저 구하기 
        // 한 명씩 건너 뛰어야하니까 += 2 해줄것임
        for (int i = 1; i < k; i++) {
            index += 2;
        }
        
        index %= numbers.length; // index 값이 배열보다 커질 수 있으니까 나눠주기

        return numbers[index];
    }
}