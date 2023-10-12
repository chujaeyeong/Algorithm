import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // 최대공약수 
        int d = gcd(a, b);
        
        System.out.println(d);
        System.out.println(a * b / d); // 최소공배수 
        
    }
    
    // 최대공약수 gcd 를 재귀함수로 구현 
    public static int gcd(int a, int b) {
        
        if(b == 0) {
            return a;
        }
        
        // gcd(a, b) = gcd(b, r) 이므로 (r = a % b)
        return gcd(b, a % b);
        
    }
}