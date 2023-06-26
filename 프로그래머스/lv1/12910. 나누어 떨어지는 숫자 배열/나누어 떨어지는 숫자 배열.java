import java.util.*;
class Solution {
public int[] solution(int[] arr, int divisor) {
		
		ArrayList<Integer> list = new ArrayList<>();
		// 수도코드(가짜코드)
		// 1. 결과를 넣을 수 있는 List를 만들어둔다.
		// 2. 반복문 이용해서 배열에 있는 요소 하나씩 꺼내
		// 3. divisor로 나누었을 때 나머지가 없는지 체크해서
		// 나머지가 없으면 list에 모으자.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}
		System.out.println(list.size() + ">> " + list);
		// 2>> [5, 10]
		int[] answer = null; // {0,0}
		if (list.size() != 0) {
			answer = new int[list.size()];
			// int값 list를 배열에 자동으로 넣어주는 함수XXX!!!
			for (int i = 0; i < list.size(); i++) {
				// answer[i] <--- list.get(i)
				answer[i] = list.get(i);
				// {5, 0} <-- [5, 10]
				// {5, 10} <-- [5, 10]
			}
			Arrays.sort(answer);
		} else {
			answer = new int[1];
			answer[0] = -1;
		}
		return answer;
	}
}