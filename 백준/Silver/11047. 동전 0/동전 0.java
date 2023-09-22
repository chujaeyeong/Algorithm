import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 동전개수 N, 목표금액 K, 동전 데이터 배열 A 선언
        int N = sc.nextInt();
        int K = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        
        // 그리디 알고리즘 사용 -> 최대한 큰 동전 먼저 사용하기 
        // 가치가 큰 동전부터 선택해야 동전 개수를 최소로 구성할 수 있음!
        int count = 0;
        for(int i = N-1; i>=0; i--) {
            if(A[i] <= K) {
                count += (K/A[i]);
                K = K % A[i];
            }
        }
        System.out.println(count);
        sc.close();
    }
}