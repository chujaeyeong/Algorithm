import java.io.*;

public class Main {
    
    static int[] parents;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        parents = new int[G + 1];
        for (int i = 1; i < G + 1; i++) {
            parents[i] = i;
        }
        
        int P = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < P; i++) {
            int l = Integer.parseInt(br.readLine());
            if (find(l) == 0) {
                break;
            }
            cnt++;
            union(find(l), find(l) - 1);
        }
        
        System.out.println(cnt);
    }
    
    
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parents[a] = b;
    }
    
    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]); 
    }
    
}