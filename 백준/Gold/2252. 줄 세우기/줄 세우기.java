import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 학생 수 N, 키를 비교한 횟수 M 선언 
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        // 학생 수만큼 인접 리스트 초기화하기 (ArrayList)
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            A.add(new ArrayList<>());
        }
        
        // 진입 차수 배열 초기화하기 
        int indegree[] = new int[N+1];
        
        for(int i=0; i<M; i++) {
            // 인접 리스트 데이터 저장하기 
            int S = sc.nextInt();
            int E = sc.nextInt();
            
            //진입 차수 배열 초기 데이터 저장하기 
            A.get(S).add(E);
            indegree[E]++;
        }
        
        // 위상정렬 실행 
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            // 진입 차수 배열의 값이 0인 학생(노드)를 큐에 삽입
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 큐가 빌 때까지 도는 while문 작성 
        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " "); // 현재 노드값 출력하기 
            
            for(int next : A.get(now)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}