import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
        // 자연수 n, 서로소의 개수 pi 선언 
		long n = Long.parseLong(br.readLine());
		long pi = n;
        
        // 오일러 피 함수 실행 
        // (오일러 피 함수는 2부터 시작, i*i<=n 보다 Math.sqrt()함수(제곱근 루트 구하는) 쓰는게 시간 초과 발생을 줄인다) 
        for(long i=2; i <= Math.sqrt(n); i++) {
			if(n%i==0) {
				pi = pi/i*(i-1);
			}
			while(n%i==0) {
				n/=i;
			}
			
		}
		if(n!=1) {
			pi = pi/n*(n-1);
		}
		System.out.println(pi);
	}
}