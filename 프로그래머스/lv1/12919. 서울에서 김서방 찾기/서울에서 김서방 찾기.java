class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        
        int findIndex = 0;
		// Kim이 어디있는지 위치를 찾아보세요! 
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim")) {
				findIndex = i;
			}
		}
		
		answer = "김서방은 "+findIndex+"에 있다";
        
        return answer;
    }
}