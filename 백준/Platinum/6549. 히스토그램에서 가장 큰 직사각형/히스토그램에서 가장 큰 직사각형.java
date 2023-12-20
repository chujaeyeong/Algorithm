import java.io.*;
import java.util.*;

public class Main {
    
    public static int[] histogram;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N;
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            
            if(N == 0) {
                break;
            }
            histogram = new int[N];
            
            for(int i = 0; i < N; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            
            sb.append(getArea(0,  N-1)).append('\n');
            histogram = null;
        }
        
        System.out.println(sb);
    }
    
    
    public static long getArea(int lo, int hi) {
        // 막대 폭이 1일 경우 
        if(lo == hi) {
            return histogram[lo];
        }
        
        // 1번과정 : 가운데 위치를 구한다
        int mid = (lo + hi) / 2;
        
        // 2번 과정 : 가운데 위치를 기준으로 분할하여 왼쪽 구간의 넓이와 오른쪽 구간의 넓이를 구한다 
        // 왼쪽 부분 : lo ~ mid 
        // 오른쪽 부분 : mid+1 ~ hi
        long leftArea = getArea(lo, mid);
        long rightArea = getArea(mid+1, hi);
        
        // 3번 과정 : 왼쪽과 오른쪽 중 큰 넓이를 변수에 저장한다 
        long max = Math.max(leftArea, rightArea);
        
        // 4번 과정 : 변수에 저장된 넓이와 두 구간을 합친 구간의 가장 큰 넓이를 구해 두 개 중 가장 큰 넓이를 반환
        max = Math.max(max, getMidArea(lo, hi, mid));
        
        return max;
    }
    
    
    // 중간지점 영역의 넓이를 구하는 메소드 
    public static long getMidArea(int lo, int hi, int mid) {
        int toLeft = mid; // 중간 지점으로부터 왼쪽으로 갈 변수 
        int toRight = mid; // 중간 지점으로부터 오른쪽으로 갈 변수 
        
        long height = histogram[mid]; // 높이 
        
        // 초기 넓이 (구간 폭이 1이므로 넓이는 높이가 면적이 됨)
        long maxArea = height;
        
        // 양 끝 범위를 벗어나기 전까지 반복 
        while(lo < toLeft && toRight < hi) {
            
			/*
			 *  양쪽 다음칸의 높이 중 높은 값을 선택하되, 
			 *  갱신되는 height는 기존 height보다 작거나 같아야 한다.
			 */
            if(histogram[toLeft - 1] < histogram[toRight + 1]) {
                toRight++;
                height = Math.min(height, histogram[toRight]);
            } else {
                toLeft--;
                height = Math.min(height, histogram[toLeft]);
            }
            
            // 최대 넓이 갱신 
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1)); 
        }
        
        // 오른쪽 구간을 끝까지 탐색 못 했다면 마저 탐색
		while(toRight < hi) {
			toRight++;
			height = Math.min(height, histogram[toRight]);
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1)); 
		}
        
		// 왼쪽 구간을 끝까지 탐색 못 했다면 마저 탐색
		while(lo < toLeft) {
			toLeft--;
			height = Math.min(height, histogram[toLeft]);
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1)); 
		}
        
		return maxArea;
    }
    
}