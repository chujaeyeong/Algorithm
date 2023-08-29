import java.util.*;

class Main {
    public static void main(String[] args) {
        // N값을 입력받기 위한 Scanner 선언  
        Scanner sc = new Scanner(System.in);
        
        // 길이 N의 숫자를 입력받아 String형 변수 sNum에 저장하기 
        int N = sc.nextInt();
        String sNum = sc.next();
        
        // sNum을 다시 char []형 변수 cNum에 변환하여 저장하기 
        char[] cNum = sNum.toCharArray();
        
        // int형 변수 sum 선언하기
        int sum = 0;
        
        // cNum 길이만큼 반복하는 for문 
        for(int i = 0; i < cNum.length; i++) {
            // 배열의 각 자릿값을 정수형으로 변환하며 sum에 더해서 누적하기 (아스키코드 활용)
            sum += cNum[i] - '0';
        }
        System.out.println(sum);
        sc.close();
    }
}