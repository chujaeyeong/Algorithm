class Solution {
    public String solution(int age) {
        String answer = "";
        String age962 = "abcdefghij"; // j까지
        String[] ageArr = String.valueOf(age).split(""); // age를 한 자리씩 끊어서 배열에 저장
        
        for (int i = 0; i < ageArr.length; i++) {
            answer += age962.charAt(Integer.valueOf(ageArr[i]));
        }
        
        return answer;
    }
}