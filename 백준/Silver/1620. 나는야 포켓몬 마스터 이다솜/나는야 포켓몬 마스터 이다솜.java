import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        
        HashMap<Integer, String> intMap = new HashMap<>();
        HashMap<String, Integer> strMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            intMap.put(i, name);
            strMap.put(name, i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            String tmp = br.readLine();
            if (isNum(tmp)) {
                sb.append(intMap.get(Integer.parseInt(tmp)) + "\n");
            } else {
                sb.append(strMap.get(tmp) + "\n");
            }
        }
        
        System.out.println(sb);
    }
    
    // 입력받은 문자열이 숫자인지 판별하는 isNum 메서드 구현 
    public static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
}