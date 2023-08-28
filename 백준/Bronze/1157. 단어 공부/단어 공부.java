import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 어짜피 출력을 대문자로 해야되니까 모든 문자를 대문자로 바꿔주는 toUpperCase() 사용 
        String str = br.readLine().toUpperCase();
        
        // 1. 알파벳별 counting (0번부터 25번까지(알파벳개수) 존재하는 배열로 알파벳 개수를 카운팅)
        int[] count = new int[26];
        
        int maxValue = 0; // 최댓값 변수 
        char maxChar = '?';
        for(int i = 0; i < str.length(); i++) {
            // String 의 i번째 index 를 변환해서 idx 변수에 저장 
            int idx = str.charAt(i) - 'A';
            ++count[idx];
            
            if(maxValue < count[idx]) {
                maxValue = count[idx];
                maxChar = str.charAt(i);
            } else if (maxValue == count[idx]) {
                maxChar = '?';
            }
        }
        
        // 2. 최댓값 업데이트 
        bw.write(maxChar);
        
        bw.close();
        br.close();
    }
}