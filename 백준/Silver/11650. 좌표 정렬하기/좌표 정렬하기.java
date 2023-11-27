import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] point = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            point[i][0] = sc.nextInt();
            point[i][1] = sc.nextInt();
        }
        
        Arrays.sort(point, new Comparator<int[]>() { // 오름차순 정렬 
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        
        for (int i = 0; i < N; i++) {
            System.out.println(point[i][0] + " " + point[i][1]);
        }
        
        sc.close();        
    }
}