import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
        // 자연수 n, 서로소의 개수 pi 선언 
		long n = Long.parseLong(br.readLine());
		long pi = n;
        
        // 오일러 피 함수 실행 
        // (오일러 피 함수는 2부터 시작)
	// i*i<=n 보다는 i<=Math.sqrt(n) (제곱근 루트 구하는 함수) 쓰는게 시간초과를 덜 유발한다는데 둘 다 테스트해봤을때 똑같은 시간이 나왔음 (140ms)
	// 난 직관적인거 선호해서 그냥 i*i<=n 으로 수정해서 다시 제출함
		for(long i=2; i*i<=n; i++) {
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
