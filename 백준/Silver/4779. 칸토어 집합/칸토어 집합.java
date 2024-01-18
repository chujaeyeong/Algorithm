import java.io.*;
import java.util.*;

class Main {
    
    static int n;
    static StringBuilder answer;
    
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str;
        while ((str = br.readLine()) != null) {
            n = Integer.parseInt(str);
            answer = new StringBuilder();
            int len = (int) Math.pow(3, n);
            
            // 길이가 3^n 이고, '-' 으로 이루어진 문자열을 미리 만들어두고, 재귀함수 시작하기 
            for (int i = 0; i < len; i++) {
                answer.append("-");
            }
            
            func(0, len); // 시작 인덱스, 시작 길이 
            System.out.println(answer);
        }
    }
    
    // 재귀함수 
    public static void func(int start, int size) { // 시작 인덱스, 문자열 사이즈 
        if (size == 1) { // 문자열 사이즈가 1이되면 리턴 
            return;
        }
        int newSize = size / 3;
        
        // 3등분한 문자열의 2번째 부분 공백처리 
        for (int i = start + newSize; i < start + 2 * newSize; i++) {
            answer.setCharAt(i, ' ');
        }
        
        func(start, newSize); // 3등분한 문자열에서 첫번째 부분 
        func(start + 2 * newSize, newSize); // 3등분한 문자열의 세번째 부분 
    }
    
}