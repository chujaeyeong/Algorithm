import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static Queue<Integer> queue;
    static int[] ranks;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        
        ranks = new int[N + 1];
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int size = Integer.parseInt(line[0]);
            
            for (int j = 2; j < size + 1; j++) {
                int a = Integer.parseInt(line[j - 1]);
                int b = Integer.parseInt(line[j]);
                
                list[a].add(b);
                ranks[b]++;
            }
        }
        
        queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (ranks[i] == 0) {
                queue.add(i);
            }
        }
        
        topologySort();
        
        boolean flag = false;
        for (int i = 1; i < N + 1; i++) {
            if (ranks[i] != 0) {
                flag = true;
                break;
            }
        }
        
        if (flag) {
            System.out.println(0);
        } else {
            System.out.println(sb.toString());
        }
     }
    
    private static void topologySort() {
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            sb.append(pos + "\n");
            
            for (int nxt : list[pos]) {
                ranks[nxt]--;
                
                if (ranks[nxt] == 0) {
                    queue.add(nxt);
                }
            }
        }
    }
    
}