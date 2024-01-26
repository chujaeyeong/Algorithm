import java.io.*;
import java.util.*;

class Main {
    
    static int[] parents;
    static List<Integer> eList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parents = new int[N + 1];
        for (int i = 1; i < N+1; i++) {
            parents[i] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        int en = Integer.parseInt(st.nextToken());
        eList = new ArrayList<>();
        
        if (en == 0) {
            System.out.println(M);
            return;
        } else {
            for (int i = 0; i < en; i++) {
                eList.add(Integer.parseInt(st.nextToken()));
            }
        }
        
        List<Integer>[] partyList = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            partyList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pn = Integer.parseInt(st.nextToken());
            
            int x = Integer.parseInt(st.nextToken());
            partyList[i].add(x);
            
            for (int j = 1; j < pn; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                partyList[i].add(y);
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = true;
            for (int num : partyList[i]) {
                if (eList.contains(find(parents[num]))) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
    
    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        
        return find(parents[x]);
    }
    
    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        
        if (eList.contains(ry)) {
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }
        
        parents[ry] = rx;
    }
    
}