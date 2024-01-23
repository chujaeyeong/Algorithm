import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        String bomb = br.readLine();
        int str_len = str.length();
        int bomb_len = bomb.length();
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str_len; i++) {
            int count = 0;
            stack.push(str.charAt(i));
            
            if (stack.size() >= bomb_len) {
                for (int j = 0; j < bomb_len; j++) {
                    if (stack.get(stack.size() - bomb_len + j) == bomb.charAt(j)) {
                        count++;
                    }
                    
                    if (count == bomb_len) {
                        for (int k = 0; k < bomb_len; k++) {
                            stack.pop();
                        }
                    }
                }
            }
        }
        
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (char c : stack) {
                sb.append(c);
            }
        }
        
        System.out.println(sb);
    }
}