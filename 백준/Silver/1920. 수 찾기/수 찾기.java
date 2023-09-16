import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 정렬할 수의 개수 N / 탐색할 숫자의 개수 M 선언하기 
        // 정렬할 배열 A 선언하기 
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        
        // 이진탐색 돌리기 전에 정렬 A를 오름차순으로 정렬해줘야함 
        Arrays.sort(A);
        
        int M = sc.nextInt();
        
        for(int i=0; i<M; i++) {
            boolean find = false;
            int target = sc.nextInt();
            
            // 이진탐색 시작 
            // 시작 인덱스 start / 종료 인덱스 end 
            int start = 0;
            int end = A.length - 1;
            
            while(start <= end) {
                // 이진탐색 중앙값 mid 선언 
                int mid_index = (start + end) / 2;
                int mid_value = A[mid_index];
                
                if(mid_value > target) {
                    end = mid_index - 1;
                } else if(mid_value < target) {
                    start = mid_index + 1;
                } else {
                    find = true;
                    break;
                }
            }
            
            // 값을 찾으면 1, 못 찾으면 0 출력
            if(find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            
        }
        sc.close();
    }
}