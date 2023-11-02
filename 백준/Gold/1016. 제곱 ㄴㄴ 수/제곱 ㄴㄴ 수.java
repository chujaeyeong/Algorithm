import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력받는 두 수의 범위가 커서 int로 선언하지 않고 long 으로 선언해주자 
        long S = Long.parseLong(st.nextToken());
        long E = Long.parseLong(st.nextToken());
        
        long count = E - S + 1;
        boolean[] check = new boolean[(int)count]; 
        
        for(long i = 2; i * i <= E; i++) {
            long pow = i*i; // 제곱수 
            long tmp = S / pow; // 제곱수로 나누기 
            if(S % pow != 0) { // 제곱수 아니면 +1
                tmp += 1;
            }
            
            for(long j = tmp; j * pow <= E; j++) {
                int canSqrt = (int)(j * pow - S);
                if(!check[canSqrt]) {
                    check[canSqrt] = true;
                    count--;
                }
            }
        }
        
        System.out.println(count);
        
    }
}