import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        // 어떤 알고리즘으로 풀어도 상관은 없지만 선택정렬 공부를 위해서 
        // 이 문제는 선택정렬로 풀어보겠다 
        
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // 입력받는 정렬의 수 
        int A[] = new int[str.length()]; // 입력받은 str의 길이만큼 배열을 만들자 
        
        for(int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }
        
        // 선택정렬 
        for(int i = 0; i < str.length(); i++) {
            int Max = i;
            for(int j = i+1; j < str.length(); j++) {
                if(A[j] > A[Max]) {
                    Max = j;
                }
            }
            if(A[i] < A[Max]) {
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        
        for(int i = 0; i < str.length(); i++) {
            System.out.print(A[i]);
        }
        
        sc.close();
        
    }
}