class Solution {
    public long solution(int price, int money, int count) {
        
        long answer = 0;
        long total = 0;
		
        //탄 횟수만큼 금액 늘리며 더하기
        for(int i=1; i<count+1; i++){
            total += price*i;
        }

        if(money<total) {
            answer = total-money;
        } else {
            answer = 0;
        }
        
        return answer;
    }
}