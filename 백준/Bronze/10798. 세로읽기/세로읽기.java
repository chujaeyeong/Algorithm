import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 다섯줄 입력 주어짐. s1 ~ s5 
        String s1 = br.readLine();
        int max = s1.length();
        String s2 = br.readLine();
        String s3 = br.readLine();
        String s4 = br.readLine();
        String s5 = br.readLine();
        
        // 문자열 최대 길이 구하기 
        max = Math.max(max, Math.max(s2.length(), Math.max(s3.length(), Math.max(s4.length(), s5.length()))));
        
        StringBuilder sb = new StringBuilder();
        // 각 문자열마다 문자열의 길이를 초과하지 않는지 확인하고 StringBuilder에 append 하기 
        for (int i = 0; i < max; i++) {
            if (i < s1.length()) {
                sb.append(s1.charAt(i));
            }
            if (i < s2.length()) {
                sb.append(s2.charAt(i));
            }
            if (i < s3.length()) {
                sb.append(s3.charAt(i));
            }
            if (i < s4.length()) {
                sb.append(s4.charAt(i));
            }
            if (i < s5.length()) {
                sb.append(s5.charAt(i));
            }
        }
        
        System.out.print(sb);
        
    }
}