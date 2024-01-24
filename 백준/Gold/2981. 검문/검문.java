import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr); // 입력받은 arr 배열 정렬 
        
        int gcdVal = arr[1] - arr[0]; // 음수가 되지 않도록 큰 수에서 작은 수로 빼주기 
        
        for (int i = 2; i < N; i++) {
            // 직전의 최대 공약수와 다음 수 (arr[i] - arr[i-1]) 의 최대공약수를 갱신 
            gcdVal = gcd(gcdVal, arr[i] - arr[i-1]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 최대공약수의 약수들 찾기 (전반까지만 탐색)
        for (int i = 2; i <= gcdVal / 2; i++) {
            if (gcdVal % i == 0) {
                sb.append(i + " ");
            }
        }
        
        // 마지막 최대공약수를 꼭 출력해줘야함!
        sb.append(gcdVal);
        System.out.println(sb);
    }
    
    // 최대공약수 함수 구현 
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
}