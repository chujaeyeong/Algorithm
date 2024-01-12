import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = new String[numbers.length];
        
        // numbers 배열을 String 으로 변환하여 arr 배열에 담기
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]); 
        }
        
        // arr 배열 정렬 
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}