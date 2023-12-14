import java.io.*;

public class Main {
 
	public static int[] dp = new int[1000001];
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
 
		// -1 로 초기화
		for(int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}
		
		System.out.println(Tile(N));
		
	}
	
    // Tile 함수 구현 (재귀) -> 피보나치 수열
	public static int Tile(int N) {
		
		if(dp[N] == -1) {
			dp[N] = (Tile(N - 1) + Tile((N - 2))) % 15746;
		}
		return dp[N];
	}
 
}