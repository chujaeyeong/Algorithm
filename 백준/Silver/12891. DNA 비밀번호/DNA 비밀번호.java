import java.util.*;
import java.io.*;

class Main {
    
    static int myArr[];
    static int checkArr[];
    static int checkSecret;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 데이터 저장, 변수 선언  
        int S = Integer.parseInt(st.nextToken()); // 문자열 크기 
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 크기 
        int result = 0;
        checkArr = new int[4]; // 비밀번호 체크 배열 
        myArr = new int[4]; // 현재 상태 배열 
        char A[] = new char[S]; // 문자열 데이터 
        checkSecret = 0; // 몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수 
        
        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
           checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) {
                checkSecret++;
            }
        }
        
        for(int i = 0; i < P; i++) { // 부분 문자열 처음 받을 때 세팅 
            Add(A[i]);
        }
        
        if(checkSecret == 4) {
            result++;
        }
        
        // 슬라이딩 윈도우 
        for(int i = P; i < S; i++) {
            int j = i - P; // 윈도우 크기를 유지하면서 한 칸 이동 
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4) {
                result++;
            }
        }
        
        System.out.println(result);
        br.close();
        
    }
    
    private static void Add(char c) {
        switch (c) {
            case 'A' : 
                myArr[0]++;
                if(myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C' :
                myArr[1]++;
                if(myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G' :
                myArr[2]++;
                if(myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T' :
                myArr[3]++;
                if(myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }
    
    private static void Remove(char c) {
        switch (c) {
            case 'A' : 
                if(myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C' :
                if(myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G' :
                if(myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T' :
                if(myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
    
}