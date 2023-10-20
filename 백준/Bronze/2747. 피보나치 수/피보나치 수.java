import java.io.*;
import java.util.*;

class Main {
    
    static int[] D;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력받을 n 선언, DP테이블 초기화
        int n = sc.nextInt();
        D = new int[n+1];
        for(int i=0; i<=n; i++) {
            D[i] = -1;
        }
        // 가장 작은 문제 (이미 아는 값)
        D[0] = 0;
        D[1] = 1;
        
        // 피보나치 함수 call (탑다운방식으로 구현할거)
        fibo(n);
        System.out.println(D[n]);
    }
    
    // 피보나치 함수 구현 (탑다운 방식으로 구현 - 재귀함수)
    static int fibo(int n) {
        // 기존에 계산한 적이 있는 부분의 문제는 다시 계산하지 않고 리턴 (메모이제이션)
        if(D[n] != -1) {
            return D[n];
        }
        // 점화식 사용 (D[n] 을 구할 때 피보나치 함수 call)
        return D[n] = fibo(n-2) +fibo(n-1);
    }
}