class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] sArray = s.split(" ");
        
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i].equals("Z")) {
                answer -= Integer.parseInt(sArray[i - 1]);
                continue;
            }
            
            answer += Integer.parseInt(sArray[i]);
        }
        
        return answer;
    }
}