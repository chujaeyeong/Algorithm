import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        // 시작수 N, 종료 수 M, 소수 배열 A 선언 
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int []A = new int[N+1];
        
        // 소수 배열에 값 채워넣기
        for(int i=2; i<=N; i++) {
            A[i] = i;
        }
        
        // 에라토스테네스의 체
        // 먼저, N제곱근까지 반복하는 for문으로 시작 
        for(int i=2; i<=Math.sqrt(N); i++) {
            // 소수가 아니면 넘어가자 
            if(A[i] == 0) {
                continue;
            }
            // 소수의 배수 값을 N까지 반복하는 for문 시작 
            for (int j= i+i; j<=N; j=j+i) {
                // 이 수가 소수가 아니라는 것을 0으로 표시 (제거)
                A[j] = 0;
            }
        }
        // M ~ N까지 반복하고, A 배열에서 소수인 값을 출력하자 
        for(int i=M; i<=N; i++) {
            if(A[i] != 0) {
                System.out.println(A[i]);
            }
        }
        sc.close();
    }
}