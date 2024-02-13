import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] arr = new String[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        } 
        
        Arrays.sort(arr, new Comparator<String>() {
           public int compare(String s1, String s2) {
               // 단어 길이가 같을 경우 
               if (s1.length() == s2.length()) {
                   return s1.compareTo(s2);
               } else { // 그 외의 경우 
                   return s1.length() - s2.length();
               }
           } 
        });
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(arr[0]).append('\n');
        
        for (int i = 1; i < N; i++) {
            // 중복되지 않는 단어만 출력 
            if (!arr[i].equals(arr[i - 1])) {
                sb.append(arr[i]).append('\n');
            }
        }
        
        System.out.println(sb);
    }
}