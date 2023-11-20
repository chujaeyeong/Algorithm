import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double credit_sum = 0; // 학점 총합   
        double result = 0; // 학점 * 과목 평균 
        char c; // 등급 
        
        for(int i = 0; i < 20; i++) {
            double credit = 0; // 학점 
            double grade = 0; // 등급에 따른 점수 
            
            String str_arr[] = sc.nextLine().split(" ");
            credit += Double.parseDouble(str_arr[1]);
            c = str_arr[2].charAt(0);
            
            switch(c) {
                case 'A' :
                    if(str_arr[2].charAt(1) == '+') {
                        grade += 4.5;
                    } else {
                        grade += 4.0;
                    } break;

                case 'B' :
                    if(str_arr[2].charAt(1) == '+') {
                        grade += 3.5;
                    } else {
                        grade += 3.0;
                    } break;
                    
                case 'C' :
                    if(str_arr[2].charAt(1) == '+') {
                        grade += 2.5;
                    } else {
                        grade += 2.0;
                    } break;                    
                    
                case 'D' :
                    if(str_arr[2].charAt(1) == '+') {
                        grade += 1.5;
                    } else {
                        grade += 1.0;
                    } break;  
                    
                case 'F' :
                    grade += 0;
                    break;
                    
                case 'P' :
                    grade += 0;
                    credit = 0; // 패스 과목은 계산에서 제외
                    break;                    
            }
            
            credit_sum += credit;
            result += credit * grade;

        }
        
        System.out.print(result / credit_sum);
        
    }
}