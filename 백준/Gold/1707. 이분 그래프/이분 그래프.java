import java.util.*;
import java.io.*;

class Main {
    
    // 그래프 데이터 저장 인접 리스트 A, 이분 그래프 체크 배열 check, 
    // DFS 방문배열 visited, 정답 출력용 IsEven 선언
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력받을 테스트케이스 선언, 테스트 케이스의 수만큼 for문으로 반복 
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            
            A = new ArrayList[V+1]; // 노드는 1번부터 시작하니까 0번을 안 쓰기 위해서 V+1 해준다 
            visited = new boolean[V+1];
            check = new int[V+1];
            IsEven = true;
            
            // A 인접 리스트의 각 ArrayList 초기화 
            for(int i=1; i<=V; i++) {
                A[i] = new ArrayList<Integer>();
            }
            
            // 에지 데이터 저장하기 
            for(int i=0; i<E; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                
                // 양쪽으로 다 갈 수 있다 
                A[start].add(end);
                A[end].add(start);
            }
            
            // 모든 노드에서 DFS 실행해야함 
            for(int i=1; i<=V; i++) {
                if(IsEven) {
                    DFS(i);
                } else {
                    break;
                }
            }
            
            if(IsEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            
        }
        
    }
    
    // DFS 함수 구현하기
    private static void DFS(int start) { // 인접리스트로 받아서 start에서 연결된 모든 노드를 탐색
        visited[start] = true;
        
        for(int i : A[start]) {
            if(!visited[i]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요함 
                check[i] = (check[start] + 1) % 2;
                DFS(i);
            } else if(check[start] == check[i]) {
                IsEven = false;
            }   
        }
        
    }
    
}