import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        char[] b = before.toCharArray();
		char[] a = after.toCharArray();
		
		Arrays.sort(b);
		Arrays.sort(a);
		
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(a));
		
		if (Arrays.equals(b, a)) {
			answer = 1;
		} else {
			answer = 0;
		}
        
        
        return answer;
    }
}