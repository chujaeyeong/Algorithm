import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] array = new int[N]; // 원본 배열
        int[] arraySort = new int[N]; // 정렬된 배열
        HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>(); // 압축할 배열 
        
        for (int i = 0; i < N; i++) {
            array[i] = arraySort[i] = sc.nextInt();
        }
        
        Arrays.sort(arraySort); // 배열 정렬 
        
        // 배열의 압축값을 map에 저장 
        int rank = 0;
        
        for (int value : arraySort) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank);
                rank++;
            }
        }
        
        // 원본 배열의 순서대로 해당 압축 배열을 출력 
        StringBuilder sb = new StringBuilder();
        for (int value : array) {
            sb.append(rankMap.get(value)).append(' ');
        }
        
        System.out.print(sb);
    }
}