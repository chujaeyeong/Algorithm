import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 0;
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                set.clear(); // ENTER 입력되면 HashSet을 초기화 
            } else {
                if (set.contains(s)) { // 이미 HashSet에 있으면 무시하고 진행 
                    continue;
                }
                set.add(s);
                num++;
            }
        }
        
        System.out.print(num);
    }
}