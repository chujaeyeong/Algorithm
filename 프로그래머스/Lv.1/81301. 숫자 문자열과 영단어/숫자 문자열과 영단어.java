class Solution {
    public int solution(String s) {
        
        // 영단어 배열 num 생성 
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        // 문자열 s에 영단어가 있으면 replace 로 변환 
        for (int i = 0; i < num.length; i++){
            if (s.contains(num[i])) {
                s = s.replace(num[i], Integer.toString(i));
            }
        }

        return Integer.parseInt(s);
    }
}