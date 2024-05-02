class Solution {
    public String solution(String letter) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] morseString; // 모스부호 알파벳
        morseString = letter.split(" "); // 띄어쓰기 기준으로 자르기 
        
        StringBuilder sb = new StringBuilder();
        for (String word : morseString) {
            for (int i = 0; i < morse.length; i++) {
                if (word.equals(morse[i])) {
                    sb.append(Character.toString(i + 'a')); // 아스키코드 활용
                }
            }
        }
        
        return sb.toString();
    }
}