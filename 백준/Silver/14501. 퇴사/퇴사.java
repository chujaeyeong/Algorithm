import java.io.*;
import java.util.*;

// 먼저 점화식을 도출한다
// 1차원 배열을 이용할거고, D[i] =  i번째 날부터 퇴사날까지 벌 수 있는 최대 수입 이라고 한다
// 1일째부터 보지 않고, 맨 뒤 날짜부터 할 수 있는 일인지를 판단할거다
// D[i] = D[i + 1] 오늘 시작되는 상담을 했을 때 퇴사일까지 끝나지 않는 경우
// D[i] = Math.max(D[i + 1], D[i + T[i]] + P[i]) 오늘 시작되는 상담을 했을 때 퇴사일 안에 끝나는 경우

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] D = new int[N+2]; // 맨 뒤에 인덱스는 안 쓰고 싶어서 N+2로 설정해둘거임 
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        
        for(int i=N; i>0; i--) {
            if(i+T[i] > N+1) { // i번째 상담을 퇴사일까지 끝낼 수 없을 때
                D[i] = D[i+1];
            } else { // i번째 상담을 퇴사일까지 끝낼 수 있을 때
                D[i] = Math.max(D[i+1], D[i+ T[i]] + P[i]);
            }
        }
        
        System.out.println(D[1]);
        
    }
}