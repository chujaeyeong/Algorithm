import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int count = 0;
        
        while(N > 0) {
            if(N % 5 == 0) { // 5로 나뉘는 경우 
                count += N / 5;
                break;
            }
            
            // 5로 나뉘지 않으면 2씩 빼기
            N -= 2;
            count++;
        }
        
        if(N < 0) { // 거스름돈 못 주는 경우 (0보다 작음)
            System.out.print(-1);
        } else {
            System.out.print(count);
        }
        
    }
}