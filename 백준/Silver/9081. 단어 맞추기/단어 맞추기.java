import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int T = sc.nextInt();
        sc.nextLine();
        
        for(int t = 1; t <= T; t++) {
			char[] str = sc.nextLine().toCharArray();
			sb.append(String.valueOf(np(str))).append('\n');
		}
        
        System.out.println(sb);
    }
    
    // 다음 순열 알고리즘 구현 
    static char[] np(char[] str) {
        for(int i = str.length - 1; i >= 1; i--) {
            if(str[i] > str[i - 1]) { // 꼭대기 지점(i) 찾기
                for(int j = str.length - 1; j >= 1; j--) {
                    if(str[j] > str[i - 1]) { // i-1에 있는 것보다 더 큰 문자가 있으면
                        char temp = str[i - 1];
                        str[i - 1] = str[j];
                        str[j] = temp;
                        // end swap
                        
                        str = swapLast(str, i);
                        return str;
                    }
                }
            }
        }
        return str;
    }
    
    // 꼭대기 앞부분이랑 그거보다 큰 숫자를 뒤에서 찾아 서로 바꾼 후, 꼭대기부터의 문자열을 뒤집는 알고리즘 구현 
    static char[] swapLast(char[] str, int i) {
		int lastIdx = str.length-1;
		for (int j = i; j <= (i+str.length-1)/2; j++) {
			char temp = str[j];
			str[j] = str[lastIdx];
			str[lastIdx--] = temp;
		}
		return str;
	}
    
}