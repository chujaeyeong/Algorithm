import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //입력 받아서 점수 배열 만들기
        int num = sc.nextInt();
        double[] scores = new double[num];
        for(int i = 0; i < num; i++){
            scores[i] = sc.nextInt();
        }

        //최댓값 찾기
        double max = 0;
        for(int i = 0; i < num; i++){
            if(scores[i] > max) max = scores[i];
        }
    
        //평균 계산하기
        double sum = 0;
        for(int i = 0; i < num; i++){
            sum += (scores[i]/max)*100;
        }
        System.out.println(sum/num);
        sc.close();
    }
}