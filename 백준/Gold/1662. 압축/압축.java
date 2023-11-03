import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        Stack<Integer> len = new Stack<>(); // 괄호 전 그냥 나온 문자의 길이를 저장하는 Stack
        Stack<Integer> mul = new Stack<>(); // 괄호 직전에 나온 숫자를 저장하는 Stack
        
        int cnt = 0;
        
        // 입력 받은 문자열을 좌에서 우로 순차적 검사 시작 
        // 문자열에서 숫자가 나오면 cnt++, (가 나오면 cnt 계산해서 len과 mul 스택에 값 추가 
        // )가 나오면 mul과 len 스택에서 원소를 뽑아서 계산하고 cnt에 할당 
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); // 문자열 잘라서 검사할거니까 c로 선언 
            if(c == '(') {
                cnt -= 1;
                int mulNum = str.charAt(i-1)-'0';
                len.add(cnt);
                mul.add(mulNum);
                cnt = 0;
            }
            else if(c == ')') {
                int val = mul.peek();
                mul.pop();
                val *= cnt;
                int plus = len.peek();
                len.pop();
                cnt = plus + val;
            }
            else {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}