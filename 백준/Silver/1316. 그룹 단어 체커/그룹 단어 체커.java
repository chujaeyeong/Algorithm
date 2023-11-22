import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = n;  //그룹 단어의 개수
        
        for(int i = 0; i < n; i++) {
            // 이미 나타난 문자 확인용 배열 arr 선언 (26 = 알파벳 개수)
            boolean[] arr = new boolean[26];
            String s = br.readLine();
            arr[(int)s.charAt(0) - 97] = true; // 첫 단어 확인 
            
            for(int j = 1; j < s.length(); j++) {
                char c = s.charAt(j);
                
                if(c == s.charAt(j-1)) { // 이전 문자와 같으면 continue
                    continue;
                }
                if(arr[(int)c - 97]) { // 이전 문자와 다르고 이미 나타난 문자면 그룹 단어로 카운팅 X
                    count--;
                    break;
                }
                
                arr[(int)c - 97] = true; // 나타난 단어라고 확인 
            }
            
        }
        
        System.out.print(count);
    }
}