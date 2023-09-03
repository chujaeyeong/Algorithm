import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        // Arraysort 로 풀어도 되긴 하지만 
        // 제한시간이 널널하니까 버블정렬 연습 겸 버블정렬로 풀어보자 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정렬할 수의 개수 
        int A[] = new int[N];
        
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        // 버블 정렬을 구하는 영역 
        for(int i = 0; i < N-1; i++) {
            for(int j = 0; j < N-1-i; j++) {
                if(A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            System.out.println(A[i]);
        }
        
        sc.close();
        
    }
}