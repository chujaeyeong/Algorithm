import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int num = 666;
        int count = 1;
        
        while (count != N) {
            num++;
            
            // int형인 num을 String으로 변환 후, "666"이란 문자열이 있는지 검사 
            if (String.valueOf(num).contains("666")) {
                count++;
            }
        }
        
        System.out.print(num);
    }
}