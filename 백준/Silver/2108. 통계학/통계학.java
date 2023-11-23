import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 입력값의 범위 맞춰서 배열 arr 선언 (-4000 ~ 4000)
        int[] arr = new int[8001];
        
        int sum = 0; // 총 합계
        int max = Integer.MIN_VALUE; // 최댓값
        int min = Integer.MAX_VALUE; // 최솟값 
        int mid = 10000; // 중앙값 (배열에 없는 수로 초기화)
        int mode = 10000; // 최빈값 (배열에 없는 수로 초기화)
        
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[value + 4000]++;
            
            if (max < value) {
                max = value;
            }
            if (min > value) {
                min = value;
            }
        }
        
        // 순회 
        int count = 0; // 중앙값 빈도 누적 수 
        int mode_max = 0; // 최빈값의 최댓값 
        
        // 이전의 동일한 최빈값이 1번만 등장했을 경우 true, 아니면 false
        boolean flag = false;
        
        for (int i = min + 4000; i <= max + 4000; i++) {
            if (arr[i] > 0) {
                // 중앙값 찾기 
                if (count < (N+1) / 2) { // 누적횟수가 전체 길이의 절반에 못 미친다면 
                    count += arr[i]; // i값의 빈도수를 count에 누적 
                    mid = i - 4000;
                }
                
                // 최빈값 찾기 
                if (mode_max < arr[i]) { // 이전 최빈값보다 현재 값의 빈도수가 더 높을 경우 
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true; // 첫 등장이므로 true로 변경 
                } else if (mode_max == arr[i] && flag == true) { // 이전 최빈값의 최댓값과 동일한 경우면서, 한 번만 중복되는 경우 
                    mode = i - 4000;
                    flag = false;
                }
            }
        }
        
        System.out.println((int)Math.round((double)sum / N)); // 산술 평균
        System.out.println(mid); // 중앙값
        System.out.println(mode); // 최빈값 
        System.out.println(max - min); // 범위
        
    }
}