import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 수열 개수 N, 수열 배열 A[] 선언 
        int N = sc.nextInt();
        int A[] = new int[N];
        
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        
        int num = 1; // 스택에 계속 넣는 자연수 선언 (1부터 시작하니까)
        boolean result = true;
        
        for(int i = 0; i < A.length; i++) {
            int su = A[i];
            if(su >= num) {
                // 값이 같아질때까지 push와 pop을 반복하는 while문 
                while(su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                // 현재 수열값이 오름차순 자연수보다 작을 때, pop을 진행 
                int n = stack.pop(); 
                if(n > su) {
                    // 스택 pop 결괏값이 수열의 수보다 클 때, NO를 출력
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if(result) {
            System.out.println(bf.toString());
        }
        sc.close();
        
    }
}