class Solution {
    public String solution(String new_id) {
        
        // 정규식 넣지 않고 그냥 풀어보자 (정규식 알면 더 쉬움... 그치만 난 안 외워서 모르는걸... )
        
        // 1. 소문자로 치환 toLowerCase()
        String answer = "";
        new_id = new_id.toLowerCase();
        
        // 2. 소문자, 숫자, 빼기(-), 밑줄(_), 마침표 제외한 모든 문자 제거 isAlphabetic(), isDigit()
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (Character.isAlphabetic(ch) || Character.isDigit(ch) || 
                ch == '-' || ch == '_' || ch == '.') {
                    answer += ch;
            }
        }
        
        // 3. 마침표 2개 이상 나오면 다 한 개로 바꿔라 while
        while (answer.indexOf("..") != -1) {
            answer = answer.replace("..", ".");
        }

        // 4. 마침표가 처음이나 끝에 있으면 제거 substring() 
        // 1~3 에서 맨 앞 자리가 빈 상태라면 익셉션 발생하니까 조건 하나 더 달아주기 (isEmpty())
        if (!answer.isEmpty() && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }

        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        // 5. 빈 문자열에 a 넣기 isEmpty
        if (answer.isEmpty()) {
            answer = "a";
        }

        // 6. 길이가 16자 이상이면 짜르고 (substring) 짤랐는데 맨 뒤가 마침표면 제거 (charAt, substring)
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        // 7 길이가 2자 이하면 3자가 될 때 까지 맨 뒤 문자열을 붙여라 while
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);   
        }

        return answer;
    }
}