import java.util.*;
import java.io.*;

class Main {
    
    static boolean visited[]; // 방문 기록 저장 배열
    static ArrayList<Integer>[] A; // 그래프 데이터 저장 인접 리스트 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 노드 개수 
        int m = Integer.parseInt(st.nextToken()); // 엣지 개수 
        
        visited = new boolean[n+1];
        A = new ArrayList[n+1];
        
        // 인접 리스트의 각 ArrayList 배열을 만드는 for문 작성 
        for(int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }
        
        // 엣지 개수 m만큼 반복해서 A 인접 리스트에 그래프 데이터 저장하기 
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작점 
            int e = Integer.parseInt(st.nextToken()); // 끝점 
            A[s].add(e);
            A[e].add(s);
        }
        
        int count = 0; // 연결 요소 개수 (DFS의 개수)
        // 노드 개수 n만큼 반복하는 for문, 방문하지 않은 노드가 있으면 연결 요소 개수를 증가시켜주자 
        for(int i = 1; i < n+1; i++) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
        br.close();
    }
    
    // DFS 구현 
    private static void DFS(int v) {
        // 현재 노드가 방문 노드와 같다면 return 하기
        if(visited[v]) {
            return;
        }
        
        // visited 배열에 현재 노드 방문 기록하기 
        visited[v] = true;
        
        // 현재 노드의 연결 노드 중 방문하지 않은 노드가 있다면, 그 노드 기준으로 다시 DFS 실행 (재귀함수)
        for(int i : A[v]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
    
}