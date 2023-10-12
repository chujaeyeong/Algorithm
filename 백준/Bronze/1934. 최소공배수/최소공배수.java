import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int d = gcd(a, b);
            
            sb.append(a * b / d).append('\n');
        }
        
        System.out.println(sb);
    }
    
    // 최대공약수 gcd 를 재귀함수로 구현
	public static int gcd(int a, int b) {
	    
        if (b == 0) {
            return a;
        }
            
		// GCD(a, b) = GCD(b, r)이므로 (r = a % b)
		return gcd(b, a % b);
	}
}