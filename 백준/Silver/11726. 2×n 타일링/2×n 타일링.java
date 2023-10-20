import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력받을 N, DP테이블 선언, 아는거 미리 초기화 
        int N = sc.nextInt();
        long D[] = new long[1001];
        D[1] = 1; // N = 1 일때 타일 채우는 경우의 수 
        D[2] = 2; // N = 2 일때 타일 채우는 경우의 수 
        
        // 바텀업으로 문제 풀 것 (반복문 사용)
        for(int i=3; i<=N; i++) {
            D[i] = (D[i-1] + D[i-2]) % 10007;
        }
        System.out.println(D[N]);
    }
}