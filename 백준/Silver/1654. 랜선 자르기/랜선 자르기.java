import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        
        long max = 0;
        
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        
        max++; // 반드시 max에서 +1 값이 되어야해서 ++ 해주기 
        
        long min = 0;
        long mid = 0;
        
        while (min < max) {
            mid = (max + min) / 2;
            long count = 0;
            
            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }
            
            // upper bound
            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        
        System.out.println(min - 1); // upper bound 으로 얻은 값 (min) 에 -1 이 최대 길이 
    }
}