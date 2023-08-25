import java.util.*;
import java.io.*;

class Main {
    // DFS는 보통 500만, 1000만회 정도 돌리고 그 이상 돌리면 타임아웃에러가 난다.
    // 지금 문제를 풀 때 최악의 수에서 10억까지 경우의 수가 늘어나기 때문에, 
    // N의 길이를 반으로 쪼개서 각각 이진 탐색으로 풀어야 타임아웃에러가 발생하지 않는다! 
    
    static int N, C;
    
    public static int binarySearch(ArrayList<Integer> sum, int target) {
        int left = 0, right = sum.size() - 1, mid, answer = -1;
        
        while(left <= right) {
            mid = (left + right) / 2;
            if(sum.get(mid) <= target) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    
    public static void dfs(int idx, int sum, ArrayList<Integer> weight, ArrayList<Integer> answer) {
        // 3. 탈출 조건
        if(sum > C) {
            return;
        }
        
        if(idx == weight.size()) {
            answer.add(sum);
            return;
        }
        
        // 1. 물건을 넣는 경우 
        dfs(idx + 1, sum + weight.get(idx), weight, answer);
        
        // 2. 물건을 안 넣는 경우
        dfs(idx + 1, sum, weight, answer);
        
    }
    
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ArrayList<Integer> weight1 = new ArrayList<>();
        ArrayList<Integer> weight2 = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            if(i < N / 2) {
                weight1.add(Integer.parseInt(st.nextToken()));
            } else {
                weight2.add(Integer.parseInt(st.nextToken()));
            }
        }
        
        // 1. DFS로 sum1 sum2 만들기
        ArrayList<Integer> sum1 = new ArrayList<>();
        ArrayList<Integer> sum2 = new ArrayList<>();
        
        dfs(0, 0, weight1, sum1);
        dfs(0, 0, weight2, sum2);
        
        // 2. sort 및 binary search
        Collections.sort(sum2);
        int answer = 0;
        for(int i = 0; i < sum1.size(); i++) {
            int searchValue = C - sum1.get(i);
            answer += binarySearch(sum2, searchValue) + 1;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}