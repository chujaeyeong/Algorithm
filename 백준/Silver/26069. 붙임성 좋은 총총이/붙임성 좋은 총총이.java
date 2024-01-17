import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Set<String> set = new HashSet<>();
        set.add("ChongChong"); // 총총이는 무조건 나오니까 추가
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String user1 = st.nextToken();
            String user2 = st.nextToken();
            
            // 춤을 추고 있는 사람을 만나면 춤을 추게 된다 -> set에 추가 
            if (set.contains(user1) || set.contains(user2)) {
                set.add(user1);
                set.add(user2);
            }
        }
        
        System.out.println(set.size());
    }
}