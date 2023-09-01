import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 카드의 개수 N, 카드 저장 자료구조 myQueue 선언
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();
        
        // 큐에 카드를 저장하는 for문
        for(int i = 1; i <= N; i++) {
            myQueue.add(i);
        }
        
        // 카드가 1장 남을 때 까지 돌리는 while 문 
        // 맨 위 카드를 버리는 poll(), 맨 위 카드를 가장 아래의 카드 밑으로 이동 poll() -> add(); 
        while(myQueue.size() > 1) {
            myQueue.poll();
            int temp = myQueue.poll();
            myQueue.add(temp);
        }
        
        // 마지막으로 남은 카드 출력 
        System.out.println(myQueue.poll());
        sc.close();
    }
}