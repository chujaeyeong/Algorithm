import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 입력받는 수 
        double[] arr = new double[N]; // N개의 배열 생성, 소수점 필요해서 double 배열로 선언함 
        double max = 0; // 제일 큰 값을 기억할거임 max 선언 후 초기화 
        
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextDouble();
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        
        double sum = max;
        
        for(int i = 0; i < N; i++) {
            if(arr[i] == max) {
                continue;
            }
            sum += arr[i] / 2;
        }
        
        System.out.println(sum);
    }
}