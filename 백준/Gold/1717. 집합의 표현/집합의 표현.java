import java.io.*;
import java.util.*;

class Main {
    // 대표 노드 저장 배열 parent 선언 
    static int parent[];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 원소 개수 N, 질의 개수 M 선언 
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N+1];
        
        // 대표 노드를 자기 자신으로 초기화하기 
        for(int i=0; i<N+1; i++) {
            parent[i] = i;
        }
        
        // 실제 질의 계산하는 부분 작성 
        for(int i=0; i<M; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            // 0이면 집합 합치기 (union 연산)
            // else면 같은 집합 원소인지 확인하고 결괏값 출력하기 
            if(question == 0) {
                union(a, b);
            } else {
                boolean result = checkSame(a, b);
                if(result) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            
        }
        
    }
    
    // union 연산 구현
    private static void union(int a, int b) {
        // a와 b의 대표 노드를 찾고
        // 두 원소의 대표 노드끼리 연결하기 
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a; // 두 개 연결 
        }
    }
    
    // find 연산 
    private static int find(int a) {
        // a가 대표 노드면 리턴 
        // 아니면 a의 대표 노드값을 find(parent[a]) 값으로 저장 -> 재귀함수로 구현 
        if(a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]); // value를 index로 바꿔서 또 찾아보기 
        }
    }
    
    // 두 원소가 같은 집합인지 확인하는 checkSame 연산 구현 
    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) {
            return true;
        }
        return false;
    }
    
}