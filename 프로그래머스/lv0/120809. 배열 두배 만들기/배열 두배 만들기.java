class Solution {
    public int[] solution(int[] numbers) {
       //답안을 작성해서 집어넣을 배열을 만들었음. 
		int[] answer = new int[numbers.length]; //{0,0,0}
		//{1,2,3} ==> {2, 4, 6}
		//1. 반복문을 이용해서 
		//2. numbers배열 인덱스 0부터 하나씩 꺼내와
		//3. 2배로 곱한 후,
		//4. answer배열 같은 위치에 넣는다.
		for(int i = 0; i < numbers.length; i++) {
			answer[i] = numbers[i] * 2;
		}
		return answer;
    }
}