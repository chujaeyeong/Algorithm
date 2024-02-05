import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        
        int out = (int) Math.round(N * 0.15);
        
        double sum = 0;
        for (int i = out; i < N - out; i++) {
            sum += nums[i];
        }
        
        int result = (int) Math.round(sum / (N - out * 2));
        System.out.println(result);
    }
}