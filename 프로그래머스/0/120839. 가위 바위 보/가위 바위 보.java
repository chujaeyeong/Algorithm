class Solution {
    public String solution(String rsp) {
        String answer = "";
        String[] arr = rsp.split(""); // 가위바위보 자르기
        
        // 가위 = 2, 바위 = 0, 보 = 5
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("2")) {
                answer += "0";
            } else if (arr[i].equals("0")) {
                answer += "5";
            } else {
                answer += "2";
            }
        }
        
        return answer;
    }
}