import java.util.Arrays;

class Solution {
    public boolean solution(String s) {
       boolean answer = true;
		
		//0. 4글자, 6글자인지 판단해서 맞으면
		//   아래를 실행해주자.
		//글자수를 구해주자.
		int size = s.length();
		if(size == 4 || size == 6) {
			//1.글자하나씩 떨어뜨려라.
			//  for문 돌려서 하나씩 꺼낸 다음
			//  글자하나하나가 0~9사이인지 확인 
			char[] c = s.toCharArray();
			System.out.println(Arrays.toString(c));
			
			for (char x : c) {
				if(x < '0' || x > '9') {
					answer = false;
					break;
				}
			}
		}else {
			answer = false;
		}

        return answer;
    }
}