import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // N 변수 저장 
        
        // 사용 변수 초기화 (count, startIndex, endIndex, sum)
        int count = 1; 
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        
        while(endIndex != N) {
            if(sum == N) { // count 증가, enbIndex 증가, sum값 변경 
                count++;
                endIndex++;
                sum = sum + endIndex;
            } else if (sum > N) { // sum값 변경, startIndex값 증가 
                sum = sum - startIndex;
                startIndex++;
            } else { // endIndex 증가, sum값 변경 
                endIndex++;
                sum = sum + endIndex;
            }
        }
        
        System.out.println(count);
        sc.close();
        
    }
}