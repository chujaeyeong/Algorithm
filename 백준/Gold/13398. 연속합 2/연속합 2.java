import java.io.*;
import java.util.*;

// DP 문제에서 점화식은 구분, 의미가 명확해야된다 (두루뭉실하면 안 됨)
// D[N] = D에서 N까지 길이에서 연속으로 수를 선택하여 구할 수 있는 최대 합 
// -> 이러면 예제에서 D[1]도 10이고 D[2]도 10이고 D[3]도 10인 어지러운 상황이 발생함

// 그래서 의미가 명확하고 구분되는 점화식을 세워줄것이다
// D[N] = 0에서 N까지 길이에서 "N을 포함하여" 연속으로 수를 선택하여 구할 수 있는 최대 합

// 근데 여기서는 1개의 수를 삭제할 수 있다고 했기 때문에, 1개의 점화식이 더 필요하다
// 왼쪽 오른쪽으로 나눠서 생각하고, N을 삭제할 수로 가정했을 때,
// L[N-1] + R[N+1] 을 하면 N을 1개 제거한 최댓값을 구하는 점화식을 세울 수 있다. 
// L[N] = 왼쪽에서부터 N을 포함한 최대 연속 합을 나타냄. A[i]는 i자리 수열의 수
// R[N] = 오른쪽에서부터 N을 포함한 최대 연속 합을 나타냄. 
// L[i] = Math.max(A[i], L[i-1] + A[i]);
// R[i] = Math.max(A[i], R[i+1] + A[i]);

class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int []A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // A배열 저장하기 
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 왼쪽 합배열 L 선언, A[0]으로 초기화
        int []L = new int[N];
        L[0] = A[0];
        int result = L[0];
        for(int i=1; i<N; i++) {
            L[i] = Math.max(A[i], L[i-1] + A[i]);
            result = Math.max(result, L[i]); // 연속된 수를 뽑는데 중간에 삭제를 안 하는 경우 
        }
        
        int []R = new int[N];
        R[N-1] = A[N-1];
        for(int i=N-2; i>=0; i--) {
            R[i] = Math.max(A[i], R[i+1] + A[i]);
        }
        
        // 하나를 뺄 수 있음 
        for(int i=1; i<N-1; i++) {
            int temp = L[i-1] + R[i+1]; // 수열에서 i번째 수를 하나 빼고 만들 수 있는 max
            result = Math.max(result, temp);
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}