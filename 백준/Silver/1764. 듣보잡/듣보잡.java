import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 입력 및 초기화 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 1. hash에 듣도 못한 사람 반영 (듣도 못한 사람의 value에 1을 채워주자)
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 0; i < N; i++) {
            hash.put(br.readLine(), 1);
        }
        
        // 2. hash에 보도 못한 사람이 존재하는지 확인 
        ArrayList<String> answer = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String name = br.readLine();
            if (hash.containsKey(name)) {
                answer.add(name);
            }
        }
        
        // 3. 출력
        Collections.sort(answer);
        bw.write(answer.size() + "\n");
        for(int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i));
            bw.newLine();
        }
        bw.flush();
        
        bw.close();
        br.close();
    }
}