import java.util.*;
import java.io.*;

class Main {
    
    // 정답 변수 answer 선언하기 
    static int answer = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력받을 데이터 (연산) example 을 String 으로 선언
        String example = sc.nextLine();
        
        // 입력받은 데이터를 "-" 기호 기준으로 split() 수행하기 
        String[] str = example.split("-");
        for(int i=0; i<str.length; i++) {
            int temp = mySum(str[i]);
            if(i==0) {
               answer = answer + temp; 
            } else {
                answer = answer - temp;
            }
        }
        System.out.println(answer);
        sc.close();

    }
    
    // mySum 함수 구현하기 (현재 String에 있는 수를 모두 더하는 함수)
    private static int mySum(String a) {
        int sum = 0;
        
        // 현재 들어온 String a 값을 "+" 기호 기준으로 split() 수행하기
        // +를 잘 인식 못 하는 경우도 있으니까 대괄호로 감싸주는게 좋음 
        String[] temp = a.split("[+]");
        for(int i=0; i<temp.length; i++) {
            // String 값을 Integer 형으로 변환해서 리턴값에 집어넣기 
            sum = sum + Integer.parseInt(temp[i]);
        }
        return sum;
    }
    
}