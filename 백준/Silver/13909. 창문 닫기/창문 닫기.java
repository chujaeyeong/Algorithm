import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int count = 0; // 창문이 열려있는 개수 
        
        // 약수가 홀수인 것은 제곱 수 밖에 없다, 제곱 수만 카운트
        for (int i = 1; i*i <= N; i++) { 
            count++;
        }
        
        bw.write(count + "\n");
        
        br.close();
        bw.flush();
        bw.close();
        
    }
}